package pathfinder.executables.combatSimulator;

import java.awt.Font;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import pathfinder.combat.CombatRoundTracker;
import pathfinder.combat.Combatant;

public class CombatRoundTrackerPanel extends JPanel
{
    private static final long serialVersionUID = 2642262448531918167L;
    private static final String BTN_END_TURN_STARTING_TEXT = "BEGIN";
    private static final String BTN_END_TURN_TEXT = "END TURN";

    private final CombatRoundTracker combatRoundTracker = new CombatRoundTracker();

    private JLabel roundTrackerLabel;
    private JButton btnEndTurn;
    private JList<Object> list;

    /**
     * Create the panel.
     */
    public CombatRoundTrackerPanel()
    {
        setLayout(new MigLayout("", "[grow][]", "[][][][grow]"));

        // create the end turn button
        btnEndTurn = new JButton(BTN_END_TURN_STARTING_TEXT);
        btnEndTurn.addActionListener((event) ->
        {
            // at the start of the first round, this changes the text from "BEGIN" to "END TURN"
            if (btnEndTurn.getText().equals(BTN_END_TURN_STARTING_TEXT))
            {
                btnEndTurn.setText(BTN_END_TURN_TEXT);
            }

            // end the current creature's turn and move on to the next creature
            combatRoundTracker.next();

            // update the view
            updateView();
        });
        btnEndTurn.setFont(new Font("Dialog", Font.BOLD, 18));
        add(btnEndTurn, "cell 0 0");

        // create the label which shows the current round
        JLabel lblRound = new JLabel("ROUND");
        lblRound.setFont(new Font("Dialog", Font.BOLD, 18));
        add(lblRound, "cell 0 1");

        roundTrackerLabel = new JLabel();
        roundTrackerLabel.setFont(new Font("Dialog", Font.BOLD, 18));
        add(roundTrackerLabel, "cell 1 1");

        list = new JList<Object>();
        add(list, "cell 0 2 2 2,grow");
        updateView();
    }

    /**
     * Call this function whenever the current round has changed or the current combatant has changed.
     */
    public void updateView()
    {
        roundTrackerLabel.setText(combatRoundTracker.getCurrentRound() + "");
        List<Combatant> turnOrder = combatRoundTracker.getCombatantTurnOrder();
        Object[] turnOrderStrings = turnOrder.stream().filter(Objects::nonNull).map((c) ->
        {
            return "Creature ID: " + c.getCreature().getId() + " Initiative: " + c.getInitiative();
        }).collect(Collectors.toList()).toArray();
        list.setListData(turnOrderStrings);
    }

    public CombatRoundTracker getCombatRoundTracker()
    {
        return combatRoundTracker;
    }
}