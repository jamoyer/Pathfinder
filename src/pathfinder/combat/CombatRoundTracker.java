package pathfinder.combat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

import pathfinder.realWorldObject.creature.Creature;

/**
 * Tracks a combat session. Creatures are added and then calling next() advances the round and returns the creature
 * that goes next. This class is an iterator over the creatures in combat, meaning that the methods next() and
 * hasNext() go to the next creature's turn. The remove() method is not implemented and will throw an exception if
 * its usage is attempted. If creatures are added and combat has already begun, they will get their turn on the
 * next round.
 *
 * @author Jamoyer
 *
 */
public class CombatRoundTracker implements Iterator<Creature>
{
    private final List<Combatant> combatantList;

    /*
     * NOTE: the getCombatantTurnOrder method works very well without the use of this additional priorityqueue.
     * This class should integrate that method further into its internals or it should use this priority queue but
     * there should not be the two separate methods of keeping turn order.
     */
    // will keep track of the current round's turns, max heap that is sorted by initiative
    private final PriorityQueue<Combatant> turnQueue = new PriorityQueue<Combatant>(2, Collections.reverseOrder());

    private int currentRound = 0;
    private Combatant currentCombatant = null;

    public CombatRoundTracker()
    {
        combatantList = new LinkedList<Combatant>();
    }

    public CombatRoundTracker(final Collection<Creature> creatures)
    {
        this();
        addCombatants(creatures);
    }

    /**
     * Returns the current round of combat.
     *
     * @return
     */
    public int getCurrentRound()
    {
        return currentRound;
    }

    /**
     * Adds a creature to combat. The creature will be active on the next round.
     *
     * @param combatant
     */
    public void addCombatant(final Creature creature)
    {
        combatantList.add(new Combatant(creature));
    }

    /**
     * Adds multiple creatures to combat. The creatures will be active on the next round.
     *
     * @param creatures
     */
    public void addCombatants(final Collection<Creature> creatures)
    {
        for (final Creature c : creatures)
        {
            combatantList.add(new Combatant(c));
        }
    }

    /**
     * Removes the creature from combat.
     *
     * @param creature
     */
    public void removeCombatant(final Creature creature)
    {
        turnQueue.remove(creature);
        combatantList.remove(creature);
    }

    /**
     * Removes all the creatures in the given collection from combat.
     *
     * @param creatures
     */
    public void removeCombatants(final Collection<Creature> creatures)
    {
        turnQueue.removeAll(creatures);
        combatantList.removeAll(creatures);
    }

    /**
     * Returns a list of the combatants as they occur in the turn order. The first combatant is one who is
     * currently taking their turn.
     *
     * @return
     */
    public List<Combatant> getCombatantTurnOrder()
    {
        List<Combatant> turnOrder = new ArrayList<>(combatantList);

        // sort by initiative
        Collections.sort(turnOrder, Collections.reverseOrder());

        // get a list of combatants that have already gone this turn
        List<Combatant> alreadyWent = new LinkedList<>();
        for (int i = 0; i < turnOrder.size(); i++)
        {
            Combatant combatant = turnOrder.get(i);
            if (combatant.equals(currentCombatant))
            {
                break;
            }

            // remove this combatant from the list, we will add it to the end of the turn order
            turnOrder.set(i, null);
            alreadyWent.add(combatant);
        }

        // add all that already went this round to the end of the turn order
        turnOrder.addAll(alreadyWent);

        return Collections.unmodifiableList(turnOrder);
    }

    /**
     * Returns an unmodifiable list of all the creatures in combat.
     *
     * @return
     */
    public List<Creature> getCombatants()
    {
        // get the creature object from each combatant object and return as an unmodifiable list
        return Collections.unmodifiableList(combatantList.stream().map((c) ->
        {
            return c.getCreature();
        }).collect(Collectors.toList()));
    }

    /**
     * Returns the creature that is currently taking its turn in combat. If next() has not been called yet, there
     * will be no active combatant and this method will throw an exception.
     *
     * @return
     * @throws IllegalStateException If there is no active combatant.
     */
    public Creature getCurrentCombatant() throws IllegalStateException
    {
        if (currentCombatant == null)
        {
            throw new IllegalStateException("No currently active combatant.");
        }
        return currentCombatant.getCreature();
    }

    @Override
    public boolean hasNext()
    {
        return !combatantList.isEmpty();
    }

    @Override
    public Creature next()
    {
        if (currentCombatant != null)
        {
            currentCombatant.endRound();
        }

        currentCombatant = turnQueue.poll();
        if (currentCombatant == null)
        {
            if (combatantList.isEmpty())
            {
                throw new NoSuchElementException("There are no combatants in combat.");
            }
            currentRound++;
            turnQueue.addAll(combatantList);
            currentCombatant = turnQueue.poll();
        }

        currentCombatant.beginRound();
        return currentCombatant.getCreature();
    }
}
