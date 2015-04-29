package pathfinder.combat;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

import pathfinder.realWorldObject.creature.Creature;

/**
 * Tracks a combat session. Creatures are added and then calling next() advances the round and
 * returns the creature that goes next. This class is an iterator over the creatures in combat,
 * meaning that the methods next() and hasNext() go to the next creature's turn. The remove() method
 * is not implemented and will throw an exception if its usage is attempted. If creatures are added
 * and combat has already begun, they will get their turn on the next round.
 *
 * @author Jamoyer
 *
 */
public class CombatRoundTracker implements Iterator<Creature>
{
    private final List<Combatant> _combatantList;

    // will keep track of the current round's turns, max heap that is sorted by initiative
    private final PriorityQueue<Combatant> _turnQueue = new PriorityQueue<Combatant>(2, Collections.reverseOrder());

    private int _currentRound = 0;
    private Combatant _currentCombatant = null;

    public CombatRoundTracker()
    {
        _combatantList = new LinkedList<Combatant>();
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
        return _currentRound;
    }

    /**
     * Adds a creature to combat. The creature will be active on the next round.
     *
     * @param combatant
     */
    public void addCombatant(final Creature creature)
    {
        _combatantList.add(new Combatant(creature));
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
            _combatantList.add(new Combatant(c));
        }
    }

    /**
     * Removes the creature from combat.
     *
     * @param creature
     */
    public void removeCombatant(final Creature creature)
    {
        _turnQueue.remove(creature);
        _combatantList.remove(creature);
    }

    /**
     * Removes all the creatures from combat.
     *
     * @param creatures
     */
    public void removeCombatants(final Collection<Creature> creatures)
    {
        _turnQueue.removeAll(creatures);
        _combatantList.removeAll(creatures);
    }

    /**
     * Returns the creature that is currently taking its turn in combat. If next() has not been
     * called yet, there will be no active combatant and this method will throw an exception.
     *
     * @return
     * @throws IllegalStateException
     *             If there is no active combatant.
     */
    public Creature getCurrentCombatant() throws IllegalStateException
    {
        if (_currentCombatant == null)
        {
            throw new IllegalStateException("No currently active combatant.");
        }
        return _currentCombatant.getCreature();
    }

    @Override
    public boolean hasNext()
    {
        return !_combatantList.isEmpty();
    }

    @Override
    public Creature next()
    {
        if (_currentCombatant != null)
        {
            _currentCombatant.endRound();
        }

        _currentCombatant = _turnQueue.poll();
        if (_currentCombatant == null)
        {
            if (_combatantList.isEmpty())
            {
                throw new NoSuchElementException("There are no combatants in combat.");
            }
            _currentRound++;
            _turnQueue.addAll(_combatantList);
            _currentCombatant = _turnQueue.poll();
        }

        _currentCombatant.beginRound();
        return _currentCombatant.getCreature();
    }
}
