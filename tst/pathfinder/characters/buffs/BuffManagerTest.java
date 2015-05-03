package pathfinder.characters.buffs;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pathfinder.realWorldObject.item.equipment.armor.Armor;

public class BuffManagerTest
{
    private BuffManager _buffManager;

    @Test
    public void testMaxDex()
    {
        _buffManager = new BuffManager();

        // buff manager with no dex limiting buffs added should not have a limiting dex
        assertEquals(_buffManager.getMaxDexBonus(), Armor.UNLIMITED_DEX_BONUS);

        // adding dex limiter that does not actually limit dex using anonymous class
        // lambda expressions!! kinda neat
        _buffManager.addDexLimiting(() ->
        {
            return Armor.UNLIMITED_DEX_BONUS;
        });
        assertEquals(_buffManager.getMaxDexBonus(), Armor.UNLIMITED_DEX_BONUS);

        // add something that limits dex should get it
        _buffManager.addDexLimiting(() ->
        {
            return 5;
        });
        assertEquals(_buffManager.getMaxDexBonus(), 5);

        // add something even lower, should get it back
        _buffManager.addDexLimiting(() ->
        {
            return 1;
        });
        assertEquals(_buffManager.getMaxDexBonus(), 1);

        // add something higher than what exists, should still return lowest
        _buffManager.addDexLimiting(() ->
        {
            return 6;
        });
        assertEquals(_buffManager.getMaxDexBonus(), 1);

        // after removing all the dex limiters, the limit should go back to normal
        _buffManager.clearDexLimiting();
        assertEquals(_buffManager.getMaxDexBonus(), Armor.UNLIMITED_DEX_BONUS);
    }

    @Test
    public void testBonuses()
    {
        _buffManager = new BuffManager();

        // buff manager should have all bonuses == 0 to begin with
        for (final BonusTarget target : BonusTarget.values())
        {
            assertEquals(0, _buffManager.getBonusByTarget(target));
        }

        // Add a bonus for every type to each target once, it should total up to total1.
        final int amount = 1;
        final int total1 = BonusType.values().length * amount;

        // Add all the bonuses again, only dodge bonuses and untyped bonuses stack so it should only
        // increase the total by 2
        final int total2 = total1 + 2;

        final CreatureBuff[][] buffs = new CreatureBuff[BonusTarget.values().length][BonusType.values().length];

        for (int i = 0; i < BonusTarget.values().length; i++)
        {
            final BonusTarget target = BonusTarget.values()[i];
            for (int j = 0; j < BonusType.values().length; j++)
            {
                final BonusType type = BonusType.values()[j];
                buffs[i][j] = new CreatureBuff(null, null, 0, false, 0, target, type, amount);
                _buffManager.addBuff(buffs[i][j]);
            }
            assertEquals(total1, _buffManager.getBonusByTarget(target));

            for (int j = 0; j < BonusType.values().length; j++)
            {
                _buffManager.addBuff(buffs[i][j]);
            }
            assertEquals(total2, _buffManager.getBonusByTarget(target));
        }

        // check to make sure all the targets are the same
        for (int i = 0; i < BonusTarget.values().length; i++)
        {
            assertEquals(total2, _buffManager.getBonusByTarget(BonusTarget.values()[i]));
        }

        // remove the second bonus from each
        for (int i = 0; i < BonusTarget.values().length; i++)
        {
            final BonusTarget target = BonusTarget.values()[i];
            for (int j = 0; j < BonusType.values().length; j++)
            {
                _buffManager.removeBuff(buffs[i][j]);
            }
            assertEquals(total1, _buffManager.getBonusByTarget(target));
        }

        // check to make sure all the targets are the same
        for (int i = 0; i < BonusTarget.values().length; i++)
        {
            assertEquals(total1, _buffManager.getBonusByTarget(BonusTarget.values()[i]));
        }

        // remove the first bonus from each
        for (int i = 0; i < BonusTarget.values().length; i++)
        {
            final BonusTarget target = BonusTarget.values()[i];
            for (int j = 0; j < BonusType.values().length; j++)
            {
                _buffManager.removeBuff(buffs[i][j]);
            }
            assertEquals(0, _buffManager.getBonusByTarget(target));
        }

        // check to make sure all the targets are the same
        for (int i = 0; i < BonusTarget.values().length; i++)
        {
            assertEquals(0, _buffManager.getBonusByTarget(BonusTarget.values()[i]));
        }
    }
}
