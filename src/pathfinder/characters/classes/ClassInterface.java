package pathfinder.characters.classes;

import java.util.List;

import pathfinder.characters.baseAttackBonus.BaseAttackBonusProgression;
import pathfinder.characters.savingThrow.BaseSavingThrowSet;

/**
 * Both Character class and creature types should inherit this interface since
 * they are so similar and creatures with both will have the character class
 * overwrite the traits gained from the creature type.
 * 
 * @author jacob
 *
 */
public interface ClassInterface
{
    public int getHitDieType();

    public BaseAttackBonusProgression getBaseAttackBonusProgression();

    public BaseSavingThrowSet getSavingThrowSet();

    public int getSkillRanksPerLevel();

    public List<String> getClassSkills();

    public String getProficiencies();

    // TODO special abilities and such, if we find that is needed in this
    // interface at all.
}
