package pathfinder.characters.classes;

/**
 * For lack of a better name. This allows us to get a list of all character classes and use the
 * factory to build them by name.
 *
 * @author Jamoyer
 *
 */
public enum CharacterClassEnum
{
    /*****************************************************
     ******************** Core Classes *******************
     *****************************************************/
    Barbarian,
    Bard,
    Cleric,
    Druid,
    Fighter,
    Monk,
    Paladin,
    Ranger,
    Rogue,
    Sorcerer,
    Wizard,

    /*****************************************************
     ******************** Base Classes *******************
     *****************************************************/
    Alchemist,
    Cavalier,
    Gunslinger,
    Inquisitor,
    Magus,
    Oracle,
    Summoner,
    Witch,

    /*****************************************************
     ****************** Alternate Classes ****************
     *****************************************************/
    Antipaladin,
    Ninja,
    Samurai,

    /*****************************************************
     ******************* Hybrid Classes ******************
     *****************************************************/
    Arcanist,
    Bloodrager,
    Brawler,
    Hunter,
    Investigator,
    Shaman,
    Skald,
    Slayer,
    SwashBuckler,
    Warpriest,

    /*****************************************************
     ******************** NPC Classes ********************
     *****************************************************/
    Adept,
    Aristocrat,
    Commoner, // lol pleb
    Expert,
    Warrior;
}
