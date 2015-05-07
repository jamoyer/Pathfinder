package pathfinder.realWorldObject.creature;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

import pathfinder.metaObjects.DiceSet;

public class AbilityScoreSet implements Iterable<AbilityScoreInstance>
{
    private final AbilityScoreInstance[] scores = new AbilityScoreInstance[AbilityScore.values().length];

    private static final Random RANDOM_INSTANCE = new Random();

    public AbilityScoreSet(int str, int dex, int con, int intel, int wis, int cha)
    {
        scores[AbilityScore.Strength.ordinal()] = new AbilityScoreInstance(AbilityScore.Strength, str);
        scores[AbilityScore.Dexterity.ordinal()] = new AbilityScoreInstance(AbilityScore.Dexterity, dex);
        scores[AbilityScore.Constitution.ordinal()] = new AbilityScoreInstance(AbilityScore.Constitution, con);
        scores[AbilityScore.Intelligence.ordinal()] = new AbilityScoreInstance(AbilityScore.Intelligence, intel);
        scores[AbilityScore.Wisdom.ordinal()] = new AbilityScoreInstance(AbilityScore.Wisdom, wis);
        scores[AbilityScore.Charisma.ordinal()] = new AbilityScoreInstance(AbilityScore.Charisma, cha);
    }

    public AbilityScoreSet addScores(final AbilityScoreSet scoresToAdd)
    {
        final int totalStr = scores[AbilityScore.Strength.ordinal()].getScore() + scoresToAdd.getStrengthScore();
        final int totalDex = scores[AbilityScore.Dexterity.ordinal()].getScore() + scoresToAdd.getDexterityScore();
        final int totalCon = scores[AbilityScore.Constitution.ordinal()].getScore() + scoresToAdd.getConstitutionScore();
        final int totalInt = scores[AbilityScore.Intelligence.ordinal()].getScore() + scoresToAdd.getIntelligenceScore();
        final int totalWis = scores[AbilityScore.Wisdom.ordinal()].getScore() + scoresToAdd.getWisdomScore();
        final int totalCha = scores[AbilityScore.Charisma.ordinal()].getScore() + scoresToAdd.getCharismaScore();
        return new AbilityScoreSet(totalStr, totalDex, totalCon, totalInt, totalWis, totalCha);
    }

    /**
     * Creates a new ability score set using the standard 4d6 drop lowest die rolling system with no
     * preference on particular abilities.
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

    public static AbilityScore rollRandomAbilityScore()
    {
        return AbilityScore.values()[RANDOM_INSTANCE.nextInt(AbilityScore.values().length)];
    }

    public int getStrengthScore()
    {
        return scores[AbilityScore.Strength.ordinal()].getScore();
    }

    public void setStrengthScore(final int score)
    {
        scores[AbilityScore.Strength.ordinal()].setScore(score);
    }

    public int getStrengthModifier()
    {
        return scores[AbilityScore.Strength.ordinal()].getModifier();
    }

    public int getDexterityScore()
    {
        return scores[AbilityScore.Dexterity.ordinal()].getScore();
    }

    public void setDexterityScore(final int score)
    {
        scores[AbilityScore.Dexterity.ordinal()].setScore(score);
    }

    public int getDexterityModifier()
    {
        return scores[AbilityScore.Dexterity.ordinal()].getModifier();
    }

    public int getConstitutionScore()
    {
        return scores[AbilityScore.Constitution.ordinal()].getScore();
    }

    public void setConstitutionScore(final int score)
    {
        scores[AbilityScore.Constitution.ordinal()].setScore(score);
    }

    public int getConstitutionModifier()
    {
        return scores[AbilityScore.Constitution.ordinal()].getModifier();
    }

    public int getIntelligenceScore()
    {
        return scores[AbilityScore.Intelligence.ordinal()].getScore();
    }

    public void setIntelligenceScore(final int score)
    {
        scores[AbilityScore.Intelligence.ordinal()].setScore(score);
    }

    public int getIntelligenceModifier()
    {
        return scores[AbilityScore.Intelligence.ordinal()].getModifier();
    }

    public int getWisdomScore()
    {
        return scores[AbilityScore.Wisdom.ordinal()].getScore();
    }

    public void setWisdomScore(final int score)
    {
        scores[AbilityScore.Wisdom.ordinal()].setScore(score);
    }

    public int getWisdomModifier()
    {
        return scores[AbilityScore.Wisdom.ordinal()].getModifier();
    }

    public int getCharismaScore()
    {
        return scores[AbilityScore.Charisma.ordinal()].getScore();
    }

    public void setCharismaScore(final int score)
    {
        scores[AbilityScore.Charisma.ordinal()].setScore(score);
    }

    public int getCharismaModifier()
    {
        return scores[AbilityScore.Charisma.ordinal()].getModifier();
    }

    /*
     * Allows the ability scores to be iterated over in a foreach loop without being modifiable from
     * such a loop.
     */
    @Override
    public Iterator<AbilityScoreInstance> iterator()
    {
        return Collections.unmodifiableCollection(Arrays.asList(scores)).iterator();
    }
}
