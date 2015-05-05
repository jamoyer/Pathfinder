package pathfinder.realWorldObject.creature.coreRaces;

import pathfinder.realWorldObject.creature.creatureType.Humanoid;

public class HumanoidFactory
{
    public static Humanoid buildCoreRace(final CoreRace coreRace)
    {
        switch (coreRace)
        {
            case Dwarf:
                return new Dwarf();
            case Elf:
                return new Elf();
            case Gnome:
                return new Gnome();
            case HalfElf:
                return new HalfElf();
            case HalfOrc:
                return new HalfOrc();
            case Halfling:
                return new Halfling();
            case Human:
                return new Human();
            default:
                throw new IllegalArgumentException("Not a core race!");
        }
    }
}
