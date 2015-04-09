package pathfinder.realWorldObject.creature.baseAttackBonus;

public class SlowBAB implements BaseAttackBonusProgression
{

    @Override
    public int getBAB(int level)
    {
        return level / 2;
    }

}
