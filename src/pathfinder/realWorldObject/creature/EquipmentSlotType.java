package pathfinder.realWorldObject.creature;

/**
 * This will contain all slots for equipment not just magic equipment slots. So this includes
 * shields, main weapons, off-hand weapons ...
 *
 * @author Jamoyer
 *
 */
public enum EquipmentSlotType
{
    Armor,
    Belt,
    Body,
    Chest,
    Eyes,
    Feet,
    Hands,
    Head,
    Headband,
    Neck,
    Ring1,
    Ring2,
    Shoulders,
    Wrists,
    MainHand,
    OffHand,
    TwoHands,

    // make sure slotless stays on the bottom, SlotManager depends on this.
    Slotless;
}
