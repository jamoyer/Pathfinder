package pathfinder.realWorldObject.item.equipment.armor;

import pathfinder.bonusTypes.BonusType;

public enum ArmorName
{
    /*****************************************************
     ******************* Light Armors ********************
     *****************************************************/
    ArmoredKilt(ArmorProficiency.Light, BonusType.Armor, 20, 1, 6, 0, 0, 0),
    Padded(ArmorProficiency.Light, BonusType.Armor, 5, 1, 8, 0, 5, 0),
    QuiltedCloth(ArmorProficiency.Light, BonusType.Armor, 100, 1, 8, 0, 10, 0),
    Leather(ArmorProficiency.Light, BonusType.Armor, 10, 2, 6, 0, 10, 0),
    RoseWoodArmor(ArmorProficiency.Light, BonusType.Armor, 50, 2, 6, 0, 10, 0),
    HideShirt(ArmorProficiency.Light, BonusType.Armor, 20, 3, 4, -1, 15, 0),
    LeafArmor(ArmorProficiency.Light, BonusType.Armor, 500, 3, 5, 0, 15, 0),
    ParadeArmor(ArmorProficiency.Light, BonusType.Armor, 25, 3, 5, -1, 15, 0),
    StuddedLeather(ArmorProficiency.Light, BonusType.Armor, 25, 3, 5, -1, 15, 0),
    Wooden(ArmorProficiency.Light, BonusType.Armor, 20, 3, 3, -1, 15, 0),
    ChainShirt(ArmorProficiency.Light, BonusType.Armor, 100, 4, 4, -2, 20, 0);
    
    
    private ArmorProficiency armorProficiency;
    private BonusType bonusType;
    private int cost;
    private int armorValue;
    private int maxDexBonus;
    private int armorCheckPenalty;
    private int arcaneSpellFailureChance;
    private int speedPenalty;
    
    private ArmorName(ArmorProficiency armorProficiency, BonusType bonusType, int cost, int armorValue, int maxDexBonus,
            int armorCheckPenalty, int arcaneSpellFailureChance,
            int speedPenalty)
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

    public int getSpeedPenalty()
    {
        return this.speedPenalty;
    }
}
