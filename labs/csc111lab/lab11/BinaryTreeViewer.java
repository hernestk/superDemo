// CSC111L - Lab 11
// Hernest Koroli
package lab11;
import javax.swing.*;
import java.awt.*;
import java.text.Bidi;

public class BinaryTreeViewer extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7656256954539127745L;
	
	private BinaryTreeNode root;
    private int nodeSize = 40;
    private int yGap = 70;

    public BinaryTreeViewer(BinaryTreeNode root) {
        this.root = root;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (root != null) {
            drawTree(g, root, getWidth() / 2, 40, getWidth() / 4);
        }
    }

    private void drawTree(Graphics g, BinaryTreeNode node, int x, int y, int xOffset) {
        if (node == null) return;

        g.setColor(Color.BLUE);
        g.fillOval(x - nodeSize / 2, y - nodeSize / 2, nodeSize, nodeSize);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Calibri", Font.BOLD, 16));
        
        g.drawString(String.valueOf(node.key), x - 6, y + 4);

        g.setColor(Color.BLUE);

        // left child
        if (node.leftChild != null) {
            g.drawLine(x, y, x - xOffset, y + yGap);
            drawTree(g, node.leftChild, x - xOffset, y + yGap, xOffset / 2);
        }

        // right child
        if (node.rightChild != null) {
            g.drawLine(x, y, x + xOffset, y + yGap);
            drawTree(g, node.rightChild, x + xOffset, y + yGap, xOffset / 2);
        }
    }

    public static void show(BinaryTree tree) {
        JFrame frame = new JFrame("Binary Tree - yayyyy");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BinaryTreeViewer panel = new BinaryTreeViewer(tree.getRoot());
        frame.add(panel);

        frame.setSize(700, 550);
        frame.setVisible(true);
    }
    
	 public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        // first test
        // tree.insert(33);
        // tree.insert(24);
        // tree.insert(21);
        // tree.insert(33);
        // tree.insert(47);
        // tree.insert(50);
        // tree.insert(52);
        // tree.insert(83);
        // tree.insert(86);

        // second test
        // tree.insert(47);
        // tree.insert(24);
        // tree.insert(21);
        // tree.insert(33);
        // tree.insert(52);
        // tree.insert(50);
        // tree.insert(83);
        // tree.insert(86);

        // Uncomment one test at a time to see
        // the outputs I got.
        BinaryTreeViewer.show(tree);
        tree.inorderTraversal();
	 }
}