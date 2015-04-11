package pathfinder.realWorldObject.item.weapon;

import java.util.List;

import pathfinder.metaObjects.Die;
import pathfinder.realWorldObject.SizeCategory;
import pathfinder.realWorldObject.creature.EquipableItem;
import pathfinder.realWorldObject.creature.EquipmentSlotType;

public class ManufacturedWeapon extends EquipableItem implements Cloneable
{
    private WeaponProficiency weaponProficiency;
    private WeaponCategory weaponCategory;
    private int cost;
    private Die damage;
    private int damageProgressionIndex;
    private int critMultiplier;
    private int critRange;
    private int range;
    private List<DamageType> damageTypes;
    private String description;

    public ManufacturedWeapon(EquipmentSlotType slot,
            SizeCategory sizeCategory, WeaponProficiency weaponProficiency,
            WeaponCategory weaponCategory, int cost,
            int damageProgressionIndex, int critMultiplier, int critRange,
            int range, List<DamageType> damageTypes, String decription)
    {
        super(slot, sizeCategory);
        this.weaponProficiency = weaponProficiency;
        this.weaponCategory = weaponCategory;
        this.cost = cost;
        this.damageProgressionIndex = damageProgressionIndex;
        this.damage = Die.getDieForDamage(this.getSizeCategory(),
                this.damageProgressionIndex);
        this.critMultiplier = critMultiplier;
        this.critRange = critRange;
        this.range = range;
        this.damageTypes = damageTypes;
    }

    public ManufacturedWeapon(EquipmentSlotType slot,
            SizeCategory sizeCategory, ManufacturedWeaponName weaponName)
    {
        super(slot, sizeCategory);
        this.weaponProficiency = weaponName.getWeaponProficiency();
        this.weaponCategory = weaponName.getWeaponCategory();
        this.cost = weaponName.getCost();
        this.damageProgressionIndex = weaponName.getDamageProgressionIndex();
        this.damage = Die.getDieForDamage(this.getSizeCategory(),
                this.damageProgressionIndex);
        this.critMultiplier = weaponName.getCritMultiplier();
        this.critRange = weaponName.getCritRange();
        this.range = weaponName.getRange();
        this.damageTypes = weaponName.getDamageTypes();
    }

    public WeaponProficiency getWeaponProficiency()
    {
        return weaponProficiency;
    }

    public WeaponCategory getWeaponCategory()
    {
        return weaponCategory;
    }

    public int getCost()
    {
        return cost;
    }

    public Die getDamage()
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
        return new ManufacturedWeapon(this.getSlotType(),
                this.getSizeCategory(), weaponProficiency, weaponCategory,
                cost, damageProgressionIndex, critMultiplier, critRange, range,
                damageTypes, description);
    }
}
