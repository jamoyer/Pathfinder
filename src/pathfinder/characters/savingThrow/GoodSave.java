package pathfinder.characters.savingThrow;

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
        if (level <= 0)
        {
            return 0;
        }
        return 2 + level / 2;
    }

}
