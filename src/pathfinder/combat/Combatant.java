package pathfinder.combat;

import pathfinder.realWorldObject.creature.Creature;

/**
 * Represents a creature in combat. This class keeps track of every type of action the creature has
 * done in a round and is also comparable by their initiative.
 *
 * @author Jamoyer
 *
 */
public class Combatant implements Comparable<Combatant>
{
    private final int initiative;
    private final Creature creature;

    private boolean swiftUsed = false;
    private boolean fullRoundUsed = false;
    private boolean standardUsed = false;
    private boolean moveUsed = false;
    private int numAOOUsed = 0;
    private final int numAOOPerRound;

    public Combatant(final Creature _creature)
    {
        creature = _creature;
        initiative = creature.rollInitiative();
        numAOOPerRound = creature.getNumAttacksOfOpportunity();
    }

    public int getInitiative()
    {
        return initiative;
    }

    public Creature getCreature()
    {
        return creature;
    }

    public boolean usedSwift()
    {
        return swiftUsed;
    }

    public boolean usedFullRound()
    {
        return fullRoundUsed;
    }

    public boolean usedStandard()
    {
        return standardUsed;
    }

    public boolean usedMove()
    {
        return moveUsed;
    }

    public int getNumAttacksOfOpportunityPerRound()
    {
        return numAOOPerRound;
    }

    public int getNumAttacksOfOpportunityUsed()
    {
        return numAOOUsed;
    }

    /**
     * Call this at the beginning of the combatant's turn.
     */
    public void beginRound()
    {
        fullRoundUsed = false;
        moveUsed = false;
        standardUsed = false;
        numAOOUsed = 0;
    }

    /**
     * Call this at the end of the combatant's turn.
     */
    public void endRound()
    {
        /*
         * From http://www.d20pfsrd.com/gamemastering/combat#TOC-Immediate-Actions: You cannot use
         * another immediate action or a swift action until after your next turn if you have used an
         * immediate action when it is not currently your turn (effectively, using an immediate
         * action before your turn is equivalent to using your swift action for the coming turn).
         */
        swiftUsed = false;
    }

    /**
     * Makes the creature attempt to take the action. Returns true if the action can be taken this
     * round according to all actions that this creature has taken this round and records that the
     * action was taken. Returns false if the action cannot be taken.
     *
     * From http://www.d20pfsrd.com/gamemastering/combat#TOC-Action-Types: In a normal round, you
     * can perform a standard action and a move action, or you can perform a full-round action. You
     * can also perform one swift action and one or more free actions. You can always take a move
     * action in place of a standard action.
     *
     * @param action
     * @return True if the action is taken. False if the action cannot and is not taken.
     */
    public boolean attemptActionType(final CombatActionType action)
    {
        switch (action)
        {
            case FullRound:
                fullRoundUsed = !(moveUsed || standardUsed || fullRoundUsed);
                return fullRoundUsed;
            case Standard:
                if (fullRoundUsed)
                {
                    return false;
                }
                else if (!standardUsed)
                {
                    standardUsed = true;
                    return standardUsed;
                }
                return false;
            case Move:
                if (fullRoundUsed)
                {
                    return false;
                }
                if (!moveUsed)
                {
                    moveUsed = true;
                    return true;
                }
                // use standard as a move
                else if (!standardUsed)
                {
                    standardUsed = true;
                    return true;
                }
                return false;
            case AttackOfOpportunity:
                if (numAOOPerRound > numAOOUsed)
                {
                    numAOOUsed++;
                    return true;
                }
                return false;
            case Swift:
            case Immediate:
                /*
                 * From http://www.d20pfsrd.com/gamemastering/combat#TOC-Immediate-Actions: Using an
                 * immediate action on your turn is the same as using a swift action and counts as
                 * your swift action for that turn.
                 */
                if (!swiftUsed)
                {
                    swiftUsed = true;
                    return true;
                }
                return false;
            case Free:
            case NotAnAction:
            default:
                return true;
        }
    }

    @Override
    public int compareTo(Combatant arg0)
    {
        return Integer.compare(initiative, arg0.initiative);
    }

    @Override
    public boolean equals(Object o)
    {
        // combatants are only equal if the creatures are equal
        return creature.equals(o);
    }

    @Override
    public int hashCode()
    {
        return creature.hashCode();
    }
}