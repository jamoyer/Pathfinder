package pathfinder.realWorldObject.item.equipment.armor;

import pathfinder.bonusTypes.BonusType;
import pathfinder.realWorldObject.SizeCategory;
import pathfinder.realWorldObject.creature.EquipableItem;
import pathfinder.realWorldObject.creature.Movement;
import pathfinder.realWorldObject.item.Item;

public abstract class Armor extends EquipableItem
{
    public abstract BonusType getBonusType();
    public abstract int getArmorValue();
    public abstract int getMaxDexBonus();
    public abstract int getArmorCheckPenalty();
    public abstract double getArcaneSpellFailureChance();
    public abstract int getSpeedPenalty(Movement speed);
}
