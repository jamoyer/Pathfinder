package pathfinder.realWorldObject.creature;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import pathfinder.characters.buffs.BonusTarget;
import pathfinder.characters.buffs.CreatureBuff;
import pathfinder.characters.classes.CharacterClass;
import pathfinder.metaObjects.DiceSet;
import pathfinder.realWorldObject.creature.creatureType.Humanoid;
import pathfinder.realWorldObject.item.equipment.SlotManager;
import pathfinder.realWorldObject.item.equipment.armor.Armor;

public class CharacterCreature extends Creature
{
    private final int totalLevel;
    private final Humanoid race;
    private final List<CharacterClass> classes;
    private final SlotManager equipment;

    public CharacterCreature(final AbilityScoreSet baseStats, final Humanoid race, final CharacterClass charClass)
    {
        this(baseStats, race, Arrays.asList(charClass));
    }

    public CharacterCreature(final AbilityScoreSet baseStats, final Humanoid race, final List<CharacterClass> classList)
    {
        super(baseStats.addScores(race.getAbilityScoreModifiers()), race);
        this.race = race;
        classes = classList;
        totalLevel = calcTotalLevel();
        equipment = new SlotManager(race.getSizeCategory());
        super.setBaseAttackBonus(calcCharacterBaseAttackBonus());

        super.setMaxDexBonus(calcCharacterMaxDexBonus());
        super.setCombatManueverDefense(calcCombatManueverDefense());
        super.setArmorClass(calcArmorClass());
        super.setTouch(calcTouch());

        super.setMaxHP(calcCharacterMaxHealthPointsRandom());
        super.setHP(calcCurrentHP());

        super.setReflex(calcCharacterReflex());
        super.setFortitude(calcCharacterFortitude());
        super.setWill(calcCharacterWill());
    }

    public int getCharacterLevel()
    {
        return totalLevel;
    }

    public SlotManager getEquipment()
    {
        return equipment;
    }

    public List<CharacterClass> getClasses()
    {
        return Collections.unmodifiableList(classes);
    }

    /*****************************************************
     *************** Calculation Functions ***************
     *****************************************************/

    private int calcTotalLevel()
    {
        int level = 0;
        for (final CharacterClass charClass : classes)
        {
            level += charClass.getLevel();
        }
        return level;
    }

    public int calcCharacterMaxHealthPointsRandom()
    {
        final int conHP = getCharacterLevel() * getEffectiveAbilityScores().getConstitutionModifier();
        final int bonusHP = getBuffManager().getBonusByTarget(BonusTarget.MaxHp);

        int hpFromClasses = 0;
        boolean isFirstClass = true;
        for (final CharacterClass charClass : classes)
        {
            final int hitDie = race.getHitDieType();
            final int level = charClass.getLevel();
            if (isFirstClass)
            {
                // if this is the first class give one full hitDie of health for first level, the
                // rest is random
                hpFromClasses += new DiceSet(hitDie, level - 1).getRolledTotal() + hitDie;
                isFirstClass = false;
            }
            else
            {
                hpFromClasses += new DiceSet(hitDie, level).getRolledTotal();
            }
        }
        return hpFromClasses + conHP + bonusHP;
    }

    public int calcCharacterBaseAttackBonus()
    {
        int bab = 0;
        // initialize level to zero and then sum the level of every class
        for (final CharacterClass charClass : classes)
        {
            bab += charClass.getBaseAttackBonusProgression().getBAB(charClass.getLevel());
        }
        return bab;
    }

    public int calcCharacterMaxDexBonus()
    {
        // calculates max dex bonus according to load and dexterity
        // does not account for armor or shield max dex
        final int baseMaxDex = super.calcMaxDexBonus();

        // get maximum allowed dex from armor
        int armorMax = Armor.UNLIMITED_DEX_BONUS;
        final EquippableItem armor = equipment.getItemBySlot(EquipmentSlotType.Armor);
        if (armor != null)
        {
            armorMax = ((Armor) armor).getMaxDexBonus();
        }

        // get maximum allowed dex from shield
        int shieldMax = Armor.UNLIMITED_DEX_BONUS;
        final EquippableItem shield = equipment.getItemBySlot(EquipmentSlotType.Shield);
        if (shield != null)
        {
            shieldMax = ((Armor) shield).getMaxDexBonus();
        }

        // maxDex will be the minimum from the armor, shield, and load.
        int maxDexPossible = baseMaxDex;
        if (maxDexPossible > armorMax)
        {
            maxDexPossible = armorMax;
        }
        else if (maxDexPossible > shieldMax)
        {
            maxDexPossible = shieldMax;
        }
        return maxDexPossible;
    }

    public int calcCharacterArmorClass()
    {
        final int sizeMod = race.getSizeCategory().getSizeModifier();
        final int acBonus = getBuffManager().getBonusByTarget(BonusTarget.ArmorClass);
        return BASE_DEFENSE + getMaxDexBonus() + sizeMod + acBonus;
    }

    public int calcCharacterTouch()
    {
        final int sizeMod = race.getSizeCategory().getSizeModifier();
        final int touchBonus = getBuffManager().getBonusByTarget(BonusTarget.Touch);
        return BASE_DEFENSE + getMaxDexBonus() + sizeMod + touchBonus;
    }

    public int calcCharacterFortitude()
    {
        final int conMod = getEffectiveAbilityScores().getConstitutionModifier();
        final int fortBonus = getBuffManager().getBonusByTarget(BonusTarget.Fortitude);

        int baseFort = 0;
        for (final CharacterClass charClass : classes)
        {
            baseFort += charClass.getSavingThrowSet().getBaseFortitude(charClass.getLevel());
        }

        return conMod + baseFort + fortBonus;
    }

    public int calcCharacterReflex()
    {
        final int dexMod = getEffectiveAbilityScores().getDexterityModifier();
        final int reflexBonus = getBuffManager().getBonusByTarget(BonusTarget.Reflex);

        int baseReflex = 0;
        for (final CharacterClass charClass : classes)
        {
            baseReflex += charClass.getSavingThrowSet().getBaseReflex(charClass.getLevel());
        }

        return dexMod + baseReflex + reflexBonus;
    }

    public int calcCharacterWill()
    {
        final int wisMod = getEffectiveAbilityScores().getWisdomModifier();
        final int willBonus = getBuffManager().getBonusByTarget(BonusTarget.Will);

        int baseWill = 0;
        for (final CharacterClass charClass : classes)
        {
            baseWill += charClass.getSavingThrowSet().getBaseWill(charClass.getLevel());
        }

        return wisMod + baseWill + willBonus;
    }

    /*****************************************************
     ****************** Action Functions *****************
     *****************************************************/

    /**
     * This method performs the same function as default addToInventory except that this method will
     * check if the equippable item is slotless and if it is then it will equip it. This is so
     * slotless items are automatically equipped and their effects are applied when they are added
     * to the inventory.
     *
     * @param item
     *            Item must be passed as an EquippableItem type or lower in the hierarchy, java will
     *            send it to the other method that this one overloads if it is typed higher in the
     *            hierarchy. In other words, java will not check to see if this is a EquippableItem
     *            instance if it is not typed as such.
     * @return true if the item is added, otherwise false.
     */
    public boolean addToInventory(final EquippableItem item)
    {
        // try to add the item to the inventory first
        if (!super.addToInventory(item))
        {
            return false;
        }

        // then see if it is slotless and equip it if it is
        if (item.getSlotType().equals(EquipmentSlotType.Slotless))
        {
            // this should have no problem adding the item since it is slotless and so we don't
            // check if it worked.
            equipItem(item);
        }

        return true;
    }

    /**
     * Attempts to equip the item. If the item cannot be equipped for some reason, such as the size
     * being incorrect or an item already existing in the slot for this item, this method will
     * return false. If it is equipped, this method will return true.
     *
     * @param item
     * @return
     */
    public boolean equipItem(final EquippableItem item)
    {
        // add the item to inventory if it isn't already
        if (!super.getInventory().contains(item))
        {
            // if we are unable to add the item to inventory then we are also unable to equip it
            if (!super.addToInventory(item))
            {
                return false;
            }
        }

        final List<CreatureBuff> buffsFromItem = equipment.addEquipment(item);
        if (buffsFromItem == null)
        {
            return false;
        }
        super.addBuff(buffsFromItem);
        return true;
    }

    /**
     * Unequips the item if it is equipped. Does not remove the item from the inventory.
     *
     * @param item
     * @return
     */
    public boolean unequipItem(final EquippableItem item)
    {
        final List<CreatureBuff> buffsFromItem = equipment.removeEquipment(item);
        if (buffsFromItem == null)
        {
            return false;
        }
        super.removeBuff(buffsFromItem);
        return true;
    }

    /**
     * Unequips an item from the given item slot. If slot is EquipmentSlotType.Slotless, this method
     * removes whatever item is returned by SlotManager.getItemBySlot for slotless.
     *
     * @param slot
     * @return
     */
    public boolean unequipItem(final EquipmentSlotType slot)
    {
        final EquippableItem item = equipment.getItemBySlot(slot);
        if (item == null)
        {
            return false;
        }
        return unequipItem(item);
    }

}
