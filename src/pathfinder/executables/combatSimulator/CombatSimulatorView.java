package pathfinder.executables.combatSimulator;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.Window;
import java.util.Collection;
import java.util.LinkedList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CombatSimulatorView extends JFrame
{
    private static final long serialVersionUID = -4040020361830908122L;
    private static final String DEFAULT_TITLE = "Pathfinder Combat Simulator";

    private final StatusMenu statusView;
    private final BattleGridView gridView;
    private final SpawnMenu spawnMenuView;
    private final CombatRoundTrackerPanel roundCounter;

    private final Collection<NewSimulationListener> newSimulationListeners = new LinkedList<NewSimulationListener>();

    public CombatSimulatorView(final BattleGridModel gridModel)
    {
        this(DEFAULT_TITLE, gridModel);
    }

    public CombatSimulatorView(String title, final BattleGridModel gridModel)
    {
        super(title);
        this.statusView = new StatusMenu();
        this.gridView = new BattleGridView(gridModel);
        this.spawnMenuView = new SpawnMenu();
        this.roundCounter = new CombatRoundTrackerPanel();

        // contentPanel consists of everything on the JFrame
        final JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.add(menuPanel());

        final JPanel combatInfoPanel = new JPanel();
        combatInfoPanel.setLayout(new BoxLayout(combatInfoPanel, BoxLayout.Y_AXIS));
        combatInfoPanel.add(roundCounter);
        // TODO: add panel showing available actions for the selected creature

        final JPanel bodyPanel = new JPanel();
        bodyPanel.add(combatInfoPanel);
        bodyPanel.add(fieldPanel(gridView));
        bodyPanel.add(spawnMenuView);
        contentPanel.add(bodyPanel);
        contentPanel.add(statusView);

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
            fireNewSimulationListeners();
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

    public StatusMenu getStatusMenu()
    {
        return statusView;
    }
    public CombatRoundTrackerPanel getRoundCounter()
    {
        return roundCounter;
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

    public void registerNewSimulationListener(final NewSimulationListener listener)
    {
        newSimulationListeners.add(listener);
    }

    private void fireNewSimulationListeners()
    {
        for (final NewSimulationListener listener : newSimulationListeners)
        {
            listener.newSimulation();
        }
    }

}
