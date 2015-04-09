package pathfinder.realWorldObject.creature;

import java.util.List;

import pathfinder.characters.skill.Skill;
import pathfinder.realWorldObject.RealWorldObject;
import pathfinder.realWorldObject.SizeCategory;
import pathfinder.realWorldObject.creature.baseAttackBonus.BaseAttackBonusProgression;
import pathfinder.realWorldObject.creature.classes.CharacterClass;

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
    private CreatureClass creatureType;
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
    private boolean carryable; // maybe we could just determine this property by
                               // creature weight?
    private SizeCategory size;
    // TODO abilities and such
    private Movement speeds;
    private List<Language> knownLanguages;

    /*
     * Offensive Properties
     */
    private int initiative;
    private BaseAttackBonusProgression baseAttackBonus;
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
}
