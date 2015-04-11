package pathfinder.realWorldObject.item.equipment.armor;

import pathfinder.bonusTypes.BonusType;

public enum ArmorName
{
    ArmoredKilt(ArmorProficiency.Light, BonusType.Armor, 20, 1, 6, 0, 0.0, 0);
    
    private ArmorProficiency armorProficiency;
    private BonusType bonusType;
    private int cost;
    private int armorValue;
    private int maxDexBonus;
    private int armorCheckPenalty;
    private double arcaneSpellFailureChance;
    private int speedPenalty;
    
    private ArmorName(ArmorProficiency armorProficiency, BonusType bonusType, int cost, int armorValue, int maxDexBonus,
            int armorCheckPenalty, double arcaneSpellFailureChance,
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

    public double getArcaneSpellFailureChance()
    {
        return this.arcaneSpellFailureChance;
    }

    public int getSpeedPenalty()
    {
        return this.speedPenalty;
    }
}
