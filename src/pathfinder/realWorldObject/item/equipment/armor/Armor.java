package pathfinder.realWorldObject.item.equipment.armor;

import pathfinder.characters.buffs.BonusType;
import pathfinder.realWorldObject.SizeCategory;
import pathfinder.realWorldObject.creature.EquippableItem;
import pathfinder.realWorldObject.creature.EquipmentSlotType;
import pathfinder.realWorldObject.item.equipment.Proficiency;

public class Armor extends EquippableItem
{
    private final Proficiency armorProficiency;
    private final BonusType bonusType;
    private int cost;
    private final int armorValue;
    private final int maxDexBonus;
    private final int armorCheckPenalty;
    private final double arcaneSpellFailureChance;
    private final ArmorSpeedPenalty speedPenalty;

    public static final int UNLIMITED_DEX_BONUS = 9999;

    public Armor(EquipmentSlotType slot, SizeCategory size,
            Proficiency armorProficiency, BonusType bonusType, int cost,
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

    public Proficiency getArmorProficiency()
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

    @Override
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
