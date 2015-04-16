package pathfinder.realWorldObject.item.equipment.weapon;

import java.util.List;

import pathfinder.metaObjects.DiceSet;
import pathfinder.realWorldObject.SizeCategory;
import pathfinder.realWorldObject.creature.EquipmentSlotType;
import pathfinder.realWorldObject.creature.EquippableItem;
import pathfinder.realWorldObject.item.equipment.Proficiency;

public class ManufacturedWeapon extends EquippableItem implements Cloneable
{
    private final Proficiency weaponProficiency;
    private final WeaponCategory weaponCategory;
    private final int cost;
    private final DiceSet damage;
    private final int damageProgressionIndex;
    private final int critMultiplier;
    private final int critRange;
    private final int range;
    private final List<DamageType> damageTypes;
    private String description;

    public ManufacturedWeapon(EquipmentSlotType slot, SizeCategory sizeCategory, Proficiency weaponProficiency, WeaponCategory weaponCategory, int cost,
            int damageProgressionIndex, int critMultiplier, int critRange, int range, List<DamageType> damageTypes, String decription)
    {
        super(slot, sizeCategory);
        this.weaponProficiency = weaponProficiency;
        this.weaponCategory = weaponCategory;
        this.cost = cost;
        this.damageProgressionIndex = damageProgressionIndex;
        this.damage = DiceSet.getDieForDamage(this.getSizeCategory(), this.damageProgressionIndex);
        this.critMultiplier = critMultiplier;
        this.critRange = critRange;
        this.range = range;
        this.damageTypes = damageTypes;
    }

    public ManufacturedWeapon(SizeCategory sizeCategory, ManufacturedWeaponName weaponName)
    {
        super(weaponName.getEquipmentSlotType(), sizeCategory);
        this.weaponProficiency = weaponName.getWeaponProficiency();
        this.weaponCategory = weaponName.getWeaponCategory();
        this.cost = weaponName.getCost();
        this.damageProgressionIndex = weaponName.getDamageProgressionIndex();
        this.damage = DiceSet.getDieForDamage(this.getSizeCategory(), this.damageProgressionIndex);
        this.critMultiplier = weaponName.getCritMultiplier();
        this.critRange = weaponName.getCritRange();
        this.range = weaponName.getRange();
        this.damageTypes = weaponName.getDamageTypes();
    }

    public Proficiency getWeaponProficiency()
    {
        return weaponProficiency;
    }

    public WeaponCategory getWeaponCategory()
    {
        return weaponCategory;
    }

    @Override
    public int getCost()
    {
        return cost;
    }

    public DiceSet getDamage()
    {
        return damage;
    }

    public int getCritMultiplier()
    {
        return critMultiplier;
    }

    public int getCritRange()
    {
        return critRange;
    }

    public int getRange() // TODO, change to distance
    {
        return range;
    }

    public List<DamageType> getDamageTypes()
    {
        return damageTypes;
    }

    public String getDescription()
    {
        return description;
    }

    @Override
    public Object clone()
    {
        return new ManufacturedWeapon(this.getSlotType(), this.getSizeCategory(), weaponProficiency, weaponCategory, cost, damageProgressionIndex, critMultiplier, critRange,
                range, damageTypes, description);
    }
}
