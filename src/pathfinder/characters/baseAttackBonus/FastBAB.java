package pathfinder.characters.baseAttackBonus;

public class FastBAB implements BaseAttackBonusProgression
{

    @Override
    public int getBAB(int level)
    {
        return level;
    }

}
