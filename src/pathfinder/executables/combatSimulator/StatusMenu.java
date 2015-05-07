package pathfinder.executables.combatSimulator;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import net.miginfocom.swing.MigLayout;
import pathfinder.realWorldObject.RealWorldObject;

public class StatusMenu extends JPanel
{
    private static final long serialVersionUID = -6822163428402680358L;
    private final JTree tree;

    /**
     * Create the panel.
     */
    public StatusMenu()
    {
        setLayout(new MigLayout("", "[683px,grow]", "[25px][168px,grow]"));

        final JLabel lblStatus = new JLabel(" Status");
        lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(lblStatus, "flowx,cell 0 0,alignx left,aligny center");

        final JScrollPane scrollPane = new JScrollPane();
        add(scrollPane, "cell 0 1,grow");

        tree = new JTree();
        scrollPane.setViewportView(tree);
        tree.setModel(null);
        tree.setScrollsOnExpand(true);

        final JLabel lblleftClickTo = new JLabel("*left click to view the contents of a tile");
        add(lblleftClickTo, "cell 0 0");

    }

    public void setStatus(final GridTile tile)
    {
        final DefaultMutableTreeNode root = new DefaultMutableTreeNode("Cell: " + tile.getCoordinate());
        for (final RealWorldObject rwo : tile.viewContents())
        {
            final DefaultMutableTreeNode node = new DefaultMutableTreeNode(rwo.getClass().getSimpleName());
            for (final String property : rwo.getProperties())
            {
                node.add(new DefaultMutableTreeNode(property));
            }
            root.add(node);
        }
        final DefaultTreeModel model = new DefaultTreeModel(root);
        tree.setModel(model);
    }
}
