package pathfinder.realWorldObject.item.equipment.armor;

import pathfinder.characters.buffs.BonusType;

public enum ArmorName
{
    /*****************************************************
     ******************* Light Armors ********************
     *****************************************************/
    ArmoredKilt(ArmorProficiency.Light, BonusType.Armor, 20, 1, 6, 0, 0, ArmorSpeedPenalty.None),
    Padded(ArmorProficiency.Light, BonusType.Armor, 5, 1, 8, 0, 5, ArmorSpeedPenalty.None),
    QuiltedCloth(ArmorProficiency.Light, BonusType.Armor, 100, 1, 8, 0, 10, ArmorSpeedPenalty.None),
    Leather(ArmorProficiency.Light, BonusType.Armor, 10, 2, 6, 0, 10, ArmorSpeedPenalty.None),
    RoseWoodArmor(ArmorProficiency.Light, BonusType.Armor, 50, 2, 6, 0, 10, ArmorSpeedPenalty.None),
    HideShirt(ArmorProficiency.Light, BonusType.Armor, 20, 3, 4, -1, 15, ArmorSpeedPenalty.None),
    LeafArmor(ArmorProficiency.Light, BonusType.Armor, 500, 3, 5, 0, 15, ArmorSpeedPenalty.None),
    ParadeArmor(ArmorProficiency.Light, BonusType.Armor, 25, 3, 5, -1, 15, ArmorSpeedPenalty.None),
    StuddedLeather(ArmorProficiency.Light, BonusType.Armor, 25, 3, 5, -1, 15, ArmorSpeedPenalty.None),
    Wooden(ArmorProficiency.Light, BonusType.Armor, 20, 3, 3, -1, 15, ArmorSpeedPenalty.None),
    ChainShirt(ArmorProficiency.Light, BonusType.Armor, 100, 4, 4, -2, 20, ArmorSpeedPenalty.None),
    
    /*****************************************************
     ******************* Medium Armors *******************
     *****************************************************/
    ArmoredCoat(ArmorProficiency.Medium, BonusType.Armor, 50, 4, 3, -2, 20, ArmorSpeedPenalty.Regular),
    Hide(ArmorProficiency.Medium, BonusType.Armor, 15, 4, 4, -3, 20, ArmorSpeedPenalty.Regular),
    ScaleMail(ArmorProficiency.Medium, BonusType.Armor, 50, 5, 3, -4, 25, ArmorSpeedPenalty.Regular),
    Chainmail(ArmorProficiency.Medium, BonusType.Armor, 150, 6, 2, -5, 30, ArmorSpeedPenalty.Regular),
    Breastplate(ArmorProficiency.Medium, BonusType.Armor, 200, 6, 3, -4, 25, ArmorSpeedPenalty.Regular),
    
    /*****************************************************
     ******************* Heavy Armors ********************
     *****************************************************/
    Splintmail(ArmorProficiency.Heavy, BonusType.Armor, 200, 7, 0, -7, 40, ArmorSpeedPenalty.Regular),
    Bandedmail(ArmorProficiency.Heavy, BonusType.Armor, 250, 7, 1, -6, 35, ArmorSpeedPenalty.Regular),
    FieldPlate(ArmorProficiency.Heavy, BonusType.Armor, 1200, 7, 1, -5, 35, ArmorSpeedPenalty.Regular),
    HalfPlate(ArmorProficiency.Heavy, BonusType.Armor, 600, 8, 0, -7, 40, ArmorSpeedPenalty.Regular),
    FullPlate(ArmorProficiency.Heavy, BonusType.Armor, 1500, 9, 1, -6, 35, ArmorSpeedPenalty.Regular),
    HellknightPlate(ArmorProficiency.Heavy, BonusType.Armor, 2000, 9, 1, -5, 35, ArmorSpeedPenalty.Regular),
    StonePlate(ArmorProficiency.Heavy, BonusType.Armor, 1800, 9, 1, -6, 35, ArmorSpeedPenalty.Heavy),
    
    /*****************************************************
     ******************* Shields *************************
     *****************************************************/
    Buckler(ArmorProficiency.Shield, BonusType.Shield, 5, 1, 9999, -1, 5, ArmorSpeedPenalty.None),
    Klar(ArmorProficiency.Shield, BonusType.Shield, 12, 1, 9999, -1, 5, ArmorSpeedPenalty.None),
    MaduLeather(ArmorProficiency.Shield, BonusType.Shield, 30, 1, 9999, -2, 5, ArmorSpeedPenalty.None),
    MaduSteel(ArmorProficiency.Shield, BonusType.Shield, 40, 1, 9999, -2, 5, ArmorSpeedPenalty.None),
    ShieldLightWooden(ArmorProficiency.Shield, BonusType.Shield, 3, 1, 9999, -1, 5, ArmorSpeedPenalty.None),
    ShieldLightSteel(ArmorProficiency.Shield, BonusType.Shield, 9, 1, 9999, -1, 5, ArmorSpeedPenalty.None),
    ShieldHeavyWooden(ArmorProficiency.Shield, BonusType.Shield, 7, 2, 9999, -2, 15, ArmorSpeedPenalty.None),
    ShieldHeavySteel(ArmorProficiency.Shield, BonusType.Shield, 20, 2, 9999, -2, 15, ArmorSpeedPenalty.None),
    ShieldTower(ArmorProficiency.TowerShield, BonusType.Shield, 30, 4, 2, -10, 50, ArmorSpeedPenalty.None);
    
    private ArmorProficiency armorProficiency;
    private BonusType bonusType;
    private int cost;
    private int armorValue;
    private int maxDexBonus;
    private int armorCheckPenalty;
    private int arcaneSpellFailureChance;
    private ArmorSpeedPenalty speedPenalty;
    
    private ArmorName(ArmorProficiency armorProficiency, BonusType bonusType, int cost, int armorValue, int maxDexBonus,
            int armorCheckPenalty, int arcaneSpellFailureChance,
            ArmorSpeedPenalty speedPenalty)
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
    
    public ArmorProficiency getArmorProficiency()
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
