package pathfinder.realWorldObject.creature;

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
    Ring,
    Shield,
    Shoulders,
    Wrists,

    // make sure slotless stays on the bottom, SlotManager depends on this.
    Slotless;
}
