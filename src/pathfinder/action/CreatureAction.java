package pathfinder.action;

import pathfinder.realWorldObject.creature.Creature;
import pathfinder.time.TickCount;

/**
 * Represents anything that a creature can actively do. To do any skill, attack, active feat, spell,
 * or any other act that requires a creature to do something should be done through this object. As
 * such every Action must have a creature called an actor that is does the action. First construct
 * the Action and then call the execute method to actually perform the action.
 *
 * @author Jacob
 *
 */
public abstract class CreatureAction
{
    private final Creature actor;

    /**
     * Creates a new Action. Every action must have an actor creature that is doing this action.
     *
     * @param actor
     */
    public CreatureAction(Creature actor)
    {
        this.actor = actor;
    }

    /**
     * Gets the creature that is doing this action.
     *
     * @return
     */
    public final Creature getActor()
    {
        return actor;
    }

    /**
     * What is the type of this action (Fullround, swift, immediate, standard, move...)
     *
     * @return
     */
    public abstract ActionType getActionType();

    public abstract TickCount getNumTicks();

    /**
     * Gets the title or name of this action. Useful for displaying in menu's.
     *
     * @return
     */
    public abstract String getName();

    /**
     * Gets the description of what this action does. Useful for explaining this action to the user.
     *
     * @return
     */
    public abstract String getDescription();

    /**
     * Returns true if this action provokes an attack of opportunity.
     *
     * @return
     */
    public abstract boolean provokesAOO();

    /**
     * Performs the action.
     */
    public abstract void execute();
}
