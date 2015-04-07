package pathfinder.realWorldObject.creature.baseAttackBonus;

public class SlowBAB implements BaseAttackBonusProgression
{

    @Override
    public int getBAB(int level)
    {
        return (int) (level * .5);
    }

}
