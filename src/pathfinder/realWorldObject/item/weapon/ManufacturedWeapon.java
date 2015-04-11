package pathfinder.realWorldObject.item.weapon;

import pathfinder.realWorldObject.SizeCategory;
import pathfinder.realWorldObject.creature.EquipableItem;
import pathfinder.realWorldObject.item.Item;

public abstract class ManufacturedWeapon extends EquipableItem
{
    public abstract WeaponProficiency getWeaponProficiency();
    public abstract int getDamage();
    public abstract int getCritMultiplier();
    public abstract int getCritRange();
    public abstract int getRange();//TODO, change to distance
    public abstract DamageType getDamageType();
}
