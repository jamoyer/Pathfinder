package pathfinder.characters.baseAttackBonus;

public class MediumBAB implements BaseAttackBonusProgression
{

    @Override
    public int getBAB(int level)
    {
        return (level * 3) / 4;
    }

}
