package pathfinder.executables.combatSimulator.BattleGrid;

import java.util.Collection;

import javax.swing.ImageIcon;

import pathfinder.realWorldObject.Cell;
import pathfinder.realWorldObject.RealWorldObject;
import pathfinder.realWorldObject.creature.Creature;
import pathfinder.realWorldObject.item.equipment.armor.Armor;
import pathfinder.realWorldObject.item.equipment.weapon.ManufacturedWeapon;

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
        Creature("../resources/human_17.png"),
        Weapon("../resources/weapon_17.png"),
        Armor("../resources/armor_17.png"),
        Shield("../resources/shield_17.png"),
        Land("../resources/land_17.png");

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

    private final Cell cell;
    private boolean stateChanged = true;
    private Sprite icon;

    public GridTile(final Cell cell)
    {
        this.cell = cell;
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
        stateChanged = true;
        cell.addRWO(rwo);
    }

    public void removeRWO(final RealWorldObject rwo)
    {
        stateChanged = true;
        cell.removeRWO(rwo.getId());
    }

    public ImageIcon getIcon()
    {
        if (stateChanged)
        {
            Sprite current = null;
            for (final RealWorldObject rwo : cell.viewAllRWO())
            {
                /*
                 * View priority for when objects are stacked goes Creature>Armor>Shield>Weapon
                 */
                if (current != Sprite.Creature && rwo instanceof Creature)
                {
                    current = Sprite.Creature;
                    break;
                }
                else if (current != Sprite.Creature && current != Sprite.Armor && rwo instanceof Armor)
                {
                    final Armor armor = (Armor) rwo;
                    if (Armor.isArmor(armor.getArmorProficiency()))
                    {
                        current = Sprite.Armor;
                    }
                    else if (Armor.isShield(armor.getArmorProficiency()))
                    {
                        current = Sprite.Shield;
                    }
                }
                else if (current != Sprite.Creature && current != Sprite.Armor && current != Sprite.Weapon && rwo instanceof ManufacturedWeapon)
                {
                    current = Sprite.Weapon;
                }
            }
            stateChanged = false;
            if (current == null)
            {
                icon = Sprite.Land;
            }
            else
            {
                icon = current;
            }
        }
        return icon.getIcon();
    }
}
