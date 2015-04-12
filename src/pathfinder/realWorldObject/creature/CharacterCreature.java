package pathfinder.realWorldObject.creature;

import java.util.List;

import pathfinder.characters.buffs.BonusTarget;
import pathfinder.characters.classes.CharacterClass;
import pathfinder.characters.savingThrow.BaseSavingThrowSet;
import pathfinder.metaObjects.DiceSet;
import pathfinder.realWorldObject.creature.creatureType.CreatureType;
import pathfinder.realWorldObject.creature.creatureType.Humanoid;
import pathfinder.realWorldObject.item.equipment.SlotManager;

public class CharacterCreature extends Creature
{

    private final Humanoid race;
    private final List<CharacterClass> classes;
    private SlotManager equipment;

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

    protected SlotManager getEquipment()
    {
        return equipment;
    }

    protected void setEquipment(SlotManager equipment)
    {
        this.equipment = equipment;
    }

    protected void calcAbilityScores()
    {
        super.getAbilityScores().setStrengthScore(
                super.getAbilityScores().getStrengthScore() + equipment.getBonusByTarget(BonusTarget.Strength));
        super.getAbilityScores().setStrengthScore(
                super.getAbilityScores().getDexterityScore() + equipment.getBonusByTarget(BonusTarget.Dexterity));
        super.getAbilityScores().setStrengthScore(
                super.getAbilityScores().getConstitutionScore() + equipment.getBonusByTarget(BonusTarget.Constitution));
        super.getAbilityScores().setStrengthScore(
                super.getAbilityScores().getIntelligenceScore() + equipment.getBonusByTarget(BonusTarget.Intelligence));
        super.getAbilityScores().setStrengthScore(
                super.getAbilityScores().getWisdomScore() + equipment.getBonusByTarget(BonusTarget.Wisdom));
        super.getAbilityScores().setStrengthScore(
                super.getAbilityScores().getCharismaScore() + equipment.getBonusByTarget(BonusTarget.Charisma));
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
    protected void initMaxHealthPoints()
    {
        super.initMaxHealthPoints();

        int hpFromClasses = 0;
        for (final CharacterClass charClass : classes)
        {
            final DiceSet dice = new DiceSet(charClass.getHitDieType());
            hpFromClasses += dice.getRolledTotal();
        }
        super.setMaxHealthPoints(super.getMaxHealthPoints() + hpFromClasses);
    }

    @Override
    protected void calcInitiative()
    {
        super.calcInitiative();
        super.setInitiative(super.getInitiative() + equipment.getBonusByTarget(BonusTarget.Initiative));
    }

    @Override
    protected void calcCombatManueverBonus()
    {
        super.calcCombatManueverBonus();
        super.setCombatManueverBonus(super.getCombatManueverBonus() + equipment.getBonusByTarget(BonusTarget.CMB));
    }

    @Override
    protected void calcArmorBonuses()
    {
        super.calcArmorBonuses();
        super.setArmorClass(super.getArmorClass() + equipment.getBonusByTarget(BonusTarget.ArmorClass));
        super.setFlatfooted(super.getFlatfooted() + equipment.getBonusByTarget(BonusTarget.FlatFooted));
        super.setTouch(super.getTouch() + equipment.getBonusByTarget(BonusTarget.Touch));
        super.setCombatManueverDefense(super.getCombatManueverDefense() + equipment.getBonusByTarget(BonusTarget.CMD));
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
    protected void calcDamageReduction()
    {
        super.setDamageReduction(equipment.getBonusByTarget(BonusTarget.DR));
    }

    @Override
    protected void calcSpellResistance()
    {
        super.setDamageReduction(equipment.getBonusByTarget(BonusTarget.SR));
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
