package pathfinder.realWorldObject.item.equipment.armor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import pathfinder.characters.buffs.BonusTarget;
import pathfinder.characters.buffs.BonusType;
import pathfinder.characters.buffs.CreatureBuff;
import pathfinder.realWorldObject.SizeCategory;
import pathfinder.realWorldObject.creature.DexLimiting;
import pathfinder.realWorldObject.creature.EquipmentSlotType;
import pathfinder.realWorldObject.creature.EquippableItem;
import pathfinder.realWorldObject.item.equipment.Proficiency;

public class Armor extends EquippableItem implements DexLimiting
{
    private final Proficiency armorProficiency;
    private final BonusType bonusType;
    private final int armorValue;
    private final int maxDexBonus;
    private final int armorCheckPenalty;
    private final double arcaneSpellFailureChance;
    private final ArmorSpeedPenalty speedPenalty;
    private final String commonName;

    public static final int UNLIMITED_DEX_BONUS = Integer.MAX_VALUE;

    public Armor(EquipmentSlotType slot, SizeCategory size, Proficiency armorProficiency, BonusType bonusType, int cost, int armorValue, int maxDexBonus, int armorCheckPenalty,
            double arcaneSpellFailureChance, ArmorSpeedPenalty speedPenalty, int weight)
    {
        super(slot, size, cost, Collections.unmodifiableList(Arrays.asList(new CreatureBuff("", "", 0, true, 0, BonusTarget.ArmorClass, bonusType, armorValue), new CreatureBuff(
                "", "", 0, true, 0, BonusTarget.FlatFooted, bonusType, armorValue))));
        this.armorProficiency = armorProficiency;
        this.bonusType = bonusType;
        this.armorValue = armorValue;
        this.maxDexBonus = maxDexBonus;
        this.armorCheckPenalty = armorCheckPenalty;
        this.arcaneSpellFailureChance = arcaneSpellFailureChance;
        this.speedPenalty = speedPenalty;
        super.setWeight(weight);
        this.commonName = null;
    }

    public Armor(SizeCategory size, ArmorName armorName)
    {
        super(armorName.getEquipmentSlotType(), size, armorName.getCost(), Collections.unmodifiableList(Arrays.asList(new CreatureBuff(armorName.name(), "", 0, true, 0,
                BonusTarget.ArmorClass, BonusType.Armor, armorName.getArmorValue()), new CreatureBuff(armorName.name(), "", 0, true, 0, BonusTarget.FlatFooted, BonusType.Armor,
                armorName.getArmorValue()))));
        this.armorProficiency = armorName.getArmorProficiency();
        this.bonusType = armorName.getBonusType();
        this.armorValue = armorName.getArmorValue();
        this.maxDexBonus = armorName.getMaxDexBonus();
        this.armorCheckPenalty = armorName.getArmorCheckPenalty();
        this.arcaneSpellFailureChance = armorName.getArcaneSpellFailureChance();
        this.speedPenalty = armorName.getSpeedPenalty();
        super.setWeight(armorName.getWeight());
        this.commonName = armorName.name();
    }

    @Override
    public List<String> getProperties()
    {
        final List<String> properties = super.getProperties();
        properties.add("Common Name: " + commonName);
        properties.add("Proficiency: " + armorProficiency.name());
        properties.add("Bonus Type: " + bonusType.name());
        properties.add("AC Bonus: " + armorValue);
        properties.add("Max Dex Bonus: " + maxDexBonus);
        properties.add("Armor Check Penalty: " + armorCheckPenalty);
        properties.add("Arcane Spell Failure Chance: " + arcaneSpellFailureChance);
        properties.add("Armor Speed Penalty: " + speedPenalty.name());
        return properties;
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

    public boolean isArmor()
    {
        return Armor.isArmor(armorProficiency);
    }

    public boolean isShield()
    {
        return Armor.isShield(armorProficiency);
    }

    public static boolean isArmor(Proficiency prof)
    {
        return prof == Proficiency.LightArmor || prof == Proficiency.MediumArmor || prof == Proficiency.HeavyArmor;
    }

    public static boolean isShield(Proficiency prof)
    {
        return prof == Proficiency.Shield || prof == Proficiency.TowerShield;
    }
}
