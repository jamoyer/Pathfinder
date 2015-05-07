package pathfinder.executables.combatSimulator;

import java.util.Collection;

import javax.swing.ImageIcon;

import pathfinder.realWorldObject.RealWorldObject;
import pathfinder.realWorldObject.creature.Creature;
import pathfinder.realWorldObject.item.equipment.armor.Armor;
import pathfinder.realWorldObject.item.equipment.weapon.ManufacturedWeapon;
import pathfinder.world.Cell;
import pathfinder.world.Coordinate;

/**
 * Wraps a Cell object and provides a way to display images depending on what is in the cell.
 *
 * @author Jamoyer
 *
 */
public class GridTile
{
    private enum Sprite
    {
        Creature("resources/human_17.png"),
        Weapon("resources/weapon_17.png"),
        Armor("resources/armor_17.png"),
        Shield("resources/shield_17.png"),
        Land("resources/land_17.png");

        private final ImageIcon icon;

        private Sprite(final String fileName)
        {
            this.icon = new ImageIcon(getClass().getResource(fileName));
        }

        /**
         * Returns the ImageIcon that this represents.
         *
         * @return
         */
        public ImageIcon getIcon()
        {
            return icon;
        }
    }

    private static final int ADD = 1;
    private static final int SUB = -1;

    private final Cell cell;
    private int numCreatures;
    private int numArmors;
    private int numShields;
    private int numWeapons;

    public GridTile(final Cell cell)
    {
        this.cell = cell;

        // count the number of each object type
        for (final RealWorldObject rwo : cell.viewAllRWO())
        {
            updateCount(rwo, ADD);
        }
    }

    public Coordinate getCoordinate()
    {
        return cell.getCoordinate();
    }

    /**
     * Returns a read-only collection of the contents of this tile/cell.
     *
     * @return
     */
    public Collection<RealWorldObject> viewContents()
    {
        return cell.viewAllRWO();
    }

    public void addRWO(final RealWorldObject rwo)
    {
        cell.addRWO(rwo);
        updateCount(rwo, ADD);
    }

    public void removeRWO(final RealWorldObject rwo)
    {
        if (cell.removeRWO(rwo) != null)
        {
            updateCount(rwo, SUB);
        }
    }

    public ImageIcon getIcon()
    {
        if (numCreatures > 0)
        {
            return Sprite.Creature.getIcon();
        }
        if (numArmors > 0)
        {
            return Sprite.Armor.getIcon();
        }
        if (numShields > 0)
        {
            return Sprite.Shield.getIcon();
        }
        if (numWeapons > 0)
        {
            return Sprite.Weapon.getIcon();
        }
        return Sprite.Land.getIcon();
    }

    /**
     * Updates the count of the objects by passing in an object and a num which represents how much
     * to update by. Pass either ADD or SUB when adding or subtracting objects.
     *
     * @param rwo
     * @param numToUpdate
     */
    private void updateCount(final RealWorldObject rwo, int numToUpdate)
    {
        if (rwo instanceof Creature)
        {
            numCreatures += numToUpdate;
        }
        else if (rwo instanceof Armor)
        {
            final Armor armor = (Armor) rwo;
            if (Armor.isArmor(armor.getArmorProficiency()))
            {
                numArmors += numToUpdate;
            }
            else if (Armor.isShield(armor.getArmorProficiency()))
            {
                numShields += numToUpdate;
            }
        }
        else if (rwo instanceof ManufacturedWeapon)
        {
            numWeapons += numToUpdate;
        }
    }
}