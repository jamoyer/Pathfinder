package pathfinder.realWorldObject.creature;

import java.util.Arrays;
import java.util.List;

import pathfinder.characters.buffs.BonusTarget;
import pathfinder.characters.classes.CharacterClass;
import pathfinder.metaObjects.DiceSet;
import pathfinder.realWorldObject.creature.creatureType.Humanoid;
import pathfinder.realWorldObject.item.equipment.SlotManager;

public class CharacterCreature extends Creature
{
    private final int totalLevel;
    private final Humanoid race;
    private final List<CharacterClass> classes;
    private SlotManager equipment;

    public CharacterCreature(final AbilityScoreSet baseStats, final Humanoid race, final CharacterClass charClass)
    {
        this(baseStats, race, Arrays.asList(charClass));
    }

    public CharacterCreature(final AbilityScoreSet baseStats, final Humanoid race, final List<CharacterClass> classList)
    {
        super(baseStats.addScores(race.getAbilityScoreModifiers()), race);
        this.race = race;
        classes = classList;
        totalLevel = calcTotalLevel();
        super.setBaseAttackBonus(calcCharacterBaseAttackBonus());

        super.setCombatManueverDefense(calcCombatManueverDefense());

        super.setMaxHealthPoints(calcCharacterMaxHealthPointsRandom());
        super.setCurrentHP(calcCurrentHP());

        super.setReflex(calcCharacterReflex());
        super.setFortitude(calcCharacterFortitude());
        super.setWill(calcCharacterWill());
    }

    public int getCharacterLevel()
    {
        return totalLevel;
    }

    public SlotManager getEquipment()
    {
        return equipment;
    }

    /*****************************************************
     *************** Calculation Functions ***************
     *****************************************************/

    private int calcTotalLevel()
    {
        int level = 0;
        for (final CharacterClass charClass : classes)
        {
            level += charClass.getLevel();
        }
        return level;
    }

    public int calcCharacterMaxHealthPointsRandom()
    {
        final int conHP = getCharacterLevel() * getEffectiveAbilityScores().getConstitutionModifier();
        final int bonusHP = getBuffManager().getBonusByTarget(BonusTarget.MaxHp);

        int hpFromClasses = 0;
        boolean isFirstClass = true;
        for (final CharacterClass charClass : classes)
        {
            final int hitDie = race.getHitDieType();
            final int level = charClass.getLevel();
            if (isFirstClass)
            {
                // if this is the first class give one full hitDie of health for first level, the
                // rest is random
                hpFromClasses += new DiceSet(hitDie, level - 1).getRolledTotal() + hitDie;
                isFirstClass = false;
            }
            else
            {
                hpFromClasses += new DiceSet(hitDie, level).getRolledTotal();
            }
        }
        return hpFromClasses + conHP + bonusHP;
    }

    public int calcCharacterBaseAttackBonus()
    {
        int bab = 0;
        // initialize level to zero and then sum the level of every class
        for (final CharacterClass charClass : classes)
        {
            bab += charClass.getBaseAttackBonusProgression().getBAB(charClass.getLevel());
        }
        return bab;
    }

    public int calcCharacterFortitude()
    {
        final int conMod = getEffectiveAbilityScores().getConstitutionModifier();
        final int fortBonus = getBuffManager().getBonusByTarget(BonusTarget.Fortitude);

        int baseFort = 0;
        for (final CharacterClass charClass : classes)
        {
            baseFort += charClass.getSavingThrowSet().getBaseFortitude(charClass.getLevel());
        }

        return conMod + baseFort + fortBonus;
    }

    public int calcCharacterReflex()
    {
        final int dexMod = getEffectiveAbilityScores().getDexterityModifier();
        final int reflexBonus = getBuffManager().getBonusByTarget(BonusTarget.Reflex);

        int baseReflex = 0;
        for (final CharacterClass charClass : classes)
        {
            baseReflex += charClass.getSavingThrowSet().getBaseReflex(charClass.getLevel());
        }

        return dexMod + baseReflex + reflexBonus;
    }

    public int calcCharacterWill()
    {
        final int wisMod = getEffectiveAbilityScores().getWisdomModifier();
        final int willBonus = getBuffManager().getBonusByTarget(BonusTarget.Will);

        int baseWill = 0;
        for (final CharacterClass charClass : classes)
        {
            baseWill += charClass.getSavingThrowSet().getBaseWill(charClass.getLevel());
        }

        return wisMod + baseWill + willBonus;
    }

}
