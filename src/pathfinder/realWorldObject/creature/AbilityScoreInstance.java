package pathfinder.realWorldObject.creature;

public class AbilityScoreInstance
{
    private final AbilityScore type;
    private int score;
    private int modifier;

    public AbilityScoreInstance(final AbilityScore type, final int score)
    {
        this.type = type;
        this.setScore(score);
        setModByScore(score);
    }

    private void setModByScore(final int score)
    {
        this.modifier = getModByScore(score);
    }

    private static int getModByScore(final int score)
    {
        return (score - 10) / 2;
    }

    public AbilityScore getType()
    {
        return type;
    }

    public int getScore()
    {
        return score;
    }

    public void setScore(int score)
    {
        this.score = score;
        setModByScore(score);
    }

    public int getModifier()
    {
        return modifier;
    }
}
