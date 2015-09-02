package pathfinder.executables.combatSimulator;

import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import pathfinder.characters.classes.CharacterClass;
import pathfinder.characters.classes.CharacterClassFactory;
import pathfinder.realWorldObject.RealWorldObject;
import pathfinder.realWorldObject.SizeCategory;
import pathfinder.realWorldObject.creature.AbilityScoreSet;
import pathfinder.realWorldObject.creature.CharacterCreature;
import pathfinder.realWorldObject.creature.coreRaces.HumanoidFactory;
import pathfinder.realWorldObject.creature.creatureType.Humanoid;
import pathfinder.realWorldObject.item.equipment.armor.Armor;
import pathfinder.realWorldObject.item.equipment.weapon.ManufacturedWeapon;
import pathfinder.realWorldObject.item.equipment.weapon.WeaponCategory;

public class CombatSimulator implements NewSimulationListener
{
    private BattleGridModel model;
    private CombatSimulatorView view;

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
        initNewSimulation();
    }

    /**
     * Ends the old simulation if there was one and begins a new simulation.
     */
    private void initNewSimulation()
    {
        /*
         * Destroy the old simulation in whatever way we can. Seems to work but theres got to be a
         * better way than restarting the whole frame.
         */
        if (view != null)
        {
            //
            //
            view.removeAll();
            view.validate();
            view.dispose();
        }

        // build everything from the ground up
        model = new BattleGridModel(DEFAULT_WIDTH, DEFAULT_DEPTH);
        view = new CombatSimulatorView(model);
        view.setVisible(true);
        view.getBattleGridView().addMouseListener(new BattleGridMouseAdapter());
        view.getBattleGridView().addKeyListener(new BattleGridKeyAdapter());
        view.registerNewSimulationListener(this);
    }

    /*
     * This private key adapter handles what happens when you press a key on the BattleGrid.
     */
    private class BattleGridKeyAdapter extends KeyAdapter
    {
        @Override
        public void keyPressed(KeyEvent event)
        {

        }

        @Override
        public void keyReleased(KeyEvent event)
        {

        }
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
                view.getStatusMenu().setStatus(tile);
            }
            else if (pressed == RIGHT_CLICK)
            {
                // spawn object according to spawn menu specifications
                final SpawnMenu menu = view.getSpawnMenuView();
                final RealWorldObject rwo;
                switch (menu.getSpawnType())
                {
                    case Armor:
                        rwo = new Armor(menu.getSizeCategory(), menu.getSelectedArmor());
                        break;
                    case Creature:
                        final AbilityScoreSet scores = AbilityScoreSet.roll4d6AbilityScoreSet();
                        final Humanoid race = HumanoidFactory.buildCoreRace(menu.getSelectedRace());
                        final CharacterClass charClass = CharacterClassFactory.buildCharacterClass(menu.getSelectedClass(), menu.getClassLevel());
                        final CharacterCreature creature = new CharacterCreature(scores, race, charClass);
                        if (menu.creatureHasArmor())
                        {
                            creature.equipItem(new Armor(creature.getCreatureType().getSizeCategory(), menu.getCreatureArmor()));
                        }
                        if (menu.creatureHasShield())
                        {
                            creature.equipItem(new Armor(creature.getCreatureType().getSizeCategory(), menu.getCreatureShield()));
                        }
                        if (menu.creatureHasWeapon())
                        {
                            final SizeCategory creatureSize = creature.getCreatureType().getSizeCategory();
                            final WeaponCategory weaponCategory = menu.getCreatureWeapon().getWeaponCategory();
                            final SizeCategory weaponSize = ManufacturedWeapon.getWeaponSizeForCreature(creatureSize, weaponCategory);
                            creature.equipItem(new ManufacturedWeapon(weaponSize, menu.getCreatureWeapon()));
                        }
                        rwo = creature;
                        break;
                    case Shield:
                        rwo = new Armor(menu.getSizeCategory(), menu.getSelectedShield());
                        break;
                    case Weapon:
                        rwo = new ManufacturedWeapon(menu.getSizeCategory(), menu.getSelectedWeapon());
                        break;
                    default:
                        throw new IllegalStateException("No chosen spawn type.");
                }
                tile.addRWO(rwo);
                // update the view
                model.fireTableCellUpdated(width, depth);
            }
        }
    }

    @Override
    public void newSimulation()
    {
        initNewSimulation();
    }
}