package pathfinder.realWorldObject.creature;

import java.util.ArrayList;

public class AbilityScores
{

    private final ArrayList<AbilityScore> scores = new ArrayList<AbilityScore>(6);
    private static final int strIndex = 0;
    private static final int dexIndex = 1;
    private static final int conIndex = 2;
    private static final int intelIndex = 3;
    private static final int wisIndex = 4;
    private static final int chaIndex = 5;

    public AbilityScores(int str, int dex, int con, int intel, int wis, int cha)
    {
        scores.add(strIndex, new AbilityScore("Strength", str));
        scores.add(dexIndex, new AbilityScore("Dexterity", dex));
        scores.add(conIndex, new AbilityScore("Constitution", con));
        scores.add(intelIndex, new AbilityScore("Intelligence", intel));
        scores.add(wisIndex, new AbilityScore("Wisdom", wis));
        scores.add(chaIndex, new AbilityScore("Charisma", cha));
    }

    public int getStrengthScore()
    {
        return scores.get(strIndex).getScore();
    }

    public void setStrengthScore(final int score)
    {
        scores.get(strIndex).setScore(score);
    }

    public int getStrengthModifier()
    {
        return scores.get(strIndex).getModifier();
    }

    public int getDexterityScore()
    {
        return scores.get(dexIndex).getScore();
    }

    public void setDexterityScore(final int score)
    {
        scores.get(dexIndex).setScore(score);
    }

    public int getDexterityModifier()
    {
        return scores.get(dexIndex).getModifier();
    }

    public int getConstitutionScore()
    {
        return scores.get(conIndex).getScore();
    }

    public void setConstitutionScore(final int score)
    {
        scores.get(conIndex).setScore(score);
    }

    public int getConstitutionModifier()
    {
        return scores.get(conIndex).getModifier();
    }

    public int getIntelligenceScore()
    {
        return scores.get(intelIndex).getScore();
    }

    public void setIntelligenceScore(final int score)
    {
        scores.get(intelIndex).setScore(score);
    }

    public int getIntelligenceModifier()
    {
        return scores.get(intelIndex).getModifier();
    }

    public int getWisdomScore()
    {
        return scores.get(wisIndex).getScore();
    }

    public void setWisdomScore(final int score)
    {
        scores.get(wisIndex).setScore(score);
    }

    public int getWisdomModifier()
    {
        return scores.get(wisIndex).getModifier();
    }

    public int getCharismaScore()
    {
        return scores.get(chaIndex).getScore();
    }

    public void setCharismaScore(final int score)
    {
        scores.get(chaIndex).setScore(score);
    }

    public int getCharismaModifier()
    {
        return scores.get(chaIndex).getModifier();
    }
}
