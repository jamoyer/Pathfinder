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
    private final DiceSet damage;
    private final int damageProgressionIndex;
    private final int critMultiplier;
    private final int critRange;
    private final int range;
    private final List<DamageType> damageTypes;
    private String description;

    public ManufacturedWeapon(EquipmentSlotType slot, SizeCategory sizeCategory, Proficiency weaponProficiency, WeaponCategory weaponCategory, int cost,
            int damageProgressionIndex, int critMultiplier, int critRange, int range, List<DamageType> damageTypes, String decription, int weight)
    {
        super(slot, sizeCategory, cost);
        this.weaponProficiency = weaponProficiency;
        this.weaponCategory = weaponCategory;
        this.damageProgressionIndex = damageProgressionIndex;
        this.damage = DiceSet.getDieForDamage(this.getSizeCategory(), this.damageProgressionIndex);
        this.critMultiplier = critMultiplier;
        this.critRange = critRange;
        this.range = range;
        this.damageTypes = damageTypes;
        super.setWeight(weight);
    }

    public ManufacturedWeapon(SizeCategory sizeCategory, ManufacturedWeaponName weaponName)
    {
        super(weaponName.getEquipmentSlotType(), sizeCategory, weaponName.getCost());
        this.weaponProficiency = weaponName.getWeaponProficiency();
        this.weaponCategory = weaponName.getWeaponCategory();
        this.damageProgressionIndex = weaponName.getDamageProgressionIndex();
        this.damage = DiceSet.getDieForDamage(this.getSizeCategory(), this.damageProgressionIndex);
        this.critMultiplier = weaponName.getCritMultiplier();
        this.critRange = weaponName.getCritRange();
        this.range = weaponName.getRange();
        this.damageTypes = weaponName.getDamageTypes();
        super.setWeight(weaponName.getWeight());
    }

    public Proficiency getWeaponProficiency()
    {
        return weaponProficiency;
    }

    public WeaponCategory getWeaponCategory()
    {
        return weaponCategory;
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

    /**
     * Returns the size of creature this weapon is intended for. Light Weapons are intended for
     * creatures two sizes larger and one-handed are for one size larger.
     *
     * @param actualWeaponSize
     * @param category
     * @return
     */
    public static SizeCategory getCreatureSizeForWeapon(final SizeCategory actualWeaponSize, final WeaponCategory category)
    {
        int sizeIndex = actualWeaponSize.ordinal();
        switch (category)
        {
            case LightMelee:
                sizeIndex += 2;
                break;
            case OneHandedMelee:
                sizeIndex += 1;
                break;
            case Ranged:
            case TwoHandedMelee:
            case Ammunition:
            case Unarmed:
            default:
                break;
        }
        return SizeCategory.getSizeCategoryByOrdinal(sizeIndex);
    }
}
