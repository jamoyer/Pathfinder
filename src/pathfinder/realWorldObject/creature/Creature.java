package pathfinder.realWorldObject.creature;

import java.util.List;

import pathfinder.characters.skill.Skill;
import pathfinder.realWorldObject.RealWorldObject;
import pathfinder.realWorldObject.SizeCategory;

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
    private int level;
    private int currentHP;
    private int nonlethalDamage;
    private int maxHealthPoints;

    /*
     * TODO we need something similar to the SlotManager for things that are not
     * just equipment.
     */

    private CreatureDescription description;
    private final AbilityScores abilityScores;
    private List<Skill> skills;

    private Inventory inventory;
    private List<Spell> spells;
    // TODO feats and such
    private SizeCategory size;
    // TODO abilities and such
    private Movement speeds;
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
    private static final int BASE_DEFENSE = 10;

    public Creature(final AbilityScores baseStats, final SizeCategory size)
    {
        this.abilityScores = baseStats;
        this.size = size;
        initCreature();
    }

    public Creature(final AbilityScores baseStats)
    {
        this(baseStats, SizeCategory.Medium);
    }

    protected int getLevel()
    {
        return level;
    }

    protected void setLevel(int level)
    {
        this.level = level;
    }

    protected int getCurrentHP()
    {
        return currentHP;
    }

    protected void setCurrentHP(int currentHP)
    {
        this.currentHP = currentHP;
    }

    protected int getNonlethalDamage()
    {
        return nonlethalDamage;
    }

    protected void setNonlethalDamage(int nonlethalDamage)
    {
        this.nonlethalDamage = nonlethalDamage;
    }

    protected int getMaxHealthPoints()
    {
        return maxHealthPoints;
    }

    protected void setMaxHealthPoints(int maxHealthPoints)
    {
        this.maxHealthPoints = maxHealthPoints;
    }

    protected CreatureDescription getDescription()
    {
        return description;
    }

    protected void setDescription(CreatureDescription description)
    {
        this.description = description;
    }

    protected List<Skill> getSkills()
    {
        return skills;
    }

    protected void setSkills(List<Skill> skills)
    {
        this.skills = skills;
    }

    protected Inventory getInventory()
    {
        return inventory;
    }

    protected void setInventory(Inventory inventory)
    {
        this.inventory = inventory;
    }

    protected List<Spell> getSpells()
    {
        return spells;
    }

    protected void setSpells(List<Spell> spells)
    {
        this.spells = spells;
    }

    protected SizeCategory getSize()
    {
        return size;
    }

    protected void setSize(SizeCategory size)
    {
        this.size = size;
    }

    protected Movement getSpeeds()
    {
        return speeds;
    }

    protected void setSpeeds(Movement speeds)
    {
        this.speeds = speeds;
    }

    protected List<Language> getKnownLanguages()
    {
        return knownLanguages;
    }

    protected void setKnownLanguages(List<Language> knownLanguages)
    {
        this.knownLanguages = knownLanguages;
    }

    protected int getInitiative()
    {
        return initiative;
    }

    protected void setInitiative(int initiative)
    {
        this.initiative = initiative;
    }

    protected int getBaseAttackBonus()
    {
        return baseAttackBonus;
    }

    protected void setBaseAttackBonus(int baseAttackBonus)
    {
        this.baseAttackBonus = baseAttackBonus;
    }

    protected int getCombatManueverBonus()
    {
        return combatManueverBonus;
    }

    protected void setCombatManueverBonus(int combatManueverBonus)
    {
        this.combatManueverBonus = combatManueverBonus;
    }

    protected int getArmorClass()
    {
        return armorClass;
    }

    protected void setArmorClass(int armorClass)
    {
        this.armorClass = armorClass;
    }

    protected int getTouch()
    {
        return touch;
    }

    protected void setTouch(int touch)
    {
        this.touch = touch;
    }

    protected int getFlatfooted()
    {
        return flatfooted;
    }

    protected void setFlatfooted(int flatfooted)
    {
        this.flatfooted = flatfooted;
    }

    protected int getReflex()
    {
        return reflex;
    }

    protected void setReflex(int reflex)
    {
        this.reflex = reflex;
    }

    protected int getFortitude()
    {
        return fortitude;
    }

    protected void setFortitude(int fortitude)
    {
        this.fortitude = fortitude;
    }

    protected int getWill()
    {
        return will;
    }

    protected void setWill(int will)
    {
        this.will = will;
    }

    protected int getDamageReduction()
    {
        return damageReduction;
    }

    protected void setDamageReduction(int damageReduction)
    {
        this.damageReduction = damageReduction;
    }

    protected int getSpellResistance()
    {
        return spellResistance;
    }

    protected void setSpellResistance(int spellResistance)
    {
        this.spellResistance = spellResistance;
    }

    protected int getCombatManueverDefense()
    {
        return combatManueverDefense;
    }

    protected void setCombatManueverDefense(int combatManueverDefense)
    {
        this.combatManueverDefense = combatManueverDefense;
    }

    protected AbilityScores getAbilityScores()
    {
        return abilityScores;
    }

    protected void initCreature()
    {
        // lots of things depend on size and level so calculate those first
        calcSizeCategory();
        calcLevel();

        //
        calcBaseAttackBonus();
        initMaxHealthPoints();
        currentHP = maxHealthPoints;
        nonlethalDamage = 0;
        calcInitiative();
        calcCombatManueverBonus();
        calcArmorBonuses();
        calcSaves();
        calcDamageReduction();
        calcSpellResistance();
        calcMoveSpeeds();
    }

    protected void initMaxHealthPoints()
    {
        maxHealthPoints = level * abilityScores.getConstitutionModifier();
    }

    protected abstract void calcLevel();

    protected abstract void calcSizeCategory();

    protected abstract void calcMoveSpeeds();

    protected void calcInitiative()
    {
        this.initiative = this.abilityScores.getDexterityModifier();
    }

    protected abstract void calcBaseAttackBonus();

    protected void calcCombatManueverBonus()
    {
        combatManueverBonus = baseAttackBonus + abilityScores.getStrengthModifier() + size.getSpecialSizeModifier();
    }

    /*
     * Make equipped items class that has list of target type, amount, and
     * target of effects/buffs which constantly updates scores
     * for each element.
     */
    protected void calcArmorBonuses()
    {
        armorClass = BASE_DEFENSE + abilityScores.getDexterityModifier() + size.getSizeModifier();
        flatfooted = BASE_DEFENSE + size.getSizeModifier();
        touch = BASE_DEFENSE + abilityScores.getDexterityModifier() + size.getSizeModifier();
        combatManueverDefense = BASE_DEFENSE + abilityScores.getDexterityModifier() + size.getSizeModifier()
                + abilityScores.getStrengthModifier() + baseAttackBonus;
    }

    protected void calcSaves()
    {
        reflex = abilityScores.getDexterityModifier();
        fortitude = abilityScores.getConstitutionModifier();
        will = abilityScores.getWisdomModifier();
    }

    protected abstract void calcDamageReduction();

    protected abstract void calcSpellResistance();

}
