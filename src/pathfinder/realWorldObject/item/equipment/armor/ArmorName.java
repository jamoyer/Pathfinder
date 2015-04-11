package pathfinder.realWorldObject.item.equipment.armor;

import pathfinder.characters.buffs.BonusType;
import pathfinder.realWorldObject.item.equipment.Proficiency;

public enum ArmorName
{
    /*****************************************************
     ******************* Light Armors ********************
     *****************************************************/
    ArmoredKilt(Proficiency.LightArmor, BonusType.Armor, 20, 1, 6, 0, 0, ArmorSpeedPenalty.None),
    Padded(Proficiency.LightArmor, BonusType.Armor, 5, 1, 8, 0, 5, ArmorSpeedPenalty.None),
    QuiltedCloth(Proficiency.LightArmor, BonusType.Armor, 100, 1, 8, 0, 10, ArmorSpeedPenalty.None),
    Leather(Proficiency.LightArmor, BonusType.Armor, 10, 2, 6, 0, 10, ArmorSpeedPenalty.None),
    RoseWoodArmor(Proficiency.LightArmor, BonusType.Armor, 50, 2, 6, 0, 10, ArmorSpeedPenalty.None),
    HideShirt(Proficiency.LightArmor, BonusType.Armor, 20, 3, 4, -1, 15, ArmorSpeedPenalty.None),
    LeafArmor(Proficiency.LightArmor, BonusType.Armor, 500, 3, 5, 0, 15, ArmorSpeedPenalty.None),
    ParadeArmor(Proficiency.LightArmor, BonusType.Armor, 25, 3, 5, -1, 15, ArmorSpeedPenalty.None),
    StuddedLeather(Proficiency.LightArmor, BonusType.Armor, 25, 3, 5, -1, 15, ArmorSpeedPenalty.None),
    Wooden(Proficiency.LightArmor, BonusType.Armor, 20, 3, 3, -1, 15, ArmorSpeedPenalty.None),
    ChainShirt(Proficiency.LightArmor, BonusType.Armor, 100, 4, 4, -2, 20, ArmorSpeedPenalty.None),

    /*****************************************************
     ******************* Medium Armors *******************
     *****************************************************/
    ArmoredCoat(Proficiency.MediumArmor, BonusType.Armor, 50, 4, 3, -2, 20, ArmorSpeedPenalty.Regular),
    Hide(Proficiency.MediumArmor, BonusType.Armor, 15, 4, 4, -3, 20, ArmorSpeedPenalty.Regular),
    ScaleMail(Proficiency.MediumArmor, BonusType.Armor, 50, 5, 3, -4, 25, ArmorSpeedPenalty.Regular),
    Chainmail(Proficiency.MediumArmor, BonusType.Armor, 150, 6, 2, -5, 30, ArmorSpeedPenalty.Regular),
    Breastplate(Proficiency.MediumArmor, BonusType.Armor, 200, 6, 3, -4, 25, ArmorSpeedPenalty.Regular),

    /*****************************************************
     ******************* Heavy Armors ********************
     *****************************************************/
    Splintmail(Proficiency.HeavyArmor, BonusType.Armor, 200, 7, 0, -7, 40, ArmorSpeedPenalty.Regular),
    Bandedmail(Proficiency.HeavyArmor, BonusType.Armor, 250, 7, 1, -6, 35, ArmorSpeedPenalty.Regular),
    FieldPlate(Proficiency.HeavyArmor, BonusType.Armor, 1200, 7, 1, -5, 35, ArmorSpeedPenalty.Regular),
    HalfPlate(Proficiency.HeavyArmor, BonusType.Armor, 600, 8, 0, -7, 40, ArmorSpeedPenalty.Regular),
    FullPlate(Proficiency.HeavyArmor, BonusType.Armor, 1500, 9, 1, -6, 35, ArmorSpeedPenalty.Regular),
    HellknightPlate(Proficiency.HeavyArmor, BonusType.Armor, 2000, 9, 1, -5, 35, ArmorSpeedPenalty.Regular),
    StonePlate(Proficiency.HeavyArmor, BonusType.Armor, 1800, 9, 1, -6, 35, ArmorSpeedPenalty.Heavy),

    /*****************************************************
     ******************* Shields *************************
     *****************************************************/
    Buckler(Proficiency.Shield, BonusType.Shield, 5, 1, 9999, -1, 5, ArmorSpeedPenalty.None),
    Klar(Proficiency.Shield, BonusType.Shield, 12, 1, 9999, -1, 5, ArmorSpeedPenalty.None),
    MaduLeather(Proficiency.Shield, BonusType.Shield, 30, 1, 9999, -2, 5, ArmorSpeedPenalty.None),
    MaduSteel(Proficiency.Shield, BonusType.Shield, 40, 1, 9999, -2, 5, ArmorSpeedPenalty.None),
    ShieldLightWooden(Proficiency.Shield, BonusType.Shield, 3, 1, 9999, -1, 5, ArmorSpeedPenalty.None),
    ShieldLightSteel(Proficiency.Shield, BonusType.Shield, 9, 1, 9999, -1, 5, ArmorSpeedPenalty.None),
    ShieldHeavyWooden(Proficiency.Shield, BonusType.Shield, 7, 2, 9999, -2, 15, ArmorSpeedPenalty.None),
    ShieldHeavySteel(Proficiency.Shield, BonusType.Shield, 20, 2, 9999, -2, 15, ArmorSpeedPenalty.None),
    ShieldTower(Proficiency.TowerShield, BonusType.Shield, 30, 4, 2, -10, 50, ArmorSpeedPenalty.None);

    private Proficiency armorProficiency;
    private BonusType bonusType;
    private int cost;
    private int armorValue;
    private int maxDexBonus;
    private int armorCheckPenalty;
    private int arcaneSpellFailureChance;
    private ArmorSpeedPenalty speedPenalty;

    private ArmorName(Proficiency armorProficiency, BonusType bonusType, int cost, int armorValue,
            int maxDexBonus, int armorCheckPenalty, int arcaneSpellFailureChance, ArmorSpeedPenalty speedPenalty)
    {
        this.armorProficiency = armorProficiency;
        this.bonusType = bonusType;
        this.cost = cost;
        this.armorValue = armorValue;
        this.maxDexBonus = maxDexBonus;
        this.armorCheckPenalty = armorCheckPenalty;
        this.arcaneSpellFailureChance = arcaneSpellFailureChance;
        this.speedPenalty = speedPenalty;
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
}
