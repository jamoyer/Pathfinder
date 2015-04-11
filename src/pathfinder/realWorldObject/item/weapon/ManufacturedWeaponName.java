package pathfinder.realWorldObject.item.weapon;


public enum ManufacturedWeaponName
{
    Gauntlet(WeaponProficiency.Simple, WeaponCategory.Unarmed, 2, 0, 2, 20, 0, DamageType.Bludgeoning, "pleb");
    
    private WeaponProficiency weaponProficiency;
    private WeaponCategory weaponCategory;
    private int cost;
    private int damageProgressionIndex;
    private int critMultiplier;
    private int critRange;
    private int range;
    private DamageType damageType;
    private String description;
    
    private ManufacturedWeaponName(WeaponProficiency weaponProficiency,
            WeaponCategory weaponCategory, int cost,
            int damageProgressionIndex, int critMultiplier, int critRange,
            int range, DamageType damageType, String description)
    {
        this.weaponProficiency = weaponProficiency;
        this.weaponCategory = weaponCategory;
        this.cost = cost;
        this.damageProgressionIndex = damageProgressionIndex;
        this.critMultiplier = critMultiplier;
        this.critRange = critRange;
        this.range = range;
        this.damageType = damageType;
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
    
    public int getDamageProgressionIndex()
    {
        return damageProgressionIndex;
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

    public DamageType getDamageType()
    {
        return damageType;
    }
    
    public String getDescription()
    {
        return description;
    }
}
