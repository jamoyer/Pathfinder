package pathfinder.executables.combatSimulator;

import javax.swing.table.AbstractTableModel;

import pathfinder.world.Coordinate;
import pathfinder.world.FiniteWorld;

/**
 * Wraps a FiniteWorld object and uses it as an AbstractTableModel so it can be used as a java swing
 * table model. This is the model for CombatSimulator.
 *
 * @author jacob
 *
 */
public class BattleGridModel extends AbstractTableModel
{
    private static final long serialVersionUID = 2585682486865202183L;
    private final FiniteWorld world;
    private final GridTile[][] grid;

    /**
     * Initializes a 2-d battle grid.
     *
     * @param width
     * @param depth
     */
    public BattleGridModel(int width, int depth)
    {
        // only 1 level of height so it's a 2-d battle grid
        world = new FiniteWorld(width, 1, depth);
        grid = new GridTile[width][depth];

        for (int w = 0; w < world.getMaxWidth(); w++)
        {
            for (int d = 0; d < world.getMaxDepth(); d++)
            {
                grid[w][d] = new GridTile(world.getCellAt(new Coordinate(w, 0, d)));
            }
        }
    }

    @Override
    public int getColumnCount()
    {
        return world.getMaxWidth();
    }

    @Override
    public int getRowCount()
    {
        return world.getMaxDepth();
    }

    @Override
    public Object getValueAt(int width, int depth)
    {
        return grid[width][depth];
    }
}
