package pathfinder.realWorldObject.creature.creatureType;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import pathfinder.characters.baseAttackBonus.BaseAttackBonusProgression;
import pathfinder.characters.baseAttackBonus.SlowBAB;
import pathfinder.characters.savingThrow.BadSave;
import pathfinder.characters.savingThrow.BaseSavingThrow;
import pathfinder.characters.savingThrow.BaseSavingThrowSet;
import pathfinder.characters.savingThrow.GoodSave;
import pathfinder.characters.skill.Acrobatics;
import pathfinder.characters.skill.Bluff;
import pathfinder.characters.skill.Climb;
import pathfinder.characters.skill.Diplomacy;
import pathfinder.characters.skill.Disguise;
import pathfinder.characters.skill.EscapeArtist;
import pathfinder.characters.skill.Fly;
import pathfinder.characters.skill.Perception;
import pathfinder.characters.skill.SenseMotive;
import pathfinder.characters.skill.SleightOfHand;
import pathfinder.characters.skill.Stealth;
import pathfinder.characters.skill.Swim;
import pathfinder.characters.skill.UseMagicDevice;
import pathfinder.characters.skill.craft.Craft;
import pathfinder.characters.skill.knowledge.Geography;
import pathfinder.characters.skill.knowledge.Local;
import pathfinder.characters.skill.knowledge.Nature;
import pathfinder.characters.skill.perform.Perform;

public class Fey extends CreatureType
{
    /*
     * Basic Class Stats
     */
    private static final int HIT_DIE = 6;
    private static final int SKILL_RANKS_PER_LEVEL = 6;
    private static final BaseAttackBonusProgression BASE_ATTACK_BONUS = new SlowBAB();

    private static final BaseSavingThrow FORTITUDE = new BadSave();
    private static final BaseSavingThrow REFLEX = new GoodSave();
    private static final BaseSavingThrow WILL = new GoodSave();
    private static final BaseSavingThrowSet BASE_SAVES = new BaseSavingThrowSet(
            FORTITUDE, REFLEX, WILL);

    // needs to be unmodifiable so that when this list is passed it is not
    // accidentally modified, which could be disastrous
    private static final List<String> SKILLS = Collections
            .unmodifiableList(Arrays.asList(Acrobatics.NAME, Bluff.NAME,
                    Climb.NAME, Craft.NAME, Diplomacy.NAME, Disguise.NAME,
                    EscapeArtist.NAME, Fly.NAME, Geography.NAME, Local.NAME,
                    Nature.NAME, Perception.NAME, Perform.NAME,
                    SenseMotive.NAME, SleightOfHand.NAME, Stealth.NAME,
                    Swim.NAME, UseMagicDevice.NAME));

    @Override
    public int getHitDieType()
    {
        return HIT_DIE;
    }

    @Override
    public BaseAttackBonusProgression getBaseAttackBonusProgression()
    {
        return BASE_ATTACK_BONUS;
    }

    @Override
    public BaseSavingThrowSet getSavingThrowSet()
    {
        return BASE_SAVES;
    }

    @Override
    public int getSkillRanksPerLevel()
    {
        return SKILL_RANKS_PER_LEVEL;
    }

    @Override
    public List<String> getClassSkills()
    {
        return SKILLS;
    }

    @Override
    public String getProficiencies()
    {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * TODO class features
     */

}
