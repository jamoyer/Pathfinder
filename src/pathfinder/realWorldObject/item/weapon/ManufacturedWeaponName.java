package pathfinder.realWorldObject.item.weapon;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public enum ManufacturedWeaponName
{
	/*****************************************************
     *************** Simple Unarmed Attacks **************
     *****************************************************/
    Gauntlet(WeaponProficiency.Simple, WeaponCategory.Unarmed, 2, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Bludgeoning)), "pleb"),
    
    /*****************************************************
     *********** Simple Light Melee Weapons **************
     *****************************************************/
    BattleAspergillum(WeaponProficiency.Simple, WeaponCategory.LightMelee, 5, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Bludgeoning)), ""),
    BrassKnife(WeaponProficiency.Simple, WeaponCategory.LightMelee, 2, 0, 2, 19, 10, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing,
            DamageType.Slashing)), ""),
    BrassKnuckles(WeaponProficiency.Simple, WeaponCategory.LightMelee, 1, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Bludgeoning)), ""),
    Cestus(WeaponProficiency.Simple, WeaponCategory.LightMelee, 5, 0, 2, 19, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing,
            DamageType.Bludgeoning)), ""),
    Dagger(WeaponProficiency.Simple, WeaponCategory.LightMelee, 2, 0, 2, 19, 10, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing,
            DamageType.Slashing)), ""),
    DaggerPunching(WeaponProficiency.Simple, WeaponCategory.LightMelee, 2, 0, 3, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), ""),
    GauntletSpiked(WeaponProficiency.Simple, WeaponCategory.LightMelee, 5, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), ""),
    HookHand(WeaponProficiency.Simple, WeaponCategory.LightMelee, 10, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Slashing)), ""),
    Kunai(WeaponProficiency.Simple, WeaponCategory.LightMelee, 2, 0, 2, 20, 10, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing,
            DamageType.Bludgeoning)), ""),
    MaceLight(WeaponProficiency.Simple, WeaponCategory.LightMelee, 5, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Bludgeoning)), ""),
    Sickle(WeaponProficiency.Simple, WeaponCategory.LightMelee, 6, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Slashing)), ""),
    WoodenStake(WeaponProficiency.Simple, WeaponCategory.LightMelee, 0, 0, 2, 20, 10, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), ""),
    
    /*****************************************************
     ********* Simple One-Handed Melee Weapons ***********
     *****************************************************/
    Club(WeaponProficiency.Simple, WeaponCategory.OneHandedMelee, 0, 0, 2, 20, 10, Collections.unmodifiableList(Arrays.asList(DamageType.Bludgeoning)), ""),
    ClubMere(WeaponProficiency.Simple, WeaponCategory.OneHandedMelee, 2, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing,
            DamageType.Bludgeoning)), ""),
    MaceHeavy(WeaponProficiency.Simple, WeaponCategory.OneHandedMelee, 12, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Bludgeoning)), ""),
    Morningstar(WeaponProficiency.Simple, WeaponCategory.OneHandedMelee, 8, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing,
            DamageType.Bludgeoning)), ""),
    Shortspear(WeaponProficiency.Simple, WeaponCategory.OneHandedMelee, 1, 0, 2, 20, 20, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), ""),
    
    /*****************************************************
     ********* Simple Two-Handed Melee Weapons ***********
     *****************************************************/
    Bayonet(WeaponProficiency.Simple, WeaponCategory.TwoHandedMelee, 5, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), ""),
    BoardingPike(WeaponProficiency.Simple, WeaponCategory.TwoHandedMelee, 8, 0, 3, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), ""),
    Kumade(WeaponProficiency.Simple, WeaponCategory.TwoHandedMelee, 5, 0, 3, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), ""),
    KumadeComposite(WeaponProficiency.Simple, WeaponCategory.TwoHandedMelee, 10, 0, 3, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), ""),
    Longspear(WeaponProficiency.Simple, WeaponCategory.TwoHandedMelee, 5, 0, 3, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), ""),
    Quarterstaff(WeaponProficiency.Simple, WeaponCategory.TwoHandedMelee, 0, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Bludgeoning)), ""),
    Spear(WeaponProficiency.Simple, WeaponCategory.TwoHandedMelee, 2, 0, 3, 20, 20, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), ""),
    SpearBoar(WeaponProficiency.Simple, WeaponCategory.TwoHandedMelee, 5, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), ""),
    SpearWeighted(WeaponProficiency.Simple, WeaponCategory.TwoHandedMelee, 10, 0, 3, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing,
    		DamageType.Bludgeoning)), ""),
    
    /*****************************************************
     ************** Simple Ranged Weapons ****************
     *****************************************************/
    Blowgun(WeaponProficiency.Simple, WeaponCategory.Ranged, 2, 0, 2, 20, 20, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), ""),
    CrossbowHeavy(WeaponProficiency.Simple, WeaponCategory.Ranged, 50, 0, 2, 19, 120, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), ""),
    CrossbowHeavyUnderwater(WeaponProficiency.Simple, WeaponCategory.Ranged, 100, 0, 2, 19, 120, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), ""),
    CrossbowLight(WeaponProficiency.Simple, WeaponCategory.Ranged, 35, 0, 2, 19, 80, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), ""),
    CrossbowLightUnderwater(WeaponProficiency.Simple, WeaponCategory.Ranged, 70, 0, 2, 19, 80, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), ""),
    Dart(WeaponProficiency.Simple, WeaponCategory.Ranged, 1, 0, 2, 20, 20, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), ""),
    Javelin(WeaponProficiency.Simple, WeaponCategory.Ranged, 1, 0, 2, 20, 30, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), ""),
    Sling(WeaponProficiency.Simple, WeaponCategory.Ranged, 0, 0, 2, 20, 50, Collections.unmodifiableList(Arrays.asList(DamageType.Bludgeoning)), ""),
    Stingchuck(WeaponProficiency.Simple, WeaponCategory.Ranged, 0, 0, 2, 20, 10, Collections.unmodifiableList(Arrays.asList(DamageType.Bludgeoning)), ""),
    Stonebow(WeaponProficiency.Simple, WeaponCategory.Ranged, 0, 0, 2, 20, 50, Collections.unmodifiableList(Arrays.asList(DamageType.Bludgeoning)), ""),
    
    /*****************************************************
     **************** Simple Ammunition ******************
     *****************************************************/
    BoltsCrossbow(WeaponProficiency.Simple, WeaponCategory.Ammunition, 1, 0, 0, 0, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), ""),
    BoltsAcid(WeaponProficiency.Simple, WeaponCategory.Ammunition, 40, 0, 0, 0, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), ""),
    BoltsDrowPoison(WeaponProficiency.Simple, WeaponCategory.Ammunition, 100, 0, 0, 0, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), ""),
    BoltsFire(WeaponProficiency.Simple, WeaponCategory.Ammunition, 50, 0, 0, 0, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), ""),
    BulletsGroaning(WeaponProficiency.Simple, WeaponCategory.Ammunition, 2, 0, 0, 0, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Bludgeoning)), ""),
    BulletsSling(WeaponProficiency.Simple, WeaponCategory.Ammunition, 1, 0, 0, 0, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Bludgeoning)), ""),
    BulletsSmoke(WeaponProficiency.Simple, WeaponCategory.Ammunition, 100, 0, 0, 0, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Bludgeoning)), ""),
    DartsBlowgun(WeaponProficiency.Simple, WeaponCategory.Ammunition, 1, 0, 0, 0, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "");
    
    private WeaponProficiency weaponProficiency;
    private WeaponCategory weaponCategory;
    private int cost;
    private int damageProgressionIndex;
    private int critMultiplier;
    private int critRange;
    private int range;
    private List<DamageType> damageTypes;
    private String description;
    
    private ManufacturedWeaponName(WeaponProficiency weaponProficiency,
            WeaponCategory weaponCategory, int cost,
            int damageProgressionIndex, int critMultiplier, int critRange,
            int range, List<DamageType> damageTypes, String description)
    {
        this.weaponProficiency = weaponProficiency;
        this.weaponCategory = weaponCategory;
        this.cost = cost;
        this.damageProgressionIndex = damageProgressionIndex;
        this.critMultiplier = critMultiplier;
        this.critRange = critRange;
        this.range = range;
        this.damageTypes = damageTypes;
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

    public List<DamageType> getDamageTypes()
    {
        return damageTypes;
    }

    public String getDescription()
    {
        return description;
    }
}
