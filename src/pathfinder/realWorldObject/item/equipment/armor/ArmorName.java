package pathfinder.realWorldObject.item.equipment.armor;

import pathfinder.characters.buffs.BonusType;
import pathfinder.realWorldObject.creature.EquipmentSlotType;
import pathfinder.realWorldObject.item.equipment.Proficiency;

/*
 * TODO add weight to this table
 */

public enum ArmorName
{
    /*****************************************************
     ******************* Light Armors ********************
     *****************************************************/
    ArmoredKilt(Proficiency.LightArmor, BonusType.Armor, 20, 1, 6, 0, 0, ArmorSpeedPenalty.None, 10),
    Padded(Proficiency.LightArmor, BonusType.Armor, 5, 1, 8, 0, 5, ArmorSpeedPenalty.None, 10),
    QuiltedCloth(Proficiency.LightArmor, BonusType.Armor, 100, 1, 8, 0, 10, ArmorSpeedPenalty.None, 15),
    Leather(Proficiency.LightArmor, BonusType.Armor, 10, 2, 6, 0, 10, ArmorSpeedPenalty.None, 15),
    RoseWoodArmor(Proficiency.LightArmor, BonusType.Armor, 50, 2, 6, 0, 10, ArmorSpeedPenalty.None, 15),
    HideShirt(Proficiency.LightArmor, BonusType.Armor, 20, 3, 4, -1, 15, ArmorSpeedPenalty.None, 18),
    LeafArmor(Proficiency.LightArmor, BonusType.Armor, 500, 3, 5, 0, 15, ArmorSpeedPenalty.None, 20),
    ParadeArmor(Proficiency.LightArmor, BonusType.Armor, 25, 3, 5, -1, 15, ArmorSpeedPenalty.None, 20),
    StuddedLeather(Proficiency.LightArmor, BonusType.Armor, 25, 3, 5, -1, 15, ArmorSpeedPenalty.None, 20),
    Wooden(Proficiency.LightArmor, BonusType.Armor, 20, 3, 3, -1, 15, ArmorSpeedPenalty.None, 25),
    ChainShirt(Proficiency.LightArmor, BonusType.Armor, 100, 4, 4, -2, 20, ArmorSpeedPenalty.None, 25),

    /*****************************************************
     ******************* Medium Armors *******************
     *****************************************************/
    ArmoredCoat(Proficiency.MediumArmor, BonusType.Armor, 50, 4, 3, -2, 20, ArmorSpeedPenalty.Regular, 20),
    Hide(Proficiency.MediumArmor, BonusType.Armor, 15, 4, 4, -3, 20, ArmorSpeedPenalty.Regular, 25),
    ScaleMail(Proficiency.MediumArmor, BonusType.Armor, 50, 5, 3, -4, 25, ArmorSpeedPenalty.Regular, 30),
    Chainmail(Proficiency.MediumArmor, BonusType.Armor, 150, 6, 2, -5, 30, ArmorSpeedPenalty.Regular, 40),
    Breastplate(Proficiency.MediumArmor, BonusType.Armor, 200, 6, 3, -4, 25, ArmorSpeedPenalty.Regular, 30),

    /*****************************************************
     ******************* Heavy Armors ********************
     *****************************************************/
    Splintmail(Proficiency.HeavyArmor, BonusType.Armor, 200, 7, 0, -7, 40, ArmorSpeedPenalty.Regular, 45),
    Bandedmail(Proficiency.HeavyArmor, BonusType.Armor, 250, 7, 1, -6, 35, ArmorSpeedPenalty.Regular, 35),
    FieldPlate(Proficiency.HeavyArmor, BonusType.Armor, 1200, 7, 1, -5, 35, ArmorSpeedPenalty.Regular, 50),
    HalfPlate(Proficiency.HeavyArmor, BonusType.Armor, 600, 8, 0, -7, 40, ArmorSpeedPenalty.Regular, 55),
    FullPlate(Proficiency.HeavyArmor, BonusType.Armor, 1500, 9, 1, -6, 35, ArmorSpeedPenalty.Regular, 50),
    HellknightPlate(Proficiency.HeavyArmor, BonusType.Armor, 2000, 9, 1, -5, 35, ArmorSpeedPenalty.Regular, 50),
    StonePlate(Proficiency.HeavyArmor, BonusType.Armor, 1800, 9, 1, -6, 35, ArmorSpeedPenalty.Heavy, 75),

    /*****************************************************
     ******************* Shields *************************
     *****************************************************/
    Buckler(Proficiency.Shield, BonusType.Shield, 5, 1, Armor.UNLIMITED_DEX_BONUS, -1, 5, ArmorSpeedPenalty.None, 5),
    Klar(Proficiency.Shield, BonusType.Shield, 12, 1, Armor.UNLIMITED_DEX_BONUS, -1, 5, ArmorSpeedPenalty.None, 6),
    MaduLeather(Proficiency.Shield, BonusType.Shield, 30, 1, Armor.UNLIMITED_DEX_BONUS, -2, 5, ArmorSpeedPenalty.None, 5),
    MaduSteel(Proficiency.Shield, BonusType.Shield, 40, 1, Armor.UNLIMITED_DEX_BONUS, -2, 5, ArmorSpeedPenalty.None, 6),
    ShieldLightWooden(Proficiency.Shield, BonusType.Shield, 3, 1, Armor.UNLIMITED_DEX_BONUS, -1, 5, ArmorSpeedPenalty.None, 5),
    ShieldLightSteel(Proficiency.Shield, BonusType.Shield, 9, 1, Armor.UNLIMITED_DEX_BONUS, -1, 5, ArmorSpeedPenalty.None, 6),
    ShieldHeavyWooden(Proficiency.Shield, BonusType.Shield, 7, 2, Armor.UNLIMITED_DEX_BONUS, -2, 15, ArmorSpeedPenalty.None, 10),
    ShieldHeavySteel(Proficiency.Shield, BonusType.Shield, 20, 2, Armor.UNLIMITED_DEX_BONUS, -2, 15, ArmorSpeedPenalty.None, 15),
    ShieldTower(Proficiency.TowerShield, BonusType.Shield, 30, 4, 2, -10, 50, ArmorSpeedPenalty.None, 45);

    private Proficiency armorProficiency;
    private BonusType bonusType;
    private int cost;
    private int armorValue;
    private int maxDexBonus;
    private int armorCheckPenalty;
    private int arcaneSpellFailureChance;
    private ArmorSpeedPenalty speedPenalty;
    private int weight;

    private ArmorName(Proficiency armorProficiency, BonusType bonusType, int cost, int armorValue, int maxDexBonus, int armorCheckPenalty, int arcaneSpellFailureChance,
            ArmorSpeedPenalty speedPenalty, int weight)
    {
        this.armorProficiency = armorProficiency;
        this.bonusType = bonusType;
        this.cost = cost;
        this.armorValue = armorValue;
        this.maxDexBonus = maxDexBonus;
        this.armorCheckPenalty = armorCheckPenalty;
        this.arcaneSpellFailureChance = arcaneSpellFailureChance;
        this.speedPenalty = speedPenalty;
        this.weight = weight;
    }

    public Proficiency getArmorProficiency()
    {
        return this.armorProficiency;
    }

    public BonusType getBonusType()
    {
        return this.bonusType;
    }

    public int getCost()
    {
        return this.cost;
    }

    public int getArmorValue()
    {
        return this.armorValue;
    }

    public int getMaxDexBonus()
    {
        return this.maxDexBonus;
    }

    public int getArmorCheckPenalty()
    {
        return this.armorCheckPenalty;
    }

    public int getArcaneSpellFailureChance()
    {
        return this.arcaneSpellFailureChance;
    }

    public ArmorSpeedPenalty getSpeedPenalty()
    {
        return this.speedPenalty;
    }

    public int getWeight()
    {
        return weight;
    }

    public EquipmentSlotType getEquipmentSlotType()
    {
        switch (bonusType)
        {
            case Shield:
                return EquipmentSlotType.OffHand;
            case Armor:
            default:
                return EquipmentSlotType.Armor;
        }
    }
}
