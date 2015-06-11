package pathfinder.realWorldObject.creature;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import pathfinder.characters.buffs.BonusTarget;
import pathfinder.characters.buffs.CreatureBuff;
import pathfinder.characters.classes.CharacterClass;
import pathfinder.characters.classes.CreatureClass;
import pathfinder.realWorldObject.creature.creatureType.Humanoid;
import pathfinder.realWorldObject.item.equipment.SlotManager;

public class CharacterCreature extends Creature
{
    // this needs to be a list of level 1 classes in the order that the character leveled up in them
    // for things to work properly
    private final SlotManager equipment;

    public CharacterCreature(final AbilityScoreSet baseStats, final Humanoid race, final CharacterClass charClass)
    {
        this(baseStats, race, Arrays.asList(charClass));
    }

    public CharacterCreature(final AbilityScoreSet baseStats, final Humanoid race, final List<CharacterClass> classList)
    {
        super(baseStats.addScores(race.getAbilityScoreModifiers()), race);
        addLevels(new LinkedList<CreatureClass>(classList));
        equipment = new SlotManager(race.getSizeCategory());
        super.setBaseAttackBonus(calcBaseAttackBonus());

        super.setCombatManeuverDefense(calcCombatManueverDefense());
        super.setCombatManueverBonus(calcCombatManueverBonus());

        super.setMaxHP(calcMaxHealthPoints());
        super.setHP(calcCurrentHP());

        super.setReflex(calcReflex());
        super.setFortitude(calcFortitude());
        super.setWill(calcWill());
    }

    public SlotManager getEquipment()
    {
        return equipment;
    }

    /*****************************************************
     *************** Calculation Functions ***************
     *****************************************************/

    // TODO: calculate movement with armor for character creatures

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

        // add any buffs that come from the item to this character
        final List<CreatureBuff> buffsFromItem = equipment.addEquipment(item);
        if (buffsFromItem == null)
        {
            return false;
        }
        super.addBuff(buffsFromItem);

        // we need to check if this item limits max dex and if so, apply it
        // TODO using instanceof in this way is a bad practice we need to think of a better way
        if (item instanceof DexLimiting)
        {
            getBuffManager().addDexLimiting((DexLimiting) item);
            calcBasedOnTargetChange(BonusTarget.MaxDexBonus);
        }

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

        // we need to check if this item limits max dex and if so, unapply it
        // TODO using instanceof in this way is a bad practice we need to think of a better way
        if (item instanceof DexLimiting)
        {
            getBuffManager().removeDexLimiting((DexLimiting) item);
            calcBasedOnTargetChange(BonusTarget.MaxDexBonus);
        }

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
