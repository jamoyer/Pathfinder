package pathfinder.main;

import pathfinder.characters.classes.CharacterClass;
import pathfinder.characters.classes.coreClasses.Paladin;
import pathfinder.realWorldObject.SizeCategory;
import pathfinder.realWorldObject.creature.AbilityScoreSet;
import pathfinder.realWorldObject.creature.CharacterCreature;
import pathfinder.realWorldObject.creature.EquipmentSlotType;
import pathfinder.realWorldObject.creature.coreRaces.Dwarf;
import pathfinder.realWorldObject.creature.creatureType.Humanoid;
import pathfinder.realWorldObject.item.equipment.armor.Armor;
import pathfinder.realWorldObject.item.equipment.armor.ArmorName;
import pathfinder.realWorldObject.item.equipment.weapon.ManufacturedWeapon;
import pathfinder.realWorldObject.item.equipment.weapon.ManufacturedWeaponName;

public class Main
{

    public static void main(String[] args)
    {
        final AbilityScoreSet baseScores = AbilityScoreSet.roll4d6AbilityScoreSet();
        final Humanoid dwarf = new Dwarf();
        final CharacterClass pally = new Paladin(5);
        final CharacterCreature grom = new CharacterCreature(baseScores, dwarf, pally);
        System.out.println("Successfully created Grom!");

        final ManufacturedWeapon mace = new ManufacturedWeapon(EquipmentSlotType.Hands, SizeCategory.Small, ManufacturedWeaponName.MaceHeavy);
        grom.equipItem(mace);
        final Armor stonePlate = new Armor(EquipmentSlotType.Armor, SizeCategory.Medium, ArmorName.StonePlate);
        grom.equipItem(stonePlate);
        System.out.println("Successfully equipped Grom for battle!");
    }

}
