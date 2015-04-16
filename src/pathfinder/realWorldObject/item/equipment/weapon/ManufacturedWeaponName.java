package pathfinder.realWorldObject.item.equipment.weapon;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import pathfinder.realWorldObject.creature.EquipmentSlotType;
import pathfinder.realWorldObject.item.equipment.Proficiency;

/*
 * TODO add weight to this table
 */

public enum ManufacturedWeaponName
{
    /*****************************************************
     *************** Simple Unarmed Attacks **************
     *****************************************************/
    Gauntlet(Proficiency.SimpleWeapon, WeaponCategory.Unarmed, 2, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Bludgeoning)), "pleb", 1),

    /*****************************************************
     *********** Simple Light Melee Weapons **************
     *****************************************************/
    BattleAspergillum(Proficiency.SimpleWeapon, WeaponCategory.LightMelee, 5, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Bludgeoning)), "", 4),
    BrassKnife(Proficiency.SimpleWeapon, WeaponCategory.LightMelee, 2, 0, 2, 19, 10, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing, DamageType.Slashing)), "", 1),
    BrassKnuckles(Proficiency.SimpleWeapon, WeaponCategory.LightMelee, 1, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Bludgeoning)), "", 1),
    Cestus(Proficiency.SimpleWeapon, WeaponCategory.LightMelee, 5, 0, 2, 19, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing, DamageType.Bludgeoning)), "", 1),
    Dagger(Proficiency.SimpleWeapon, WeaponCategory.LightMelee, 2, 0, 2, 19, 10, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing, DamageType.Slashing)), "", 1),
    DaggerPunching(Proficiency.SimpleWeapon, WeaponCategory.LightMelee, 2, 0, 3, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "", 1),
    GauntletSpiked(Proficiency.SimpleWeapon, WeaponCategory.LightMelee, 5, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "", 1),
    HookHand(Proficiency.SimpleWeapon, WeaponCategory.LightMelee, 10, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Slashing)), "", 1),
    Kunai(Proficiency.SimpleWeapon, WeaponCategory.LightMelee, 2, 0, 2, 20, 10, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing, DamageType.Bludgeoning)), "", 2),
    MaceLight(Proficiency.SimpleWeapon, WeaponCategory.LightMelee, 5, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Bludgeoning)), "", 4),
    Sickle(Proficiency.SimpleWeapon, WeaponCategory.LightMelee, 6, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Slashing)), "", 2),
    WoodenStake(Proficiency.SimpleWeapon, WeaponCategory.LightMelee, 0, 0, 2, 20, 10, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "", 1),

    /*****************************************************
     ********* Simple One-Handed Melee Weapons ***********
     *****************************************************/
    Club(Proficiency.SimpleWeapon, WeaponCategory.OneHandedMelee, 0, 0, 2, 20, 10, Collections.unmodifiableList(Arrays.asList(DamageType.Bludgeoning)), "", 3),
    ClubMere(Proficiency.SimpleWeapon, WeaponCategory.OneHandedMelee, 2, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing, DamageType.Bludgeoning)), "", 2),
    MaceHeavy(Proficiency.SimpleWeapon, WeaponCategory.OneHandedMelee, 12, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Bludgeoning)), "", 8),
    Morningstar(Proficiency.SimpleWeapon, WeaponCategory.OneHandedMelee, 8, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing, DamageType.Bludgeoning)), "", 6),
    Shortspear(Proficiency.SimpleWeapon, WeaponCategory.OneHandedMelee, 1, 0, 2, 20, 20, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "", 3),

    /*****************************************************
     ********* Simple Two-Handed Melee Weapons ***********
     *****************************************************/
    Bayonet(Proficiency.SimpleWeapon, WeaponCategory.TwoHandedMelee, 5, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "", 1),
    BoardingPike(Proficiency.SimpleWeapon, WeaponCategory.TwoHandedMelee, 8, 0, 3, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "", 9),
    Kumade(Proficiency.SimpleWeapon, WeaponCategory.TwoHandedMelee, 5, 0, 3, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "", 4),
    KumadeCollapsible(Proficiency.SimpleWeapon, WeaponCategory.TwoHandedMelee, 10, 0, 3, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "", 4),
    Longspear(Proficiency.SimpleWeapon, WeaponCategory.TwoHandedMelee, 5, 0, 3, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "", 9),
    Quarterstaff(Proficiency.SimpleWeapon, WeaponCategory.TwoHandedMelee, 0, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Bludgeoning)), "", 4),
    Spear(Proficiency.SimpleWeapon, WeaponCategory.TwoHandedMelee, 2, 0, 3, 20, 20, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "", 6),
    SpearBoar(Proficiency.SimpleWeapon, WeaponCategory.TwoHandedMelee, 5, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "", 8),
    SpearWeighted(Proficiency.SimpleWeapon, WeaponCategory.TwoHandedMelee, 10, 0, 3, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing, DamageType.Bludgeoning)), "", 8),

    /*****************************************************
     ************** Simple Ranged Weapons ****************
     *****************************************************/
    Blowgun(Proficiency.SimpleWeapon, WeaponCategory.Ranged, 2, 0, 2, 20, 20, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "", 1),
    CrossbowHeavy(Proficiency.SimpleWeapon, WeaponCategory.Ranged, 50, 0, 2, 19, 120, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "", 8),
    CrossbowHeavyUnderwater(Proficiency.SimpleWeapon, WeaponCategory.Ranged, 100, 0, 2, 19, 120, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "", 8),
    CrossbowLight(Proficiency.SimpleWeapon, WeaponCategory.Ranged, 35, 0, 2, 19, 80, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "", 4),
    CrossbowLightUnderwater(Proficiency.SimpleWeapon, WeaponCategory.Ranged, 70, 0, 2, 19, 80, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "", 4),
    Dart(Proficiency.SimpleWeapon, WeaponCategory.Ranged, 1, 0, 2, 20, 20, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "", 1),
    Javelin(Proficiency.SimpleWeapon, WeaponCategory.Ranged, 1, 0, 2, 20, 30, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "", 2),
    Sling(Proficiency.SimpleWeapon, WeaponCategory.Ranged, 0, 0, 2, 20, 50, Collections.unmodifiableList(Arrays.asList(DamageType.Bludgeoning)), "", 0),
    Stingchuck(Proficiency.SimpleWeapon, WeaponCategory.Ranged, 0, 0, 2, 20, 10, Collections.unmodifiableList(Arrays.asList(DamageType.Bludgeoning)), "", 9),
    Stonebow(Proficiency.SimpleWeapon, WeaponCategory.Ranged, 0, 0, 2, 20, 50, Collections.unmodifiableList(Arrays.asList(DamageType.Bludgeoning)), "", 4),

    /*****************************************************
     **************** Simple Ammunition ******************
     *****************************************************/
    BoltsCrossbow(Proficiency.SimpleWeapon, WeaponCategory.Ammunition, 1, 0, 0, 0, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "", 0),
    BoltsAcid(Proficiency.SimpleWeapon, WeaponCategory.Ammunition, 40, 0, 0, 0, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "", 0),
    BoltsDrowPoison(Proficiency.SimpleWeapon, WeaponCategory.Ammunition, 100, 0, 0, 0, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "", 0),
    BoltsFire(Proficiency.SimpleWeapon, WeaponCategory.Ammunition, 50, 0, 0, 0, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "", 0),
    BulletsGroaning(Proficiency.SimpleWeapon, WeaponCategory.Ammunition, 2, 0, 0, 0, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Bludgeoning)), "", 0),
    BulletsSling(Proficiency.SimpleWeapon, WeaponCategory.Ammunition, 1, 0, 0, 0, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Bludgeoning)), "", 0),
    BulletsSmoke(Proficiency.SimpleWeapon, WeaponCategory.Ammunition, 100, 0, 0, 0, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Bludgeoning)), "", 0),
    DartsBlowgun(Proficiency.SimpleWeapon, WeaponCategory.Ammunition, 1, 0, 0, 0, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "", 0),

    /*****************************************************
     *********** Martial Light Melee Weapons *************
     *****************************************************/
    AxeBoarding(Proficiency.MartialWeapon, WeaponCategory.LightMelee, 6, 0, 3, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing, DamageType.Slashing)), "", 3),
    AxeThrowing(Proficiency.MartialWeapon, WeaponCategory.LightMelee, 8, 0, 2, 20, 10, Collections.unmodifiableList(Arrays.asList(DamageType.Slashing)), "", 2),
    BladeBoot(Proficiency.MartialWeapon, WeaponCategory.LightMelee, 25, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "", 2),
    CatONineTails(Proficiency.MartialWeapon, WeaponCategory.LightMelee, 1, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Slashing)), "", 1),
    DogSlicer(Proficiency.MartialWeapon, WeaponCategory.LightMelee, 8, 0, 2, 19, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Slashing)), "", 1),
    HammerLight(Proficiency.MartialWeapon, WeaponCategory.LightMelee, 1, 0, 2, 20, 20, Collections.unmodifiableList(Arrays.asList(DamageType.Bludgeoning)), "", 2),
    Gladius(Proficiency.MartialWeapon, WeaponCategory.LightMelee, 15, 0, 2, 19, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Slashing, DamageType.Piercing)), "", 3),
    Handaxe(Proficiency.MartialWeapon, WeaponCategory.LightMelee, 6, 0, 3, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Slashing)), "", 3),
    KnifeSwitchblade(Proficiency.MartialWeapon, WeaponCategory.LightMelee, 5, 0, 2, 19, 10, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "", 1),
    KoboldTailLongLash(Proficiency.MartialWeapon, WeaponCategory.LightMelee, 15, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Slashing)), "", 1),
    KoboldTailPounder(Proficiency.MartialWeapon, WeaponCategory.LightMelee, 1, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Bludgeoning)), "", 4),
    KoboldTailRazored(Proficiency.MartialWeapon, WeaponCategory.LightMelee, 3, 0, 2, 19, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Slashing)), "", 2),
    KoboldTailSpiked(Proficiency.MartialWeapon, WeaponCategory.LightMelee, 3, 0, 3, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "", 2),
    KoboldTailSweeper(Proficiency.MartialWeapon, WeaponCategory.LightMelee, 7, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Bludgeoning)), "", 3),
    Kukri(Proficiency.MartialWeapon, WeaponCategory.LightMelee, 8, 0, 2, 18, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Slashing)), "", 2),
    Machete(Proficiency.MartialWeapon, WeaponCategory.LightMelee, 10, 0, 2, 19, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Slashing)), "", 2),
    PickLight(Proficiency.MartialWeapon, WeaponCategory.LightMelee, 4, 0, 4, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "", 3),
    RatfolkTailblade(Proficiency.MartialWeapon, WeaponCategory.LightMelee, 11, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Slashing)), "", 1),
    Sap(Proficiency.MartialWeapon, WeaponCategory.LightMelee, 1, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Bludgeoning)), "", 2),
    SeaKnife(Proficiency.MartialWeapon, WeaponCategory.LightMelee, 8, 0, 2, 19, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Slashing)), "", 1),
    Starknife(Proficiency.MartialWeapon, WeaponCategory.LightMelee, 24, 0, 3, 20, 20, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "", 3),
    SwordShort(Proficiency.MartialWeapon, WeaponCategory.LightMelee, 10, 0, 2, 19, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "", 2),
    WarRazor(Proficiency.MartialWeapon, WeaponCategory.LightMelee, 8, 0, 2, 19, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Slashing)), "", 1),

    /*****************************************************
     ********* Martial One-Handed Melee Weapons **********
     *****************************************************/
    Ankus(Proficiency.MartialWeapon, WeaponCategory.OneHandedMelee, 8, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "", 5),
    Battleaxe(Proficiency.MartialWeapon, WeaponCategory.OneHandedMelee, 10, 0, 3, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Slashing)), "", 6),
    CombatScabbard(Proficiency.MartialWeapon, WeaponCategory.OneHandedMelee, 1, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Bludgeoning)), "", 1),
    Cutlass(Proficiency.MartialWeapon, WeaponCategory.OneHandedMelee, 15, 0, 2, 18, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Slashing)), "", 4),
    Flail(Proficiency.MartialWeapon, WeaponCategory.OneHandedMelee, 8, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Bludgeoning)), "", 5),
    Gandasa(Proficiency.MartialWeapon, WeaponCategory.OneHandedMelee, 15, 0, 3, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Slashing)), "", 4),
    Klar(Proficiency.MartialWeapon, WeaponCategory.OneHandedMelee, 12, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Slashing)), "", 6),
    Longsword(Proficiency.MartialWeapon, WeaponCategory.OneHandedMelee, 15, 0, 2, 19, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Slashing)), "", 4),
    Manople(Proficiency.MartialWeapon, WeaponCategory.OneHandedMelee, 17, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Slashing, DamageType.Piercing)), "", 4),
    PickHeavy(Proficiency.MartialWeapon, WeaponCategory.OneHandedMelee, 8, 0, 4, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "", 6),
    Rapier(Proficiency.MartialWeapon, WeaponCategory.OneHandedMelee, 20, 0, 2, 18, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "", 2),
    CombatScabbardSharpened(Proficiency.MartialWeapon, WeaponCategory.OneHandedMelee, 10, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Slashing)), "", 1),
    Scimitar(Proficiency.MartialWeapon, WeaponCategory.OneHandedMelee, 15, 0, 2, 18, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Slashing)), "", 4),
    Scizore(Proficiency.MartialWeapon, WeaponCategory.OneHandedMelee, 20, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "", 3),
    SwordCane(Proficiency.MartialWeapon, WeaponCategory.OneHandedMelee, 45, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "", 4),
    Terbutje(Proficiency.MartialWeapon, WeaponCategory.OneHandedMelee, 5, 0, 2, 19, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Slashing)), "", 2),
    TerbutjeSteel(Proficiency.MartialWeapon, WeaponCategory.OneHandedMelee, 20, 0, 2, 19, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Slashing)), "", 4),
    Trident(Proficiency.MartialWeapon, WeaponCategory.OneHandedMelee, 15, 0, 2, 20, 10, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "", 4),
    Warhammer(Proficiency.MartialWeapon, WeaponCategory.OneHandedMelee, 12, 0, 3, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Bludgeoning)), "", 5),

    /*****************************************************
     ********* Martial Two-Handed Melee Weapons **********
     *****************************************************/
    Bardiche(Proficiency.MartialWeapon, WeaponCategory.TwoHandedMelee, 13, 0, 2, 19, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Slashing)), "", 14),
    BecDeCorbin(Proficiency.MartialWeapon, WeaponCategory.TwoHandedMelee, 15, 0, 3, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Bludgeoning, DamageType.Piercing)), "", 12),
    Bill(Proficiency.MartialWeapon, WeaponCategory.TwoHandedMelee, 11, 0, 3, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Slashing)), "", 11),
    EarthBreaker(Proficiency.MartialWeapon, WeaponCategory.TwoHandedMelee, 40, 0, 3, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Bludgeoning)), "", 14),
    Falchion(Proficiency.MartialWeapon, WeaponCategory.TwoHandedMelee, 75, 0, 2, 18, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Slashing)), "", 8),
    FlailHeavy(Proficiency.MartialWeapon, WeaponCategory.TwoHandedMelee, 15, 0, 2, 19, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Bludgeoning)), "", 10),
    Glaive(Proficiency.MartialWeapon, WeaponCategory.TwoHandedMelee, 8, 0, 3, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Slashing)), "", 10),
    GlaiveGuisarme(Proficiency.MartialWeapon, WeaponCategory.TwoHandedMelee, 12, 0, 3, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Slashing)), "", 10),
    Greataxe(Proficiency.MartialWeapon, WeaponCategory.TwoHandedMelee, 20, 0, 3, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Slashing)), "", 12),
    Greatclub(Proficiency.MartialWeapon, WeaponCategory.TwoHandedMelee, 5, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Bludgeoning)), "", 8),
    Greatsword(Proficiency.MartialWeapon, WeaponCategory.TwoHandedMelee, 50, 0, 2, 19, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Slashing)), "", 8),
    Guisarme(Proficiency.MartialWeapon, WeaponCategory.TwoHandedMelee, 9, 0, 3, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Slashing)), "", 12),
    Halberd(Proficiency.MartialWeapon, WeaponCategory.TwoHandedMelee, 10, 0, 3, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing, DamageType.Slashing)), "", 12),
    HammerLucerne(Proficiency.MartialWeapon, WeaponCategory.TwoHandedMelee, 15, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Bludgeoning, DamageType.Piercing)), "", 12),
    HorseChopper(Proficiency.MartialWeapon, WeaponCategory.TwoHandedMelee, 10, 0, 3, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing, DamageType.Slashing)), "", 12),
    Lance(Proficiency.MartialWeapon, WeaponCategory.TwoHandedMelee, 10, 0, 3, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "", 10),
    OgreHook(Proficiency.MartialWeapon, WeaponCategory.TwoHandedMelee, 24, 0, 3, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "", 10),
    Pickaxe(Proficiency.MartialWeapon, WeaponCategory.TwoHandedMelee, 14, 0, 4, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "", 12),
    Planson(Proficiency.MartialWeapon, WeaponCategory.TwoHandedMelee, 10, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Bludgeoning, DamageType.Piercing)), "", 10),
    Ranseur(Proficiency.MartialWeapon, WeaponCategory.TwoHandedMelee, 10, 0, 3, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "", 12),
    Scythe(Proficiency.MartialWeapon, WeaponCategory.TwoHandedMelee, 18, 0, 4, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing, DamageType.Slashing)), "", 10),
    SpearSyringe(Proficiency.MartialWeapon, WeaponCategory.TwoHandedMelee, 100, 0, 3, 20, 20, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "", 6),

    /*****************************************************
     ************** Martial Ranged Weapons ***************
     *****************************************************/
    Ammentum(Proficiency.MartialWeapon, WeaponCategory.Ranged, 0, 0, 2, 20, 50, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "", 1),
    Chakram(Proficiency.MartialWeapon, WeaponCategory.Ranged, 1, 0, 2, 20, 30, Collections.unmodifiableList(Arrays.asList(DamageType.Slashing)), "", 1),
    DartJolting(Proficiency.MartialWeapon, WeaponCategory.Ranged, 100, 0, 2, 20, 20, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "", 1),
    HungaMunga(Proficiency.MartialWeapon, WeaponCategory.Ranged, 4, 0, 2, 20, 15, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "", 3),
    Hurlbat(Proficiency.MartialWeapon, WeaponCategory.Ranged, 8, 0, 3, 20, 10, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing, DamageType.Slashing)), "", 2),
    Longbow(Proficiency.MartialWeapon, WeaponCategory.Ranged, 75, 0, 3, 20, 100, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "", 3),
    LongbowComposite(Proficiency.MartialWeapon, WeaponCategory.Ranged, 100, 0, 3, 20, 110, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "", 3),
    Pilum(Proficiency.MartialWeapon, WeaponCategory.Ranged, 5, 0, 2, 20, 20, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "", 4),
    Shortbow(Proficiency.MartialWeapon, WeaponCategory.Ranged, 30, 0, 3, 20, 60, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "", 2),
    ShortbowComposite(Proficiency.MartialWeapon, WeaponCategory.Ranged, 75, 0, 3, 20, 70, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "", 2),
    SpearSling(Proficiency.MartialWeapon, WeaponCategory.Ranged, 50, 0, 3, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "", 2),

    /*****************************************************
     **************** Martial Ammunition *****************
     *****************************************************/

    /*
     * TODO Here's a template weaponname(Proficiency.MartialWeapon, WeaponCategory.Ranged, cost, 0,
     * mult, crit, range, Collections.unmodifiableList(Arrays.asList(DamageType)), "", weight),
     */

    /*****************************************************
     ************ Exotic Light Melee Weapons *************
     *****************************************************/
    Aklys(Proficiency.ExoticWeapon, WeaponCategory.LightMelee, 5, 0, 2, 20, 20, Collections.unmodifiableList(Arrays.asList(DamageType.Bludgeoning)), "", 2),
    AxeKnuckle(Proficiency.ExoticWeapon, WeaponCategory.LightMelee, 9, 0, 3, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Slashing)), "", 2),
    BarbazuBeard(Proficiency.ExoticWeapon, WeaponCategory.LightMelee, 25, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Slashing)), "", 5),
    // TODO this should be fire not bludgeoning
    BattlePoi(Proficiency.ExoticWeapon, WeaponCategory.LightMelee, 5, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Bludgeoning)), "", 2),
    DaggerSwordbreaker(Proficiency.ExoticWeapon, WeaponCategory.LightMelee, 10, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Slashing)), "", 3),
    FlyingTalon(Proficiency.ExoticWeapon, WeaponCategory.LightMelee, 15, 0, 2, 20, 10, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "", 5),
    GnomePincher(Proficiency.ExoticWeapon, WeaponCategory.LightMelee, 10, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Bludgeoning)), "", 2),
    HalflingRopeshot(Proficiency.ExoticWeapon, WeaponCategory.LightMelee, 1, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Bludgeoning)), "", 1),
    DwarvenBoulderHelmet(Proficiency.ExoticWeapon, WeaponCategory.LightMelee, 20, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Bludgeoning)), "", 10),
    Kama(Proficiency.ExoticWeapon, WeaponCategory.LightMelee, 2, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Slashing)), "", 2),
    KatarTriBladed(Proficiency.ExoticWeapon, WeaponCategory.LightMelee, 6, 0, 4, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "", 2),
    KnifeBufferfly(Proficiency.ExoticWeapon, WeaponCategory.LightMelee, 5, 0, 2, 19, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Slashing)), "", 1),
    KnifeDeerHorn(Proficiency.ExoticWeapon, WeaponCategory.LightMelee, 10, 0, 3, 20, 20, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "", 3),
    DwarvenMaulaxe(Proficiency.ExoticWeapon, WeaponCategory.LightMelee, 25, 0, 3, 20, 10, Collections.unmodifiableList(Arrays.asList(DamageType.Bludgeoning, DamageType.Slashing)), "", 5),
    Nunchaku(Proficiency.ExoticWeapon, WeaponCategory.LightMelee, 2, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Bludgeoning)), "", 2),
    Quadrens(Proficiency.ExoticWeapon, WeaponCategory.LightMelee, 8, 0, 2, 19, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "", 2),
    RopeGauntlet(Proficiency.ExoticWeapon, WeaponCategory.LightMelee, 1, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Bludgeoning, DamageType.Slashing)), "", 2),
    Sai(Proficiency.ExoticWeapon, WeaponCategory.LightMelee, 1, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Bludgeoning)), "", 1),
    Siangham(Proficiency.ExoticWeapon, WeaponCategory.LightMelee, 3, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "", 1),
    Sica(Proficiency.ExoticWeapon, WeaponCategory.LightMelee, 10, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Slashing)), "", 2),
    ThornBracer(Proficiency.ExoticWeapon, WeaponCategory.LightMelee, 30, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Piercing)), "", 3),
    WhipScorpion(Proficiency.ExoticWeapon, WeaponCategory.LightMelee, 5, 0, 2, 20, 0, Collections.unmodifiableList(Arrays.asList(DamageType.Slashing)), "", 3);

    private Proficiency weaponProficiency;
    private WeaponCategory weaponCategory;
    private int cost;
    private int damageProgressionIndex;
    private int critMultiplier;
    private int critRange;
    private int range;
    private List<DamageType> damageTypes;
    private String description;
    private int weight;

    private ManufacturedWeaponName(Proficiency weaponProficiency, WeaponCategory weaponCategory, int cost, int damageProgressionIndex, int critMultiplier, int critRange, int range, List<DamageType> damageTypes, String description, int weight)
    {
        this.weaponProficiency = weaponProficiency;
        this.weaponCategory = weaponCategory;
        this.cost = cost;
        this.damageProgressionIndex = damageProgressionIndex;
        this.critMultiplier = critMultiplier;
        this.critRange = critRange;
        this.range = range;
        this.damageTypes = damageTypes;
        this.weight = weight;
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

    public EquipmentSlotType getEquipmentSlotType()
    {
        switch (weaponCategory)
        {
            case Ammunition:
                return EquipmentSlotType.Slotless;
            case Ranged:
            case TwoHandedMelee:
                return EquipmentSlotType.TwoHands;
            case LightMelee:
            case OneHandedMelee:
            case Unarmed:
            default:
                return EquipmentSlotType.MainHand;
        }
    }

    public int getWeight()
    {
        return weight;
    }
}
