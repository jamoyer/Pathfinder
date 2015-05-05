package pathfinder.executables.combatSimulator;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import pathfinder.characters.classes.CharacterClass;
import pathfinder.characters.classes.CharacterClassFactory;
import pathfinder.executables.combatSimulator.BattleGrid.BattleGridModel;
import pathfinder.executables.combatSimulator.BattleGrid.GridTile;
import pathfinder.realWorldObject.RealWorldObject;
import pathfinder.realWorldObject.creature.AbilityScoreSet;
import pathfinder.realWorldObject.creature.CharacterCreature;
import pathfinder.realWorldObject.creature.coreRaces.HumanoidFactory;
import pathfinder.realWorldObject.creature.creatureType.Humanoid;
import pathfinder.realWorldObject.item.equipment.armor.Armor;
import pathfinder.realWorldObject.item.equipment.weapon.ManufacturedWeapon;

public class CombatSimulator
{
    private final BattleGridModel model;
    private final CombatSimulatorView view;

    private static final int DEFAULT_WIDTH = 20;
    private static final int DEFAULT_DEPTH = 20;

    /**
     * Begins the combat simulator in a new thread.
     *
     * @param args
     */
    public static void main(String[] args)
    {
        EventQueue.invokeLater(() ->
        {
            new CombatSimulator();
        });
    }

    /**
     * Initializes the model to default width and depth and initializes the JFrame of the simulator.
     */
    public CombatSimulator()
    {
        model = new BattleGridModel(DEFAULT_WIDTH, DEFAULT_DEPTH);
        view = new CombatSimulatorView(model);
        view.setVisible(true);
        view.getBattleGridView().addMouseListener(new BattleGridMouseAdapter());
    }

    /*
     * This private mouse adapter handles what happens when you click on the BattleGrid.
     */
    private class BattleGridMouseAdapter extends MouseAdapter
    {
        private static final int LEFT_CLICK = 1;
        private static final int RIGHT_CLICK = 3;

        // Handles what happens when the mouse is pressed on the JMinefield
        @Override
        public void mousePressed(MouseEvent e)
        {
            final int pressed = e.getButton();
            if (pressed == LEFT_CLICK)
            {

            }
            else if (pressed == RIGHT_CLICK)
            {

            }
        }

        // Handles what happens when the mouse is released on the JMinefield.
        @Override
        public void mouseReleased(MouseEvent e)
        {
            /*
             * Row == Width, Col == Depth
             */
            // get the row and column where the mouse was released
            final int width = view.getBattleGridView().rowAtPoint(e.getPoint());
            final int depth = view.getBattleGridView().columnAtPoint(e.getPoint());
            final GridTile tile = (GridTile) model.getValueAt(width, depth);

            final int pressed = e.getButton();
            if (pressed == LEFT_CLICK)
            {

            }
            else if (pressed == RIGHT_CLICK)
            {
                // spawn object according to spawn menu specifications
                final SpawnMenu menu = view.getSpawnMenuView();
                final RealWorldObject rwo;
                switch (menu.getSpawnType())
                {
                    case Armor:
                        rwo = new Armor(menu.getSizeCategory(), menu.getCreatureArmor());
                        break;
                    case Creature:
                        final AbilityScoreSet scores = AbilityScoreSet.roll4d6AbilityScoreSet();
                        final Humanoid race = HumanoidFactory.buildCoreRace(menu.getSelectedRace());
                        final CharacterClass charClass = CharacterClassFactory.buildCharacterClass(menu.getSelectedClass(), menu.getClassLevel());
                        rwo = new CharacterCreature(scores, race, charClass);
                        break;
                    case Shield:
                        rwo = new Armor(menu.getSizeCategory(), menu.getCreatureShield());
                        break;
                    case Weapon:
                        rwo = new ManufacturedWeapon(menu.getSizeCategory(), menu.getCreatureWeapon());
                        break;
                    default:
                        throw new IllegalStateException("No chosen spawn type.");
                }
                tile.addRWO(rwo);
            }
            // update the view
            model.fireTableCellUpdated(width, depth);
        }
    }
}
