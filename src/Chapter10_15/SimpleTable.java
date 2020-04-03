package Chapter10_15;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

public class SimpleTable extends JFrame{
	public SimpleTable() {
		String[] columnNames= {"Frist Name","Last Name","Sport","#of Years","Vegetarian"};//±íÍ·Ãû³Æ
		Object[][] data = {
				{"Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false)},
				{"John", "doe", "rowing", new Integer(3), new Boolean(true)},
				{"sue", "black", "knitting", new Integer(2), new Boolean(false)},
				{"jane", "white", "speed reading", new Integer(20), new Boolean(true)},
				{"joe", "brown", "pool", new Integer(10), new Boolean(false)}
		};
		JTable table = new JTable(data, columnNames);
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);
	}
	public static void main(String[] args) {
		SimpleTable frame = new SimpleTable();
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.setTitle("simple table");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
