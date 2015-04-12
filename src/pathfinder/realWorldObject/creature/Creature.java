package pathfinder.realWorldObject.creature;

import java.util.List;

import pathfinder.characters.buffs.BonusTarget;
import pathfinder.characters.skill.Skill;
import pathfinder.realWorldObject.RealWorldObject;
import pathfinder.realWorldObject.SizeCategory;
import pathfinder.realWorldObject.item.equipment.SlotManager;

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
    private int hitDie;

    private CreatureDescription description;
    private final AbilityScores abilityScores;
    private List<Skill> skills;
    private SlotManager equipment;
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
    private final int baseDefence = 10;

    public Creature(final AbilityScores baseStats)
    {
        this.abilityScores = baseStats;
        initCreature();
    }

    protected int getLevel()
    {
        return level;
    }

    protected void setLevel(int level)
    {
        this.level = level;
    }

    protected int getHitDie()
    {
        return hitDie;
    }

    protected void setHitDie(int hitDie)
    {
        this.hitDie = hitDie;
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

    protected SlotManager getEquipment()
    {
        return equipment;
    }

    protected void setEquipment(SlotManager equipment)
    {
        this.equipment = equipment;
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

    protected int getBaseDefence()
    {
        return baseDefence;
    }

    protected void initCreature()
    {
        calcLevel();
        calcAbilityScores();
        calcInitiative();
        calcBaseAttackBonus();
        calcCombatManueverBonus();
        calcArmorBonuses();
        calcSaves();
        calcDamageReduction();
        calcSpellResistance();
    }

    protected abstract void calcLevel();

    protected abstract void calcSizeCategory();

    protected abstract void calcMoveSpeeds();

    protected void calcAbilityScores()
    {
        abilityScores.setStrengthScore(abilityScores.getStrengthScore()
                + equipment.getBonusByTarget(BonusTarget.Strength));
        abilityScores.setStrengthScore(abilityScores.getDexterityScore()
                + equipment.getBonusByTarget(BonusTarget.Dexterity));
        abilityScores.setStrengthScore(abilityScores.getConstitutionScore()
                + equipment.getBonusByTarget(BonusTarget.Constitution));
        abilityScores.setStrengthScore(abilityScores.getIntelligenceScore()
                + equipment.getBonusByTarget(BonusTarget.Intelligence));
        abilityScores.setStrengthScore(abilityScores.getWisdomScore() + equipment.getBonusByTarget(BonusTarget.Wisdom));
        abilityScores.setStrengthScore(abilityScores.getCharismaScore()
                + equipment.getBonusByTarget(BonusTarget.Charisma));
    }

    protected void calcInitiative()
    {
        this.initiative = this.abilityScores.getDexterityModifier()
                + equipment.getBonusByTarget(BonusTarget.Initiative);
    }

    protected abstract void calcBaseAttackBonus();

    protected void calcCombatManueverBonus()
    {
        combatManueverBonus = baseAttackBonus + abilityScores.getStrengthModifier() + size.getSpecialSizeModifier()
                + equipment.getBonusByTarget(BonusTarget.CMB);
    }

    /*
     * Make equipped items class that has list of target type, amount, and
     * target of effects/buffs which constantly updates scores
     * for each element.
     */
    protected void calcArmorBonuses()
    {
        armorClass = baseDefence + equipment.getBonusByTarget(BonusTarget.ArmorClass);
        flatfooted = baseDefence + equipment.getBonusByTarget(BonusTarget.FlatFooted);
        touch = baseDefence + equipment.getBonusByTarget(BonusTarget.Touch);
        combatManueverDefense = baseDefence + equipment.getBonusByTarget(BonusTarget.CMD);
    }

    protected void calcSaves()
    {
        reflex = equipment.getBonusByTarget(BonusTarget.Reflex) + abilityScores.getDexterityModifier();
        fortitude = equipment.getBonusByTarget(BonusTarget.Fortitude) + abilityScores.getConstitutionModifier();
        will = equipment.getBonusByTarget(BonusTarget.Will) + abilityScores.getWisdomModifier();
    }

    protected void calcDamageReduction()
    {
        damageReduction = equipment.getBonusByTarget(BonusTarget.DR);
    }

    protected void calcSpellResistance()
    {
        spellResistance = equipment.getBonusByTarget(BonusTarget.SR);
    }

}
