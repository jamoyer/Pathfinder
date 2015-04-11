package pathfinder.realWorldObject.creature;

import java.util.ArrayList;

public class AbilityScores
{

    private final ArrayList<AbilityScoreInstance> scores = new ArrayList<AbilityScoreInstance>(6);

    public AbilityScores(int str, int dex, int con, int intel, int wis, int cha)
    {
        scores.add(AbilityScore.Strength.ordinal(), new AbilityScoreInstance(AbilityScore.Strength, str));
        scores.add(AbilityScore.Dexterity.ordinal(), new AbilityScoreInstance(AbilityScore.Dexterity, dex));
        scores.add(AbilityScore.Constitution.ordinal(), new AbilityScoreInstance(AbilityScore.Constitution, con));
        scores.add(AbilityScore.Intelligence.ordinal(), new AbilityScoreInstance(AbilityScore.Intelligence, intel));
        scores.add(AbilityScore.Wisdom.ordinal(), new AbilityScoreInstance(AbilityScore.Wisdom, wis));
        scores.add(AbilityScore.Charisma.ordinal(), new AbilityScoreInstance(AbilityScore.Charisma, cha));
    }

    public int getStrengthScore()
    {
        return scores.get(AbilityScore.Strength.ordinal()).getScore();
    }

    public void setStrengthScore(final int score)
    {
        scores.get(AbilityScore.Strength.ordinal()).setScore(score);
    }

    public int getStrengthModifier()
    {
        return scores.get(AbilityScore.Strength.ordinal()).getModifier();
    }

    public int getDexterityScore()
    {
        return scores.get(AbilityScore.Dexterity.ordinal()).getScore();
    }

    public void setDexterityScore(final int score)
    {
        scores.get(AbilityScore.Dexterity.ordinal()).setScore(score);
    }

    public int getDexterityModifier()
    {
        return scores.get(AbilityScore.Dexterity.ordinal()).getModifier();
    }

    public int getConstitutionScore()
    {
        return scores.get(AbilityScore.Constitution.ordinal()).getScore();
    }

    public void setConstitutionScore(final int score)
    {
        scores.get(AbilityScore.Constitution.ordinal()).setScore(score);
    }

    public int getConstitutionModifier()
    {
        return scores.get(AbilityScore.Constitution.ordinal()).getModifier();
    }

    public int getIntelligenceScore()
    {
        return scores.get(AbilityScore.Intelligence.ordinal()).getScore();
    }

    public void setIntelligenceScore(final int score)
    {
        scores.get(AbilityScore.Intelligence.ordinal()).setScore(score);
    }

    public int getIntelligenceModifier()
    {
        return scores.get(AbilityScore.Intelligence.ordinal()).getModifier();
    }

    public int getWisdomScore()
    {
        return scores.get(AbilityScore.Wisdom.ordinal()).getScore();
    }

    public void setWisdomScore(final int score)
    {
        scores.get(AbilityScore.Wisdom.ordinal()).setScore(score);
    }

    public int getWisdomModifier()
    {
        return scores.get(AbilityScore.Wisdom.ordinal()).getModifier();
    }

    public int getCharismaScore()
    {
        return scores.get(AbilityScore.Charisma.ordinal()).getScore();
    }

    public void setCharismaScore(final int score)
    {
        scores.get(AbilityScore.Charisma.ordinal()).setScore(score);
    }

    public int getCharismaModifier()
    {
        return scores.get(AbilityScore.Charisma.ordinal()).getModifier();
    }
}
