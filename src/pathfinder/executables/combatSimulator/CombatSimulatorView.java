package pathfinder.executables.combatSimulator;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import pathfinder.executables.combatSimulator.BattleGrid.BattleGridModel;
import pathfinder.executables.combatSimulator.BattleGrid.BattleGridView;

public class CombatSimulatorView extends JFrame
{
    private static final long serialVersionUID = -4040020361830908122L;
    private static final String DEFAULT_TITLE = "Pathfinder Combat Simulator";

    private final BattleGridView gridView;
    private final SpawnMenu spawnMenuView;

    public CombatSimulatorView(final BattleGridModel gridModel)
    {
        this(DEFAULT_TITLE, gridModel);
    }

    public CombatSimulatorView(String title, final BattleGridModel gridModel)
    {
        super(title);
        this.gridView = new BattleGridView(gridModel);
        this.spawnMenuView = new SpawnMenu();

        // contentPanel consists of everything on the JFrame
        final JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.add(menuPanel());

        // bodyPanel consists most of the program, containing the controlMenu, battlegrid, and
        // spawnmenu
        final JPanel bodyPanel = new JPanel();
        // body.add(controlMenuView);
        bodyPanel.add(fieldPanel(gridView));
        bodyPanel.add(spawnMenuView);
        contentPanel.add(bodyPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setContentPane(contentPanel);
        pack();
        centerWindow(this);
    }

    private JPanel menuPanel()
    {
        final JMenuBar mainMenu = new JMenuBar();

        // build the simulation menu
        final JMenu simulationMenu = new JMenu("Simulation");
        final JMenuItem newSimulationItem = new JMenuItem("New Simulation");
        newSimulationItem.addActionListener((event) ->
        {
            // TODO do something for clicking this button
            });
        simulationMenu.add(newSimulationItem);
        final JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener((event) ->
        {
            System.exit(0);
        });
        simulationMenu.add(exitItem);
        mainMenu.add(simulationMenu);

        // build the help menu
        final JMenu helpMenu = new JMenu("Help");
        final JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.addActionListener((event) ->
        {
            JOptionPane.showMessageDialog(new JFrame(), "Use the Combat Simulator to simulate fights between creatures using pathfinder combat mechanics.");
        });
        helpMenu.add(aboutItem);
        mainMenu.add(helpMenu);

        final JPanel menuPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        menuPanel.add(mainMenu);
        return menuPanel;
    }

    // panel to contain the JMinefield
    private JPanel fieldPanel(final BattleGridView field)
    {
        final JPanel fieldPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        fieldPanel.add(field);
        return fieldPanel;
    }

    public SpawnMenu getSpawnMenuView()
    {
        return spawnMenuView;
    }

    public BattleGridView getBattleGridView()
    {
        return gridView;
    }

    /**
     * Centers the window on the screen.
     *
     * @param frame
     */
    public static void centerWindow(final Window frame)
    {
        final Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        final int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        final int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }

}
