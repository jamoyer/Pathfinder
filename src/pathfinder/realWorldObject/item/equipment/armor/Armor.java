package pathfinder.realWorldObject.item.equipment.armor;

import pathfinder.bonusTypes.BonusType;
import pathfinder.realWorldObject.SizeCategory;
import pathfinder.realWorldObject.creature.EquipableItem;
import pathfinder.realWorldObject.creature.EquipmentSlotType;

public class Armor extends EquipableItem
{
    private ArmorProficiency armorProficiency;
    private BonusType bonusType;
    private int cost;
    private int armorValue;
    private int maxDexBonus;
    private int armorCheckPenalty;
    private double arcaneSpellFailureChance;
    private ArmorSpeedPenalty speedPenalty;

    public Armor(EquipmentSlotType slot, SizeCategory size,
            ArmorProficiency armorProficiency, BonusType bonusType, int cost,
            int armorValue, int maxDexBonus, int armorCheckPenalty,
            double arcaneSpellFailureChance, ArmorSpeedPenalty speedPenalty)
    {
        super(slot, size);
        this.armorProficiency = armorProficiency;
        this.bonusType = bonusType;
        this.armorValue = armorValue;
        this.maxDexBonus = maxDexBonus;
        this.armorCheckPenalty = armorCheckPenalty;
        this.arcaneSpellFailureChance = arcaneSpellFailureChance;
        this.speedPenalty = speedPenalty;
    }

    public Armor(EquipmentSlotType slot, SizeCategory size, ArmorName armorName)
    {
        super(slot, size);
        this.armorProficiency = armorName.getArmorProficiency();
        this.bonusType = armorName.getBonusType();
        this.cost = armorName.getCost();
        this.armorValue = armorName.getArmorValue();
        this.maxDexBonus = armorName.getMaxDexBonus();
        this.armorCheckPenalty = armorName.getArmorCheckPenalty();
        this.arcaneSpellFailureChance = armorName.getArcaneSpellFailureChance();
        this.speedPenalty = armorName.getSpeedPenalty();
    }

    public ArmorProficiency getArmorProficiency()
    {
        return this.armorProficiency;
    }

    public BonusType getBonusType()
    {
        return this.bonusType;
    }

    public int getArmorValue()
    {
        return this.armorValue;
    }

    public int getCost()
    {
        return this.cost;
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

    public ArmorSpeedPenalty getSpeedPenalty()
    {
        return this.speedPenalty;
    }
}
