package pathfinder.executables.combatSimulator;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

public class BattleGridView extends JTable
{
    private static final long serialVersionUID = 7736877960916738954L;
    private static final int MAX_COLUMN_WIDTH_PIXELS = 17;
    private static final int MAX_ROW_HEIGHT_PIXELS = 17;

    /**
     * Constructs the view of the given BattleGrid.
     *
     * @param model
     */
    public BattleGridView(final BattleGridModel model)
    {
        super(model);
        initBattleGridView();
    }

    @Override
    public void setModel(TableModel model)
    {
        super.setModel(model);
        initBattleGridView();
    }

    private void initBattleGridView()
    {
        setBorder(new MatteBorder(1, 1, 0, 0, Color.BLACK));
        setRowHeight(MAX_ROW_HEIGHT_PIXELS);
        setFillsViewportHeight(true);
        setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        rowSelectionAllowed = false;

        for (int i = 0; i < getColumnCount(); i++)
        {
            getColumnModel().getColumn(i).setMaxWidth(MAX_COLUMN_WIDTH_PIXELS);
            getColumnModel().getColumn(i).setCellRenderer(new BattleGridCellRenderer());
        }
    }

    // overrides the DefaultTableCellRenderer so that it displays the icons
    // within GridTiles
    private class BattleGridCellRenderer extends DefaultTableCellRenderer
    {
        private static final long serialVersionUID = -4329075438402892295L;

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col)
        {
            final GridTile tile = (GridTile) value;
            final JLabel label = new JLabel();
            label.setIcon(tile.getIcon());
            return label;
        }
    }
}
