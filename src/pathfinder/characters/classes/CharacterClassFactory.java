package pathfinder.characters.classes;

import pathfinder.characters.classes.alternateClasses.Antipaladin;
import pathfinder.characters.classes.alternateClasses.Ninja;
import pathfinder.characters.classes.alternateClasses.Samurai;
import pathfinder.characters.classes.baseClasses.Alchemist;
import pathfinder.characters.classes.baseClasses.Cavalier;
import pathfinder.characters.classes.baseClasses.Gunslinger;
import pathfinder.characters.classes.baseClasses.Inquisitor;
import pathfinder.characters.classes.baseClasses.Magus;
import pathfinder.characters.classes.baseClasses.Oracle;
import pathfinder.characters.classes.baseClasses.Summoner;
import pathfinder.characters.classes.baseClasses.Witch;
import pathfinder.characters.classes.coreClasses.Barbarian;
import pathfinder.characters.classes.coreClasses.Bard;
import pathfinder.characters.classes.coreClasses.Cleric;
import pathfinder.characters.classes.coreClasses.Druid;
import pathfinder.characters.classes.coreClasses.Fighter;
import pathfinder.characters.classes.coreClasses.Monk;
import pathfinder.characters.classes.coreClasses.Paladin;
import pathfinder.characters.classes.coreClasses.Ranger;
import pathfinder.characters.classes.coreClasses.Rogue;
import pathfinder.characters.classes.coreClasses.Sorcerer;
import pathfinder.characters.classes.coreClasses.Wizard;
import pathfinder.characters.classes.hybridClasses.Arcanist;
import pathfinder.characters.classes.hybridClasses.Bloodrager;
import pathfinder.characters.classes.hybridClasses.Brawler;
import pathfinder.characters.classes.hybridClasses.Hunter;
import pathfinder.characters.classes.hybridClasses.Investigator;
import pathfinder.characters.classes.hybridClasses.Shaman;
import pathfinder.characters.classes.hybridClasses.Skald;
import pathfinder.characters.classes.hybridClasses.Slayer;
import pathfinder.characters.classes.hybridClasses.SwashBuckler;
import pathfinder.characters.classes.hybridClasses.Warpriest;
import pathfinder.characters.classes.npcClasses.Adept;
import pathfinder.characters.classes.npcClasses.Aristocrat;
import pathfinder.characters.classes.npcClasses.Commoner;
import pathfinder.characters.classes.npcClasses.Expert;
import pathfinder.characters.classes.npcClasses.Warrior;

public class CharacterClassFactory
{
    public static CharacterClass buildCharacterClass(final CharacterClassEnum charClass, int level)
    {
        if (level < 0 || level > 20)
        {
            throw new IllegalArgumentException(level + " is not a valid level. Needs to be within 0 and 20.");
        }
        switch (charClass)
        {
            case Adept:
                return new Adept(level);
            case Alchemist:
                return new Alchemist(level);
            case Antipaladin:
                return new Antipaladin(level);
            case Arcanist:
                return new Arcanist(level);
            case Aristocrat:
                return new Aristocrat(level);
            case Barbarian:
                return new Barbarian(level);
            case Bard:
                return new Bard(level);
            case Bloodrager:
                return new Bloodrager(level);
            case Brawler:
                return new Brawler(level);
            case Cavalier:
                return new Cavalier(level);
            case Cleric:
                return new Cleric(level);
            case Commoner:
                return new Commoner(level);
            case Druid:
                return new Druid(level);
            case Expert:
                return new Expert(level);
            case Fighter:
                return new Fighter(level);
            case Gunslinger:
                return new Gunslinger(level);
            case Hunter:
                return new Hunter(level);
            case Inquisitor:
                return new Inquisitor(level);
            case Investigator:
                return new Investigator(level);
            case Magus:
                return new Magus(level);
            case Monk:
                return new Monk(level);
            case Ninja:
                return new Ninja(level);
            case Oracle:
                return new Oracle(level);
            case Paladin:
                return new Paladin(level);
            case Ranger:
                return new Ranger(level);
            case Rogue:
                return new Rogue(level);
            case Samurai:
                return new Samurai(level);
            case Shaman:
                return new Shaman(level);
            case Skald:
                return new Skald(level);
            case Slayer:
                return new Slayer(level);
            case Sorcerer:
                return new Sorcerer(level);
            case Summoner:
                return new Summoner(level);
            case SwashBuckler:
                return new SwashBuckler(level);
            case Warpriest:
                return new Warpriest(level);
            case Warrior:
                return new Warrior(level);
            case Witch:
                return new Witch(level);
            case Wizard:
                return new Wizard(level);
            default:
                throw new IllegalArgumentException("Invalid CharacterClass type.");
        }
    }
}
