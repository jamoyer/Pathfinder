package pathfinder.realWorldObject.item.equipment.weapon;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import pathfinder.realWorldObject.item.equipment.Proficiency;

public enum ManufacturedWeaponName
{
    /*****************************************************
     *************** Simple Unarmed Attacks **************
     *****************************************************/
    Gauntlet(Proficiency.SimpleWeapon, WeaponCategory.Unarmed, 2, 0, 2, 20, 0, Collections.unmodifiableList(Arrays
            .asList(DamageType.Bludgeoning)), "pleb"),

    /*****************************************************
     *********** Simple Light Melee Weapons **************
     *****************************************************/
    BattleAspergillum(Proficiency.SimpleWeapon, WeaponCategory.LightMelee, 5, 0, 2, 20, 0, Collections
            .unmodifiableList(Arrays.asList(DamageType.Bludgeoning)), ""),
    BrassKnife(Proficiency.SimpleWeapon, WeaponCategory.LightMelee, 2, 0, 2, 19, 10, Collections.unmodifiableList(Arrays
            .asList(DamageType.Piercing, DamageType.Slashing)), ""),
    BrassKnuckles(Proficiency.SimpleWeapon, WeaponCategory.LightMelee, 1, 0, 2, 20, 0, Collections.unmodifiableList(Arrays
            .asList(DamageType.Bludgeoning)), ""),
    Cestus(Proficiency.SimpleWeapon, WeaponCategory.LightMelee, 5, 0, 2, 19, 0, Collections.unmodifiableList(Arrays.asList(
            DamageType.Piercing, DamageType.Bludgeoning)), ""),
    Dagger(Proficiency.SimpleWeapon, WeaponCategory.LightMelee, 2, 0, 2, 19, 10, Collections.unmodifiableList(Arrays.asList(
            DamageType.Piercing, DamageType.Slashing)), ""),
    DaggerPunching(Proficiency.SimpleWeapon, WeaponCategory.LightMelee, 2, 0, 3, 20, 0, Collections.unmodifiableList(Arrays
            .asList(DamageType.Piercing)), ""),
    GauntletSpiked(Proficiency.SimpleWeapon, WeaponCategory.LightMelee, 5, 0, 2, 20, 0, Collections.unmodifiableList(Arrays
            .asList(DamageType.Piercing)), ""),
    HookHand(Proficiency.SimpleWeapon, WeaponCategory.LightMelee, 10, 0, 2, 20, 0, Collections.unmodifiableList(Arrays
            .asList(DamageType.Slashing)), ""),
    Kunai(Proficiency.SimpleWeapon, WeaponCategory.LightMelee, 2, 0, 2, 20, 10, Collections.unmodifiableList(Arrays.asList(
            DamageType.Piercing, DamageType.Bludgeoning)), ""),
    MaceLight(Proficiency.SimpleWeapon, WeaponCategory.LightMelee, 5, 0, 2, 20, 0, Collections.unmodifiableList(Arrays
            .asList(DamageType.Bludgeoning)), ""),
    Sickle(Proficiency.SimpleWeapon, WeaponCategory.LightMelee, 6, 0, 2, 20, 0, Collections.unmodifiableList(Arrays
            .asList(DamageType.Slashing)), ""),
    WoodenStake(Proficiency.SimpleWeapon, WeaponCategory.LightMelee, 0, 0, 2, 20, 10, Collections.unmodifiableList(Arrays
            .asList(DamageType.Piercing)), ""),

    /*****************************************************
     ********* Simple One-Handed Melee Weapons ***********
     *****************************************************/
    Club(Proficiency.SimpleWeapon, WeaponCategory.OneHandedMelee, 0, 0, 2, 20, 10, Collections.unmodifiableList(Arrays
            .asList(DamageType.Bludgeoning)), ""),
    ClubMere(Proficiency.SimpleWeapon, WeaponCategory.OneHandedMelee, 2, 0, 2, 20, 0, Collections.unmodifiableList(Arrays
            .asList(DamageType.Piercing, DamageType.Bludgeoning)), ""),
    MaceHeavy(Proficiency.SimpleWeapon, WeaponCategory.OneHandedMelee, 12, 0, 2, 20, 0, Collections.unmodifiableList(Arrays
            .asList(DamageType.Bludgeoning)), ""),
    Morningstar(Proficiency.SimpleWeapon, WeaponCategory.OneHandedMelee, 8, 0, 2, 20, 0, Collections.unmodifiableList(Arrays
            .asList(DamageType.Piercing, DamageType.Bludgeoning)), ""),
    Shortspear(Proficiency.SimpleWeapon, WeaponCategory.OneHandedMelee, 1, 0, 2, 20, 20, Collections.unmodifiableList(Arrays
            .asList(DamageType.Piercing)), ""),

    /*****************************************************
     ********* Simple Two-Handed Melee Weapons ***********
     *****************************************************/
    Bayonet(Proficiency.SimpleWeapon, WeaponCategory.TwoHandedMelee, 5, 0, 2, 20, 0, Collections.unmodifiableList(Arrays
            .asList(DamageType.Piercing)), ""),
    BoardingPike(Proficiency.SimpleWeapon, WeaponCategory.TwoHandedMelee, 8, 0, 3, 20, 0, Collections.unmodifiableList(Arrays
            .asList(DamageType.Piercing)), ""),
    Kumade(Proficiency.SimpleWeapon, WeaponCategory.TwoHandedMelee, 5, 0, 3, 20, 0, Collections.unmodifiableList(Arrays
            .asList(DamageType.Piercing)), ""),
    KumadeComposite(Proficiency.SimpleWeapon, WeaponCategory.TwoHandedMelee, 10, 0, 3, 20, 0, Collections
            .unmodifiableList(Arrays.asList(DamageType.Piercing)), ""),
    Longspear(Proficiency.SimpleWeapon, WeaponCategory.TwoHandedMelee, 5, 0, 3, 20, 0, Collections.unmodifiableList(Arrays
            .asList(DamageType.Piercing)), ""),
    Quarterstaff(Proficiency.SimpleWeapon, WeaponCategory.TwoHandedMelee, 0, 0, 2, 20, 0, Collections.unmodifiableList(Arrays
            .asList(DamageType.Bludgeoning)), ""),
    Spear(Proficiency.SimpleWeapon, WeaponCategory.TwoHandedMelee, 2, 0, 3, 20, 20, Collections.unmodifiableList(Arrays
            .asList(DamageType.Piercing)), ""),
    SpearBoar(Proficiency.SimpleWeapon, WeaponCategory.TwoHandedMelee, 5, 0, 2, 20, 0, Collections.unmodifiableList(Arrays
            .asList(DamageType.Piercing)), ""),
    SpearWeighted(Proficiency.SimpleWeapon, WeaponCategory.TwoHandedMelee, 10, 0, 3, 20, 0, Collections
            .unmodifiableList(Arrays.asList(DamageType.Piercing, DamageType.Bludgeoning)), ""),

    /*****************************************************
     ************** Simple Ranged Weapons ****************
     *****************************************************/
    Blowgun(Proficiency.SimpleWeapon, WeaponCategory.Ranged, 2, 0, 2, 20, 20, Collections.unmodifiableList(Arrays
            .asList(DamageType.Piercing)), ""),
    CrossbowHeavy(Proficiency.SimpleWeapon, WeaponCategory.Ranged, 50, 0, 2, 19, 120, Collections.unmodifiableList(Arrays
            .asList(DamageType.Piercing)), ""),
    CrossbowHeavyUnderwater(Proficiency.SimpleWeapon, WeaponCategory.Ranged, 100, 0, 2, 19, 120, Collections
            .unmodifiableList(Arrays.asList(DamageType.Piercing)), ""),
    CrossbowLight(Proficiency.SimpleWeapon, WeaponCategory.Ranged, 35, 0, 2, 19, 80, Collections.unmodifiableList(Arrays
            .asList(DamageType.Piercing)), ""),
    CrossbowLightUnderwater(Proficiency.SimpleWeapon, WeaponCategory.Ranged, 70, 0, 2, 19, 80, Collections
            .unmodifiableList(Arrays.asList(DamageType.Piercing)), ""),
    Dart(Proficiency.SimpleWeapon, WeaponCategory.Ranged, 1, 0, 2, 20, 20, Collections.unmodifiableList(Arrays
            .asList(DamageType.Piercing)), ""),
    Javelin(Proficiency.SimpleWeapon, WeaponCategory.Ranged, 1, 0, 2, 20, 30, Collections.unmodifiableList(Arrays
            .asList(DamageType.Piercing)), ""),
    Sling(Proficiency.SimpleWeapon, WeaponCategory.Ranged, 0, 0, 2, 20, 50, Collections.unmodifiableList(Arrays
            .asList(DamageType.Bludgeoning)), ""),
    Stingchuck(Proficiency.SimpleWeapon, WeaponCategory.Ranged, 0, 0, 2, 20, 10, Collections.unmodifiableList(Arrays
            .asList(DamageType.Bludgeoning)), ""),
    Stonebow(Proficiency.SimpleWeapon, WeaponCategory.Ranged, 0, 0, 2, 20, 50, Collections.unmodifiableList(Arrays
            .asList(DamageType.Bludgeoning)), ""),

    /*****************************************************
     **************** Simple Ammunition ******************
     *****************************************************/
    BoltsCrossbow(Proficiency.SimpleWeapon, WeaponCategory.Ammunition, 1, 0, 0, 0, 0, Collections.unmodifiableList(Arrays
            .asList(DamageType.Piercing)), ""),
    BoltsAcid(Proficiency.SimpleWeapon, WeaponCategory.Ammunition, 40, 0, 0, 0, 0, Collections.unmodifiableList(Arrays
            .asList(DamageType.Piercing)), ""),
    BoltsDrowPoison(Proficiency.SimpleWeapon, WeaponCategory.Ammunition, 100, 0, 0, 0, 0, Collections.unmodifiableList(Arrays
            .asList(DamageType.Piercing)), ""),
    BoltsFire(Proficiency.SimpleWeapon, WeaponCategory.Ammunition, 50, 0, 0, 0, 0, Collections.unmodifiableList(Arrays
            .asList(DamageType.Piercing)), ""),
    BulletsGroaning(Proficiency.SimpleWeapon, WeaponCategory.Ammunition, 2, 0, 0, 0, 0, Collections.unmodifiableList(Arrays
            .asList(DamageType.Bludgeoning)), ""),
    BulletsSling(Proficiency.SimpleWeapon, WeaponCategory.Ammunition, 1, 0, 0, 0, 0, Collections.unmodifiableList(Arrays
            .asList(DamageType.Bludgeoning)), ""),
    BulletsSmoke(Proficiency.SimpleWeapon, WeaponCategory.Ammunition, 100, 0, 0, 0, 0, Collections.unmodifiableList(Arrays
            .asList(DamageType.Bludgeoning)), ""),
    DartsBlowgun(Proficiency.SimpleWeapon, WeaponCategory.Ammunition, 1, 0, 0, 0, 0, Collections.unmodifiableList(Arrays
            .asList(DamageType.Piercing)), "");

    private Proficiency weaponProficiency;
    private WeaponCategory weaponCategory;
    private int cost;
    private int damageProgressionIndex;
    private int critMultiplier;
    private int critRange;
    private int range;
    private List<DamageType> damageTypes;
    private String description;

    private ManufacturedWeaponName(Proficiency weaponProficiency, WeaponCategory weaponCategory, int cost,
            int damageProgressionIndex, int critMultiplier, int critRange, int range, List<DamageType> damageTypes,
            String description)
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

    public Proficiency getWeaponProficiency()
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
