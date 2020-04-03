package Chapter10_14;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class TreeNodeConstructTree extends JFrame{
	public TreeNodeConstructTree() {
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("×ÖÄ¸±í");
		DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("´óÐ´×ÖÄ¸");
		DefaultMutableTreeNode node2 = new DefaultMutableTreeNode("Ð¡Ð´×ÖÄ¸");
		DefaultMutableTreeNode node3 = new DefaultMutableTreeNode("Readme");
		root.add(node1);
		root.add(node2);
		root.add(node3);
		node1.add(new DefaultMutableTreeNode("A"));
		node1.add(new DefaultMutableTreeNode("B"));
		node1.add(new DefaultMutableTreeNode("C"));
		node2.add(new DefaultMutableTreeNode("a"));
		node2.add(new DefaultMutableTreeNode("b"));
		node2.add(new DefaultMutableTreeNode("c"));
		JTree tree = new JTree(root);
		JScrollPane scrollpane = new JScrollPane();
		scrollpane.setViewportView(tree);
		add(scrollpane);
	}
	public static void main(String[] args) {
		TreeNodeConstructTree frame = new TreeNodeConstructTree();
		frame.setTitle("TreeNodeConstructTree");
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
