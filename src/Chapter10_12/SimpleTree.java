package Chapter10_12;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;

public class SimpleTree extends JFrame{
	public SimpleTree() {
		JTree tree = new JTree();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(tree);
		add(scrollPane);
	}
	public static void main(String[] args) {
		SimpleTree frame = new SimpleTree();
		frame.setTitle("�ҽ�����");
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
}
