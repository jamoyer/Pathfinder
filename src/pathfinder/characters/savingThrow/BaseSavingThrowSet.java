package pathfinder.characters.savingThrow;

/**
 * Allows good and bad saves to be grouped together into a coherent saving throw
 * set. Should be used in PC and NPC classes and also in Creature Type
 * implementations.
 * 
 * @author jacob
 *
 */
public class BaseSavingThrowSet
{
    private final BaseSavingThrow fortitude;
    private final BaseSavingThrow reflex;
    private final BaseSavingThrow will;

    public BaseSavingThrowSet(final BaseSavingThrow fort, final BaseSavingThrow reflex, final BaseSavingThrow will)
    {
        this.fortitude = fort;
        this.reflex = reflex;
        this.will = will;
    }

    public int getBaseFortitude(final int level)
    {
        return fortitude.getBaseSave(level);
    }

    public int getBaseReflex(final int level)
    {
        return reflex.getBaseSave(level);
    }

    public int getBaseWill(final int level)
    {
        return will.getBaseSave(level);
    }

}
