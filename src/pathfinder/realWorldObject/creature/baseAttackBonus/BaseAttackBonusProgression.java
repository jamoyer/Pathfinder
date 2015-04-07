package pathfinder.realWorldObject.creature.baseAttackBonus;

/**
 * Provides an interface for the different base attack bonus progressions so one
 * does not need to know which progression they are every time they calculate
 * the bab.
 * 
 * @author jacob
 *
 */
public interface BaseAttackBonusProgression
{
    public int getBAB(int level);
}
