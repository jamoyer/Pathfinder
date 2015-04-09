package pathfinder.characters.savingThrow;

/**
 * An interface for base saves. This allows for both good saving throws and bad
 * saving throws to have the same interface.
 * 
 * @author jacob
 *
 */
public interface BaseSavingThrow
{
    public int getBaseSave(int level);
}
