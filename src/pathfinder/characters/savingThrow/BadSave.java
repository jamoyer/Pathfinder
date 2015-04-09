package pathfinder.characters.savingThrow;

/**
 * Gets the bad saving throw for a particular level.
 * 
 * @author jacob
 *
 */
public class BadSave implements BaseSavingThrow
{

    @Override
    public int getBaseSave(int level)
    {
        return level / 3;
    }

}
