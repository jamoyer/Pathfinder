package pathfinder.realWorldObject.creature.baseAttackBonus;

public class FastBAB implements BaseAttackBonusProgression
{

    @Override
    public int getBAB(int level)
    {
        return level;
    }

}
