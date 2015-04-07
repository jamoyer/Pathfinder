package pathfinder.realWorldObject.creature;

public class AbilityScore
{
    private final String name;
    private int score;
    private int modifier;

    public AbilityScore(final String name, final int score)
    {
        this.name = name;
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

    public String getName()
    {
        return name;
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
