package pathfinder.realWorldObject.creature;

import java.util.Collections;
import java.util.List;

import pathfinder.characters.buffs.BonusTarget;
import pathfinder.characters.buffs.BuffManager;
import pathfinder.characters.skill.Skill;
import pathfinder.metaObjects.DiceSet;
import pathfinder.realWorldObject.RealWorldObject;
import pathfinder.realWorldObject.creature.creatureType.CreatureType;

/**
 * This is a template for any creature to implement. A creature would be
 * anything that is considered a creature in Pathfinder rules including
 * Monsters, NPC's, the players/party members, anything that moves and controls
 * its own movement and actions.
 *
 * @author jacob
 *
 */
public abstract class Creature extends RealWorldObject
{
    private int nonlethalDamage;
    private int tempHP;

    /*
     * TODO we need something similar to the SlotManager for things that are not
     * just equipment.
     */

    private final CreatureType creatureType;
    private final BuffManager buffManager;

    private CreatureDescription description;

    // base scores are what a creature inherently has for scores
    private final AbilityScoreSet baseScores;

    // effective scores are what a creature actually uses and takes into account base scores,
    // bonuses, penalties, etc
    private final AbilityScoreSet effectiveScores;

    private List<Skill> skills;

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
    private int combatManueverDefense;
    protected static final int BASE_DEFENSE = 10;

    public Creature(final AbilityScoreSet baseStats, final CreatureType creatureType)
    {
        /*
         * Make sure to calculate things in the order that they are depended on.
         */

        // everything depends on these so set them first
        this.buffManager = new BuffManager();
        this.baseScores = baseStats;
        this.creatureType = creatureType;

        // these need to be calculated next as most things depend on them
        effectiveScores = calcAbilityScores();
        baseAttackBonus = calcBaseAttackBonus();

        // now calculate things in groups, the order of the groups don't really matter
        super.setMaxHP(calcMaxHealthPointsRandom());
        super.setHP(calcCurrentHP());
        nonlethalDamage = 0;

        initiative = calcInitiative();
        combatManueverBonus = calcCombatManueverBonus();

        armorClass = calcArmorClass();
        touch = calcTouch();
        flatfooted = calcFlatFooted();
        combatManueverDefense = calcCombatManueverDefense();

        reflex = calcReflex();
        fortitude = calcFortitude();
        will = calcWill();

        inventory = new Inventory(effectiveScores.getStrengthScore(), creatureType.getSizeCategory(), creatureType.isBipedal());
    }

    /*****************************************************
     **************** Getters and Setters ****************
     *****************************************************/

    public AbilityScoreSet getBaseAbilityScores()
    {
        return baseScores;
    }

    public AbilityScoreSet getEffectiveAbilityScores()
    {
        return effectiveScores;
    }

    public List<Language> getLanguagesKnown()
    {
        return Collections.unmodifiableList(knownLanguages);
    }

    public int getLevel()
    {
        return creatureType.getLevel();
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

    public int getCombatManueverDefense()
    {
        return combatManueverDefense;
    }

    public void setCombatManueverDefense(int combatManueverDefense)
    {
        this.combatManueverDefense = combatManueverDefense;
    }

    public BuffManager getBuffManager()
    {
        return buffManager;
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

    public int calcMaxHealthPointsRandom()
    {
        final DiceSet dice = new DiceSet(creatureType.getHitDieType(), getLevel());
        return getLevel() * effectiveScores.getConstitutionModifier() + dice.getRolledTotal() + buffManager.getBonusByTarget(BonusTarget.MaxHp);
    }

    public int calcInitiative()
    {
        return this.effectiveScores.getDexterityModifier() + buffManager.getBonusByTarget(BonusTarget.Initiative);
    }

    public int calcBaseAttackBonus()
    {
        return creatureType.getBaseAttackBonusProgression().getBAB(creatureType.getLevel());
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

    public int calcTouch()
    {
        final int sizeMod = creatureType.getSizeCategory().getSizeModifier();
        final int touchBonus = buffManager.getBonusByTarget(BonusTarget.Touch);
        final int dexBonus = effectiveScores.getDexterityModifier();
        return BASE_DEFENSE + dexBonus + sizeMod + touchBonus;
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
        final int dexBonus = effectiveScores.getDexterityModifier();
        return BASE_DEFENSE + dexBonus + sizeMod + acBonus;
    }

    public int calcFortitude()
    {
        final int conMod = effectiveScores.getConstitutionModifier();
        final int baseFort = creatureType.getSavingThrowSet().getBaseFortitude(getLevel());
        final int fortBonus = buffManager.getBonusByTarget(BonusTarget.Fortitude);
        return conMod + baseFort + fortBonus;
    }

    public int calcReflex()
    {
        final int dexMod = effectiveScores.getDexterityModifier();
        final int baseReflex = creatureType.getSavingThrowSet().getBaseReflex(getLevel());
        final int reflexBonus = buffManager.getBonusByTarget(BonusTarget.Reflex);
        return dexMod + baseReflex + reflexBonus;
    }

    public int calcWill()
    {
        final int wisMod = effectiveScores.getWisdomModifier();
        final int baseWill = creatureType.getSavingThrowSet().getBaseWill(getLevel());
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

    /*****************************************************
     ****************** Action Functions *****************
     *****************************************************/

    public void addToInventory(final RealWorldObject rwo)
    {
        inventory.addItem(rwo);
        // TODO apply buffs or whatever else might need to happen
    }
}
