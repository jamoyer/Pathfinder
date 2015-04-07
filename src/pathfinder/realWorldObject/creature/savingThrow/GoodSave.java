package pathfinder.realWorldObject.creature.savingThrow;

/**
 * Gets the good saving throw for a particular level.
 * 
 * @author jacob
 *
 */
public class GoodSave implements BaseSavingThrow
{

    @Override
    public int getBaseSave(int level)
    {
        return 2 + (int) (.5 * level);
    }

}
