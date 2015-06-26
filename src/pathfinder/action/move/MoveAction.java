package pathfinder.action.move;

import pathfinder.action.ActionType;
import pathfinder.action.CreatureAction;
import pathfinder.realWorldObject.creature.Creature;
import pathfinder.time.TickCount;
import pathfinder.world.Coordinate;
import pathfinder.world.FiniteWorld;

public class MoveAction extends CreatureAction
{
    private final FiniteWorld world;
    private final Coordinate newPos;

    public MoveAction(final Creature actor, final FiniteWorld world, final Coordinate newPos)
    {
        super(actor);
        this.world = world;
        this.newPos = newPos;
    }

    @Override
    public ActionType getActionType()
    {
        return ActionType.Move;
    }

    @Override
    public TickCount getNumTicks()
    {
        return ActionType.Move.getNumTicks();
    }

    @Override
    public String getName()
    {
        return getClass().getSimpleName();
    }

    @Override
    public String getDescription()
    {
        return null;
    }

    @Override
    public boolean provokesAOO()
    {
        return true;
    }

    @Override
    public void execute()
    {
        // TODO Auto-generated method stub

    }

    /**
     * Checks whether the creature is allowed to move from their current position in the world to
     * the new position.
     *
     * Currently allows only checks if the creature is able to move far enough to reach the newPos
     * as if the creature could move through everything.
     *
     * TODO check if creature can navigate to the space in 3-d, meaning, is there a route on land,
     * or do they have the ability to fly/swim/climb/burrow their way there.
     *
     * TODO check if there is a clear path to the spot.
     *
     * @param actor
     * @param world
     * @param newPos
     * @return
     */
    public static boolean isValidMove(final Creature actor, final FiniteWorld world, final Coordinate newPos)
    {
        // final Coordinate currentPos = actor.getCoordinate();

        // if(world.getDistance(actor.getCoordinate(), newPos) <= actor.getEffectiveMovement().)
        return false;
    }

}