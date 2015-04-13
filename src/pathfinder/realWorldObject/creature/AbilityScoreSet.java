package pathfinder.realWorldObject.creature;

import pathfinder.metaObjects.DiceSet;

public class AbilityScoreSet
{

    private final AbilityScoreInstance strength;
    private final AbilityScoreInstance dexterity;
    private final AbilityScoreInstance constitution;
    private final AbilityScoreInstance intelligence;
    private final AbilityScoreInstance wisdom;
    private final AbilityScoreInstance charisma;

    public AbilityScoreSet(int str, int dex, int con, int intel, int wis, int cha)
    {
        strength = new AbilityScoreInstance(AbilityScore.Strength, str);
        dexterity = new AbilityScoreInstance(AbilityScore.Dexterity, dex);
        constitution = new AbilityScoreInstance(AbilityScore.Constitution, con);
        intelligence = new AbilityScoreInstance(AbilityScore.Intelligence, intel);
        wisdom = new AbilityScoreInstance(AbilityScore.Wisdom, wis);
        charisma = new AbilityScoreInstance(AbilityScore.Charisma, cha);
    }

    public AbilityScoreSet addScores(final AbilityScoreSet scoresToAdd)
    {
        final int totalStr = strength.getScore() + scoresToAdd.getStrengthScore();
        final int totalDex = dexterity.getScore() + scoresToAdd.getDexterityScore();
        final int totalCon = constitution.getScore() + scoresToAdd.getConstitutionScore();
        final int totalInt = intelligence.getScore() + scoresToAdd.getIntelligenceScore();
        final int totalWis = wisdom.getScore() + scoresToAdd.getWisdomScore();
        final int totalCha = charisma.getScore() + scoresToAdd.getCharismaScore();
        return new AbilityScoreSet(totalStr, totalDex, totalCon, totalInt, totalWis, totalCha);
    }

    /**
     * Creates a new ability score set using the standard 4d6 drop lowest die
     * rolling system with no preference on particular abilities.
     *
     * @return
     */
    public static AbilityScoreSet roll4d6AbilityScoreSet()
    {
        final DiceSet dice = new DiceSet(6, 4);
        final int[] scores = new int[6];
        for (int i = 0; i < 6; i++)
        {
            // rolls for a single score, sums all the dice, finds the lowest
            // single die and subtracts it from the total
            final int[] singleRoll = dice.getRolledSet();
            int sum = singleRoll[0];
            int lowestDieIndex = 0;
            for (int j = 1; j < singleRoll.length; j++)
            {
                sum += singleRoll[j];
                if (singleRoll[j] < singleRoll[lowestDieIndex])
                {
                    lowestDieIndex = j;
                }
            }
            sum -= singleRoll[lowestDieIndex];
            scores[i] = sum;
        }
        return new AbilityScoreSet(scores[0], scores[1], scores[3], scores[3], scores[4], scores[5]);
    }

    public int getStrengthScore()
    {
        return strength.getScore();
    }

    public void setStrengthScore(final int score)
    {
        strength.setScore(score);
    }

    public int getStrengthModifier()
    {
        return strength.getModifier();
    }

    public int getDexterityScore()
    {
        return dexterity.getScore();
    }

    public void setDexterityScore(final int score)
    {
        dexterity.setScore(score);
    }

    public int getDexterityModifier()
    {
        return dexterity.getModifier();
    }

    public int getConstitutionScore()
    {
        return constitution.getScore();
    }

    public void setConstitutionScore(final int score)
    {
        constitution.setScore(score);
    }

    public int getConstitutionModifier()
    {
        return constitution.getModifier();
    }

    public int getIntelligenceScore()
    {
        return intelligence.getScore();
    }

    public void setIntelligenceScore(final int score)
    {
        intelligence.setScore(score);
    }

    public int getIntelligenceModifier()
    {
        return intelligence.getModifier();
    }

    public int getWisdomScore()
    {
        return wisdom.getScore();
    }

    public void setWisdomScore(final int score)
    {
        wisdom.setScore(score);
    }

    public int getWisdomModifier()
    {
        return wisdom.getModifier();
    }

    public int getCharismaScore()
    {
        return charisma.getScore();
    }

    public void setCharismaScore(final int score)
    {
        charisma.setScore(score);
    }

    public int getCharismaModifier()
    {
        return charisma.getModifier();
    }
}
