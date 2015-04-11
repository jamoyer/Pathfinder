package pathfinder.characters.classes;

import java.util.List;

import pathfinder.characters.baseAttackBonus.BaseAttackBonusProgression;
import pathfinder.characters.savingThrow.BaseSavingThrowSet;
import pathfinder.realWorldObject.item.equipment.Proficiency;

/**
 * Both Character class and creature types should inherit this interface since
 * they are so similar and creatures with both will have the character class
 * overwrite the traits gained from the creature type.
 *
 * @author jacob
 *
 */
public abstract class ClassInterface
{
    private int level;

    public ClassInterface()
    {
        level = 0;
    }

    public int getLevel()
    {
        return level;
    }

    public void setLevel(int level)
    {
        this.level = level;
    }

    public abstract int getHitDieType();

    public abstract BaseAttackBonusProgression getBaseAttackBonusProgression();

    public abstract BaseSavingThrowSet getSavingThrowSet();

    public abstract int getSkillRanksPerLevel();

    public abstract List<String> getClassSkills();

    public abstract List<Proficiency> getProficiencies();

    // TODO special abilities and such, if we find that is needed in this
    // interface at all.
}
