package pathfinder.realWorldObject.creature;

import java.util.List;

import pathfinder.characters.baseAttackBonus.BaseAttackBonusProgression;
import pathfinder.characters.classes.CharacterClass;
import pathfinder.characters.classes.ClassInterface;
import pathfinder.characters.skill.Skill;
import pathfinder.realWorldObject.RealWorldObject;
import pathfinder.realWorldObject.SizeCategory;
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
public class Creature extends RealWorldObject
{
    private CreatureType race;
    private int level;
    private int hitDie;
    private List<CharacterClass> classes;
    private CreatureDescription description;
    private AbilityScores abilityScores;
    private List<Skill> skills;
    private List<EquipmentSlot> equippedItems;
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

    public Creature(final CreatureType race, final AbilityScores baseStats)
    {
        this.race = race;
        this.abilityScores = baseStats;
    }

    private void initCreature()
    {
        calcLevel();
        this.size = this.race.getSizeCategory();
        this.speeds = this.race.getMoveSpeeds();
        calcInitiative();
        calcBaseAttackBonus();
        calcCombatManueverBonus();
    }

    private void calcLevel()
    {
        if (classes.size() > 0)
        {
            for (CharacterClass charClass : classes)
            {
                this.level += charClass.getLevel();
            }
        }
        else
        {
            this.level = this.race.getLevel();
        }

    }

    private void calcInitiative()
    {
        this.initiative = this.abilityScores.getDexterityModifier();
        // TODO more initative calculations
    }

    private void calcBaseAttackBonus()
    {

        if (classes.size() > 0)
        {
            for (CharacterClass charClass : classes)
            {
                baseAttackBonus += charClass.getBaseAttackBonusProgression()
                        .getBAB(charClass.getLevel());
            }
        }
        else
        {
            baseAttackBonus = race.getBaseAttackBonusProgression().getBAB(
                    race.getLevel());
        }
    }

    private void calcCombatManueverBonus()
    {
        combatManueverBonus = baseAttackBonus
                + abilityScores.getStrengthModifier()
                + size.getSpecialSizeModifier();
    }
    
    /*
     * Make equipped items class that has list of target type, amount, and target of effects/buffs which constantly updates scores
     * for each element.
     */
    private void calcArmorClass()
    {
    	
    }

}
