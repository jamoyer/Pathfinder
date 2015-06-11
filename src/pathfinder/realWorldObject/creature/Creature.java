package pathfinder.realWorldObject.creature;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import pathfinder.characters.buffs.BonusTarget;
import pathfinder.characters.buffs.BuffManager;
import pathfinder.characters.buffs.CreatureBuff;
import pathfinder.characters.classes.CreatureClass;
import pathfinder.characters.classes.CreatureClassManager;
import pathfinder.characters.skill.Skill;
import pathfinder.metaObjects.DiceSet;
import pathfinder.realWorldObject.RealWorldObject;
import pathfinder.realWorldObject.creature.creatureType.CreatureType;

/**
 * This is a template for any creature to implement. A creature would be anything that is considered
 * a creature in Pathfinder rules including Monsters, NPC's, the players/party members, anything
 * that moves and controls its own movement and actions.
 *
 * @author jacob
 *
 */
public class Creature extends RealWorldObject
{
    private int nonlethalDamage;
    private int tempHP;

    private final CreatureType creatureType;
    private final int baseWeight;
    private final CreatureClassManager classManager = new CreatureClassManager();
    private final BuffManager buffManager;

    private final CreatureDescription description;

    // base scores are what a creature inherently has for scores
    private final AbilityScoreSet baseScores;

    // effective scores are what a creature actually uses and takes into account base scores,
    // bonuses, penalties, etc
    private AbilityScoreSet effectiveScores;
    private int maxDexBonus;

    private List<Skill> skills;

    private final MovementSpeeds baseMovement;
    private MovementSpeeds effectiveMovement;

    private final Inventory inventory;
    private List<Spell> spells;
    // TODO feats and such
    // TODO abilities and such
    private List<Language> knownLanguages;

    /*
     * Offensive Properties
     */
    private int initiative;
    private int baseAttackBonus;
    private int combatManueverBonus;

    /*
     * Defensive Properties
     */
    private int armorClass;
    private int touch;
    private int flatfooted;
    private int reflex;
    private int fortitude;
    private int will;
    private int damageReduction;
    private int spellResistance;
    private int combatManeuverDefense;
    private static final int BASE_DEFENSE = 10;

    private final int AOOPerRound = 1;

    public Creature(final AbilityScoreSet baseStats, final CreatureType creatureType, boolean isMale)
    {
        /*
         * Make sure to calculate things in the order that they are depended on.
         */

        // everything depends on these so set them first
        this.buffManager = new BuffManager();
        this.baseScores = baseStats;
        classManager.addLevel(creatureType);
        this.creatureType = creatureType;
        description = new CreatureDescription();
        description.setGender(isMale);

        // these need to be calculated next as most things depend on them
        baseWeight = creatureType.calcWeight(isMale);
        super.setWeight(baseWeight);
        effectiveScores = calcAbilityScores();
        inventory = new Inventory(effectiveScores.getStrengthScore(), creatureType.getSizeCategory(), creatureType.isBipedal());
        baseAttackBonus = calcBaseAttackBonus();

        // now calculate things in groups, the order of the groups don't really matter
        super.setMaxHP(calcMaxHealthPoints());
        super.setHP(calcCurrentHP());
        nonlethalDamage = 0;

        initiative = calcInitiative();
        combatManueverBonus = calcCombatManueverBonus();

        maxDexBonus = calcMaxDexBonus();
        armorClass = calcArmorClass();
        touch = calcTouch();
        flatfooted = calcFlatFooted();
        combatManeuverDefense = calcCombatManueverDefense();

        reflex = calcReflex();
        fortitude = calcFortitude();
        will = calcWill();

        baseMovement = creatureType.getMoveSpeeds();
        effectiveMovement = calcEffectiveMovement();
    }

    public Creature(final AbilityScoreSet baseStats, final CreatureType creatureType)
    {
        this(baseStats, creatureType, DiceSet.flipCoin());
    }

    @Override
    public List<String> getProperties()
    {
        final List<String> properties = super.getProperties();
        properties.add("Non-Lethal Damage: " + nonlethalDamage);
        properties.add("Temporary HP: " + tempHP);
        properties.add("Creature Type: " + creatureType.getClass().getSimpleName());
        for (final CreatureClass classs : classManager.getClasses())
        {
            properties.add("Class: " + classs.getClass().getSimpleName());
            properties.add(classs.getClass().getSimpleName() + " Levels: " + classs.getLevel());
        }
        // TODO CreatureBuffs
        // TODO CreatureDescriptions
        properties.add("Is male: " + description.isMale());
        for (final AbilityScoreInstance score : baseScores)
        {
            properties.add("Base " + score.getType() + " Score: " + score.getScore());
            properties.add("Base " + score.getType() + " Modifier: " + score.getModifier());
        }
        for (final AbilityScoreInstance score : effectiveScores)
        {
            properties.add("Effective " + score.getType() + " Score: " + score.getScore());
            properties.add("Effective " + score.getType() + " Modifier: " + score.getModifier());
        }
        properties.add("Max Dex Bonus: " + maxDexBonus);
        // TODO skills
        // TODO movement
        properties.add("Inventory: ");
        for (final RealWorldObject rwo : inventory.viewAll())
        {
            properties.addAll(rwo.getProperties());
        }
        // TODO spells
        // TODO feats and such
        // TODO abilities and such
        // TODO knownLanguages
        properties.add("Base Initiative: " + initiative);
        properties.add("Base Attack Bonus: " + baseAttackBonus);
        properties.add("Combat Maneuver Bonus: " + combatManueverBonus);
        properties.add("Armor Class: " + armorClass);
        properties.add("Touch: " + touch);
        properties.add("Flat-footed: " + flatfooted);
        properties.add("Combat Maneuver Defense: " + combatManeuverDefense);
        properties.add("Reflex: " + reflex);
        properties.add("Fortitude: " + fortitude);
        properties.add("Will: " + will);
        properties.add("Damage Reduction: " + damageReduction);
        properties.add("Attacks of Opportunity per round: " + AOOPerRound);

        return properties;
    }

    /*****************************************************
     **************** Getters and Setters ****************
     *****************************************************/

    public CreatureType getCreatureType()
    {
        return creatureType;
    }

    public MovementSpeeds getEffectiveMovement()
    {
        return effectiveMovement;
    }

    public int getMaxDexBonus()
    {
        return maxDexBonus;
    }

    public void setMaxDexBonus(int maxDexBonus)
    {
        this.maxDexBonus = maxDexBonus;
    }

    public AbilityScoreSet getBaseAbilityScores()
    {
        return baseScores;
    }

    public AbilityScoreSet getEffectiveAbilityScores()
    {
        return effectiveScores;
    }

    protected void setEffectiveAbilityScores(final AbilityScoreSet scores)
    {
        effectiveScores = scores;
    }

    public List<Language> getLanguagesKnown()
    {
        return Collections.unmodifiableList(knownLanguages);
    }

    public int getLevel()
    {
        return classManager.getTotalLevels();
    }

    public int getTempHP()
    {
        return tempHP;
    }

    public void setTempHP(int tempHP)
    {
        this.tempHP = tempHP;
    }

    public int getNonlethalDamage()
    {
        return nonlethalDamage;
    }

    public void setNonlethalDamage(int nonlethalDamage)
    {
        this.nonlethalDamage = nonlethalDamage;
    }

    public CreatureDescription getDescription()
    {
        return description;
    }

    public List<Skill> getSkills()
    {
        return skills;
    }

    public Inventory getInventory()
    {
        return inventory;
    }

    public List<Spell> getSpells()
    {
        return spells;
    }

    public int getInitiative()
    {
        return initiative;
    }

    public void setInitiative(int initiative)
    {
        this.initiative = initiative;
    }

    public int getBaseAttackBonus()
    {
        return baseAttackBonus;
    }

    public void setBaseAttackBonus(int baseAttackBonus)
    {
        this.baseAttackBonus = baseAttackBonus;
    }

    public int getCombatManueverBonus()
    {
        return combatManueverBonus;
    }

    public void setCombatManueverBonus(int combatManueverBonus)
    {
        this.combatManueverBonus = combatManueverBonus;
    }

    public int getArmorClass()
    {
        return armorClass;
    }

    public void setArmorClass(int armorClass)
    {
        this.armorClass = armorClass;
    }

    public int getTouch()
    {
        return touch;
    }

    public void setTouch(int touch)
    {
        this.touch = touch;
    }

    public int getFlatfooted()
    {
        return flatfooted;
    }

    public void setFlatfooted(int flatfooted)
    {
        this.flatfooted = flatfooted;
    }

    public int getReflex()
    {
        return reflex;
    }

    public void setReflex(int reflex)
    {
        this.reflex = reflex;
    }

    public int getFortitude()
    {
        return fortitude;
    }

    public void setFortitude(int fortitude)
    {
        this.fortitude = fortitude;
    }

    public int getWill()
    {
        return will;
    }

    public void setWill(int will)
    {
        this.will = will;
    }

    public int getDamageReduction()
    {
        return damageReduction;
    }

    public void setDamageReduction(int damageReduction)
    {
        this.damageReduction = damageReduction;
    }

    public int getSpellResistance()
    {
        return spellResistance;
    }

    public void setSpellResistance(int spellResistance)
    {
        this.spellResistance = spellResistance;
    }

    public int getCombatManeuverDefense()
    {
        return combatManeuverDefense;
    }

    public void setCombatManeuverDefense(int combatManeuverDefense)
    {
        this.combatManeuverDefense = combatManeuverDefense;
    }

    public BuffManager getBuffManager()
    {
        return buffManager;
    }

    public int getTotalWeight()
    {
        return baseWeight + inventory.getTotalWeight();
    }

    public Collection<CreatureClass> getClasses()
    {
        return classManager.getClasses();
    }

    public int getNumAttacksOfOpportunity()
    {
        return AOOPerRound;
    }

    /*****************************************************
     *************** Calculation Functions ***************
     *****************************************************/

    public AbilityScoreSet calcAbilityScores()
    {
        final int str = buffManager.getBonusByTarget(BonusTarget.Strength);
        final int dex = buffManager.getBonusByTarget(BonusTarget.Dexterity);
        final int con = buffManager.getBonusByTarget(BonusTarget.Constitution);
        final int intel = buffManager.getBonusByTarget(BonusTarget.Intelligence);
        final int wis = buffManager.getBonusByTarget(BonusTarget.Wisdom);
        final int cha = buffManager.getBonusByTarget(BonusTarget.Charisma);

        final AbilityScoreSet bonuses = new AbilityScoreSet(str, dex, con, intel, wis, cha);

        return baseScores.addScores(bonuses);
    }

    public int calcTempHP()
    {
        return buffManager.getBonusByTarget(BonusTarget.TempHp);
    }

    public int calcCurrentHP()
    {
        return getMaxHP() + tempHP + buffManager.getBonusByTarget(BonusTarget.CurrentHp);
    }

    public int calcMaxHealthPoints()
    {
        final int totalHealthByLevel = classManager.getHealth();
        final int healthByCon = getLevel() * effectiveScores.getConstitutionModifier();
        final int bonusHealth = buffManager.getBonusByTarget(BonusTarget.MaxHp);

        return totalHealthByLevel + healthByCon + bonusHealth;
    }

    public int calcInitiative()
    {
        return this.effectiveScores.getDexterityModifier() + buffManager.getBonusByTarget(BonusTarget.Initiative);
    }

    public int calcBaseAttackBonus()
    {
        return classManager.getBaseAttackBonus();
    }

    public int calcCombatManueverBonus()
    {
        final int strMod = effectiveScores.getStrengthModifier();
        final int sizeMod = creatureType.getSizeCategory().getSpecialSizeModifier();
        final int cmbBonus = buffManager.getBonusByTarget(BonusTarget.CMB);
        return baseAttackBonus + strMod + sizeMod + cmbBonus;
    }

    public int calcCombatManueverDefense()
    {
        final int sizeMod = creatureType.getSizeCategory().getSizeModifier();
        final int dexMod = effectiveScores.getDexterityModifier();
        final int strMod = effectiveScores.getStrengthModifier();
        final int cmdBonus = buffManager.getBonusByTarget(BonusTarget.CMD);
        return BASE_DEFENSE + dexMod + sizeMod + strMod + baseAttackBonus + cmdBonus;
    }

    public int calcMaxDexBonus()
    {
        final int totalDex = effectiveScores.getDexterityModifier();
        final int bonusToMaxDexBonus = buffManager.getBonusByTarget(BonusTarget.MaxDexBonus);

        // get maximum allowed dex
        final int loadMax = buffManager.getMaxDexBonus();

        // maxDex will be the minimum from the load plus any bonuses
        final int maxDexPossible = loadMax + bonusToMaxDexBonus;

        // return the maximum usable dexterity
        return Math.min(maxDexPossible, totalDex);
    }

    public int calcTouch()
    {
        final int sizeMod = creatureType.getSizeCategory().getSizeModifier();
        final int touchBonus = buffManager.getBonusByTarget(BonusTarget.Touch);
        return BASE_DEFENSE + maxDexBonus + sizeMod + touchBonus;
    }

    public int calcFlatFooted()
    {
        final int sizeMod = creatureType.getSizeCategory().getSizeModifier();
        final int flatFootedBonus = buffManager.getBonusByTarget(BonusTarget.FlatFooted);
        return BASE_DEFENSE + sizeMod + flatFootedBonus;
    }

    public int calcArmorClass()
    {
        final int sizeMod = creatureType.getSizeCategory().getSizeModifier();
        final int acBonus = buffManager.getBonusByTarget(BonusTarget.ArmorClass);
        return BASE_DEFENSE + maxDexBonus + sizeMod + acBonus;
    }

    public int calcFortitude()
    {
        final int conMod = effectiveScores.getConstitutionModifier();
        final int baseFort = classManager.getFortitude();
        final int fortBonus = buffManager.getBonusByTarget(BonusTarget.Fortitude);
        return conMod + baseFort + fortBonus;
    }

    public int calcReflex()
    {
        final int dexMod = effectiveScores.getDexterityModifier();
        final int baseReflex = classManager.getReflex();
        final int reflexBonus = buffManager.getBonusByTarget(BonusTarget.Reflex);
        return dexMod + baseReflex + reflexBonus;
    }

    public int calcWill()
    {
        final int wisMod = effectiveScores.getWisdomModifier();
        final int baseWill = classManager.getWill();
        final int willBonus = buffManager.getBonusByTarget(BonusTarget.Will);
        return wisMod + baseWill + willBonus;
    }

    public int calcDamageReduction()
    {
        return buffManager.getBonusByTarget(BonusTarget.DR);
    }

    public int calcSpellResistance()
    {
        return buffManager.getBonusByTarget(BonusTarget.SR);
    }

    public MovementSpeeds calcEffectiveMovement()
    {
        final int baseSpeed = baseMovement.getBase();
        final MovementSpeeds toReturn = baseMovement.clone();

        // reduce move speed amounts due to load
        // this may not actually reduce the base any if this is a light load
        toReturn.setBase(inventory.getLoad().getReducedSpeed(baseSpeed) + buffManager.getBonusByTarget(BonusTarget.LandSpeed));
        // TODO: calculate movement with armor for character creatures
        toReturn.setFly(toReturn.getFly() + buffManager.getBonusByTarget(BonusTarget.FlySpeed));
        toReturn.setBurrow(toReturn.getBurrow() + buffManager.getBonusByTarget(BonusTarget.BurrowSpeed));
        toReturn.setClimb(toReturn.getClimb() + buffManager.getBonusByTarget(BonusTarget.ClimbSpeed));
        toReturn.setSwim(toReturn.getSwim() + buffManager.getBonusByTarget(BonusTarget.SwimSpeed));
        return toReturn;
    }

    /**
     * Call this whenever there might be a load change. Whenever something is added or removed from
     * the inventory, strength changed ...
     */
    private void loadChange()
    {
        // only recalculate stats if the load changed
        final Load prev = inventory.previousLoad();
        if (prev != null)
        {
            // remove the previous load and add the new one so calculations are correct
            buffManager.removeDexLimiting(prev);
            buffManager.addDexLimiting(inventory.getLoad());

            maxDexBonus = calcMaxDexBonus();
            effectiveMovement = calcEffectiveMovement();
        }

        super.setWeight(getTotalWeight());
    }

    public void calcBasedOnTargetChange(final BonusTarget target)
    {
        /*
         * TODO think of a better way to manage recalculations
         *
         * We could probably think of some better object oriented way to do this instead of a giant
         * switch case. I was thinking what if we had CreatureBuffs take a creature object and each
         * buff knows exactly what to apply to the creature object. For example, there could be a
         * strength buff which takes a creature object and add's to its strength. Because the
         * CreatureBuff has access to a Creature object this would also allow for more advanced
         * buffs to be made with logic inside them instead of a simple plus to the value. The only
         * problem would be that we would need to account for how typed bonuses stack. Maybe we
         * should keep this how it is because we can manage simple bonuses like this and make sure
         * they stack correctly with the buff manager and instead we can use the idea of a more
         * advanced effect that takes in a creature object, like a spell or feat or other more
         * complicated things. This would mean that there must be a class for every spell and for
         * every feat. Though it would work and it would probably be quick and work quite well. Just
         * a lot of classes.
         */
        switch (target)
        {
            case AcidRes:
            case ElectRes:
            case FireRes:
            case ColdRes:
            case SonicRes:
                // TODO
                break;
            case ArcaneSpellFailure:
                // TODO
                break;
            case BurrowSpeed:
            case ClimbSpeed:
            case FlySpeed:
            case LandSpeed:
            case SwimSpeed:
                effectiveMovement = calcEffectiveMovement();
                break;
            case ArmorClass:
                armorClass = calcArmorClass();
                break;
            case CMB:
                combatManueverBonus = calcCombatManueverBonus();
                break;
            case CMD:
                combatManeuverDefense = calcCombatManueverDefense();
                break;
            case Charisma:
                effectiveScores = calcAbilityScores();
                break;
            case Constitution:
                effectiveScores = calcAbilityScores();
                fortitude = calcFortitude();
                super.setMaxHP(calcMaxHealthPoints());
                // TODO change current health
                break;
            case Dexterity:
                effectiveScores = calcAbilityScores();
                initiative = calcInitiative();
                reflex = calcReflex();
                break;
            case Intelligence:
                effectiveScores = calcAbilityScores();
                break;
            case Strength:
                effectiveScores = calcAbilityScores();
                inventory.setStrength(effectiveScores.getStrengthScore());
                loadChange();
                break;
            case Wisdom:
                effectiveScores = calcAbilityScores();
                will = calcWill();
                break;
            case CurrentHp:
                // TODO change current health
                break;
            case DR:
                damageReduction = calcDamageReduction();
                break;
            case FlatFooted:
                flatfooted = calcFlatFooted();
                break;
            case Fortitude:
                fortitude = calcFortitude();
                break;
            case Initiative:
                initiative = calcInitiative();
                break;
            case Level:
                super.setMaxHP(calcMaxHealthPoints());
                baseAttackBonus = calcBaseAttackBonus();
                fortitude = calcFortitude();
                reflex = calcReflex();
                will = calcWill();
                break;
            case MaxDexBonus:
                maxDexBonus = calcMaxDexBonus();
                armorClass = calcArmorClass();
                touch = calcTouch();
                break;
            case MaxHp:
                super.setMaxHP(calcMaxHealthPoints());
                // TODO change current health
                break;
            case Melee:
                break;
            case Ranged:
                break;
            case Reflex:
                reflex = calcReflex();
                break;
            case SR:
                spellResistance = calcSpellResistance();
                break;
            case Size:
                // TODO
                break;
            case Skills:
                // TODO
                break;
            case TempHp:
                // TODO
                break;
            case Touch:
                touch = calcTouch();
                break;
            case Will:
                will = calcWill();
                break;
            default:
                break;
        }
    }

    /*****************************************************
     ****************** Action Functions *****************
     *****************************************************/

    public void addLevel(final CreatureClass creatureClass)
    {
        classManager.addLevel(creatureClass);
        calcBasedOnTargetChange(BonusTarget.Level);
    }

    public void addLevels(final Collection<CreatureClass> classes)
    {
        for (final CreatureClass crClass : classes)
        {
            addLevel(crClass);
        }
    }

    public boolean removeFromInventory(final RealWorldObject rwo)
    {
        if (inventory.removeItem(rwo))
        {
            loadChange();
            return true;
        }
        return false;
    }

    /**
     * Attempts to add the object to the creature's inventory. This method returns true if the item
     * is successfully added to inventory or false otherwise.
     *
     * @param rwo
     * @return
     */
    public boolean addToInventory(final RealWorldObject rwo)
    {
        if (inventory.addItem(rwo))
        {
            loadChange();
            return true;
        }
        return false;
    }

    /*
     * TODO will need a system for tracking the bonuses from slotless items that are added to
     * creatures similar to character creature. Probably something like a generic equipment tracker
     * that tracks slots that are applicable to the creature. At that point we could pull regular
     * equipment and slot management out of character creature, which would be ideal. But for now
     * character creature will have to work as is and slotless items simply have no effect over
     * regular creatures.
     */

    /**
     * Applies a buff to the creature.
     *
     * @param buff
     */
    public void addBuff(final CreatureBuff buff)
    {
        buffManager.addBuff(buff);
        calcBasedOnTargetChange(buff.getBonusTarget());
    }

    /**
     * Applies a list of buffs to the creature.
     *
     * @param buffs
     */
    public void addBuff(final List<CreatureBuff> buffs)
    {
        for (final CreatureBuff buff : buffs)
        {
            addBuff(buff);
        }
    }

    /**
     * Removes the buff from the creature.
     *
     * @param buff
     */
    public void removeBuff(final CreatureBuff buff)
    {
        buffManager.removeBuff(buff);
        calcBasedOnTargetChange(buff.getBonusTarget());
    }

    /**
     * Removes a list of buffs from the creature.
     *
     * @param buffs
     */
    public void removeBuff(final List<CreatureBuff> buffs)
    {
        for (final CreatureBuff buff : buffs)
        {
            removeBuff(buff);
        }
    }

    public int rollInitiative()
    {
        return DiceSet.getRolledTotal(20, 1) + initiative;
    }

}
