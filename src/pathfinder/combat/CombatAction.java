package pathfinder.combat;

public interface CombatAction
{
    /**
     * What is the type of this action (Fullround, swift, immediate, standard, move...)
     *
     * @return
     */
    public CombatActionType getActionType();

    /**
     * Returns true if this action provokes an attack of opportunity.
     *
     * @return
     */
    public boolean provokesAttackOfOpportunity();
}
