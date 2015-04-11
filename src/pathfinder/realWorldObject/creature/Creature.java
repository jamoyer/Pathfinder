package pathfinder.realWorldObject.creature;

import java.util.List;

import pathfinder.characters.buffs.BonusTarget;
import pathfinder.characters.classes.CharacterClass;
import pathfinder.characters.savingThrow.BaseSavingThrowSet;
import pathfinder.characters.skill.Skill;
import pathfinder.realWorldObject.RealWorldObject;
import pathfinder.realWorldObject.SizeCategory;
import pathfinder.realWorldObject.creature.coreRaces.Race;
import pathfinder.realWorldObject.creature.creatureType.CreatureType;
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
public class Creature extends RealWorldObject
{
    private final CreatureType creatureType;
    private final Race race;
    private int level;
    private int hitDie;
    private List<CharacterClass> classes;
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

    /*public Creature(final CreatureType creatureType, final AbilityScores baseStats)
    {
        this.creatureType = creatureType;
        this.abilityScores = baseStats;
    }*/
    
    public Creature(final CreatureType creatureType, final AbilityScores baseStats, Race race)
    {
        this.creatureType = creatureType;
        this.abilityScores = baseStats;
        this.race = race;
        initCreature();
    }

    private void initCreature()
    {
        calcRacialFeatures();
        calcLevel();
        this.size = this.creatureType.getSizeCategory();
        this.speeds = this.creatureType.getMoveSpeeds();
        calcInitiative();
        calcBaseAttackBonus();
        calcCombatManueverBonus();
        calcArmorBonuses();
        calcSaves();
        calcDamageReduction();
        calcSpellResistance();
    }

    private void calcRacialFeatures()
    {
        AbilityScores racialAbilityScores = race.getAbilityScoreModifiers();
        abilityScores.setStrengthScore(abilityScores.getStrengthScore()+racialAbilityScores.getStrengthScore());
        abilityScores.setDexterityScore(abilityScores.getDexterityScore()+racialAbilityScores.getDexterityScore());
        abilityScores.setConstitutionScore(abilityScores.getConstitutionScore()+racialAbilityScores.getConstitutionScore());
        abilityScores.setIntelligenceScore(abilityScores.getIntelligenceScore()+racialAbilityScores.getIntelligenceScore());
        abilityScores.setWisdomScore(abilityScores.getWisdomScore()+racialAbilityScores.getWisdomScore());
        abilityScores.setCharismaScore(abilityScores.getCharismaScore()+racialAbilityScores.getCharismaScore());
    }
    
    private void calcLevel()
    {
        if (classes.size() > 0)
        {
            for (final CharacterClass charClass : classes)
            {
                this.level += charClass.getLevel();
            }
        }
        else
        {
            this.level = this.creatureType.getLevel();
        }

    }

    private void calcInitiative()
    {
        this.initiative = this.abilityScores.getDexterityModifier() + equipment.getBonusByTarget(BonusTarget.Dexterity) + equipment.getBonusByTarget(BonusTarget.Initiative);
        // TODO more initative calculations
    }

    private void calcBaseAttackBonus()
    {

        if (classes.size() > 0)
        {
            for (final CharacterClass charClass : classes)
            {
                baseAttackBonus += charClass.getBaseAttackBonusProgression()
                        .getBAB(charClass.getLevel());
            }
        }
        else
        {
            baseAttackBonus = creatureType.getBaseAttackBonusProgression().getBAB(
                    creatureType.getLevel());
        }
    }

    private void calcCombatManueverBonus()
    {
        combatManueverBonus = baseAttackBonus
                + abilityScores.getStrengthModifier()
                + size.getSpecialSizeModifier()
                + equipment.getBonusByTarget(BonusTarget.CMB);
    }

    /*
     * Make equipped items class that has list of target type, amount, and target of effects/buffs which constantly updates scores
     * for each element.
     */
    private void calcArmorBonuses()
    {
        armorClass = baseDefence + equipment.getBonusByTarget(BonusTarget.ArmorClass);
        flatfooted = baseDefence + equipment.getBonusByTarget(BonusTarget.FlatFooted);
        touch = baseDefence + equipment.getBonusByTarget(BonusTarget.Touch);
        combatManueverDefense = baseDefence + equipment.getBonusByTarget(BonusTarget.CMD);
    }
    
    private void calcSaves()
    {
        reflex = equipment.getBonusByTarget(BonusTarget.Reflex) + abilityScores.getDexterityModifier();
        fortitude = equipment.getBonusByTarget(BonusTarget.Fortitude) + abilityScores.getConstitutionModifier();
        will = equipment.getBonusByTarget(BonusTarget.Will) + abilityScores.getWisdomModifier();  
        for (final CharacterClass charClass : classes)
        {
            BaseSavingThrowSet baseSaves = charClass.getSavingThrowSet();
            reflex += baseSaves.getBaseReflex(charClass.getLevel());
            fortitude += baseSaves.getBaseFortitude(charClass.getLevel());
            will += baseSaves.getBaseWill(charClass.getLevel());
        }
    }
    
    private void calcDamageReduction()
    {
        damageReduction = equipment.getBonusByTarget(BonusTarget.DR);
    }
    
    private void calcSpellResistance()
    {
        spellResistance = equipment.getBonusByTarget(BonusTarget.SR);
    }

}
