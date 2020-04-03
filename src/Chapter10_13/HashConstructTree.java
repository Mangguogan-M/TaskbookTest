package Chapter10_13;

import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;

public class HashConstructTree extends JFrame{
	public HashConstructTree() {
		String[] s1 = {"A","B","C"};
		String[] s2 = {"a","b","c"};
		Hashtable<String, String[]> hashtable = new Hashtable<String, String[]>();
		hashtable.put("´óÐ´×ÖÄ¸", s1);
		hashtable.put("Ð¡Ð´×ÖÄ¸", s2);
		JTree tree = new JTree(hashtable);
		JScrollPane scrollpane = new JScrollPane();
		scrollpane.setViewportView(tree);
		add(scrollpane);
	}
	public static void main(String[] args) {
		HashConstructTree frame = new HashConstructTree();
		frame.setTitle("HashConstructTree");
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
