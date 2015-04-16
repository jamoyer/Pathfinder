package pathfinder.realWorldObject.creature;

import pathfinder.realWorldObject.item.equipment.armor.Armor;

public enum Load implements DexLimiting
{
    Light(Armor.UNLIMITED_DEX_BONUS, 0, 4),
    Medium(3, -3, 4),
    Heavy(1, -6, 3);

    private final int maxDex;
    private final int checkPenalty;
    private final int runningSpeedMultiplier;

    private Load(int maxDex, int checkPenalty, int runningSpeedMultiplier)
    {
        this.maxDex = maxDex;
        this.checkPenalty = checkPenalty;
        this.runningSpeedMultiplier = runningSpeedMultiplier;
    }

    @Override
    public int getMaxDexBonus()
    {
        return maxDex;
    }

    public int getCheckPenalty()
    {
        return checkPenalty;
    }

    public int getRunningSpeedMultiplier()
    {
        return runningSpeedMultiplier;
    }

    /**
     * Returns the reduced speed for the load based on the base speed.
     *
     * @param baseSpeed
     * @return
     */
    public int getReducedSpeed(int baseSpeed)
    {
        if (!this.equals(Light))
        {
            // formula for reduced speed is 2/3 of baseSpeed rounded up to nearest 5
            return (baseSpeed * 2 / 3 + 4) / 5 * 5;
        }
        return baseSpeed;
    }
}
