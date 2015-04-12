package pathfinder.realWorldObject.creature;

import java.util.List;

import pathfinder.characters.classes.CharacterClass;
import pathfinder.characters.savingThrow.BaseSavingThrowSet;
import pathfinder.realWorldObject.creature.creatureType.CreatureType;
import pathfinder.realWorldObject.creature.creatureType.Humanoid;

public class CharacterCreature extends Creature
{

    private final Humanoid race;
    private final List<CharacterClass> classes;

    public CharacterCreature(final CreatureType creatureType, final AbilityScores baseStats, final Humanoid race,
            final List<CharacterClass> classList)
    {
        super(new AbilityScores(baseStats.getStrengthScore() + race.getAbilityScoreModifiers().getStrengthScore(),
                baseStats.getDexterityScore() + race.getAbilityScoreModifiers().getDexterityScore(),
                baseStats.getConstitutionScore() + race.getAbilityScoreModifiers().getConstitutionScore(),
                baseStats.getIntelligenceScore() + race.getAbilityScoreModifiers().getIntelligenceScore(),
                baseStats.getWisdomScore() + race.getAbilityScoreModifiers().getWisdomScore(),
                baseStats.getCharismaScore() + race.getAbilityScoreModifiers().getCharismaScore()));
        this.race = race;
        classes = classList;
    }

    @Override
    protected void calcLevel()
    {
        // initialize level to zero and then sum the level of every class
        super.setLevel(0);
        for (final CharacterClass charClass : classes)
        {
            super.setLevel(super.getLevel() + charClass.getLevel());
        }
    }

    @Override
    protected void calcBaseAttackBonus()
    {
        // initialize level to zero and then sum the level of every class
        super.setBaseAttackBonus(0);
        for (final CharacterClass charClass : classes)
        {
            super.setBaseAttackBonus(charClass.getBaseAttackBonusProgression().getBAB(charClass.getLevel())
                    + super.getBaseAttackBonus());
        }
    }

    @Override
    protected void calcSaves()
    {
        super.calcSaves();
        for (final CharacterClass charClass : classes)
        {
            final BaseSavingThrowSet baseSaves = charClass.getSavingThrowSet();
            super.setReflex(super.getReflex() + baseSaves.getBaseReflex(charClass.getLevel()));
            super.setFortitude(super.getFortitude() + baseSaves.getBaseFortitude(charClass.getLevel()));
            super.setWill(super.getWill() + baseSaves.getBaseWill(charClass.getLevel()));
        }
    }

    @Override
    protected void calcSizeCategory()
    {
        super.setSize(race.getSizeCategory());
    }

    @Override
    protected void calcMoveSpeeds()
    {
        super.setSpeeds(race.getMoveSpeeds());
    }

}
