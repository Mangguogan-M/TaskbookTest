package Chapter10_17;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class AddAndRemoveCells extends JFrame implements ActionListener{
	private JTable table;
	private DefaultTableModel defaultModel;
	
	public AddAndRemoveCells() {
		String[] name= {"Frist Name","Last Name","Sport","#of Years","Vegetarian"};//表头名称
		Object[][] data = {
				{"Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false)},
				{"John", "doe", "rowing", new Integer(3), new Boolean(true)},
				{"sue", "black", "knitting", new Integer(2), new Boolean(false)},
				{"jane", "white", "speed reading", new Integer(20), new Boolean(true)},
				{"joe", "brown", "pool", new Integer(10), new Boolean(false)}
		};
		defaultModel = new DefaultTableModel(data, name);
		table = new JTable(defaultModel);
		JScrollPane scrollpane = new JScrollPane(table);
		
		JButton button1 = new JButton("增加行");
		JButton button2 = new JButton("增加列");
		JButton button3 = new JButton("删除行");
		JButton button4 = new JButton("删除列");
		
		JPanel panel = new JPanel();
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		
		add(panel, BorderLayout.NORTH);
		add(scrollpane, BorderLayout.CENTER);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("增加列")) {
			defaultModel.addColumn("新增列");
		}
		if (e.getActionCommand().equals("增加行")) {
			defaultModel.addRow(new Vector());
		}
		if (e.getActionCommand().equals("删除列")) {
			int columncount = defaultModel.getColumnCount() - 1;
			if (columncount >= 0) {
				TableColumnModel columnModel = table.getColumnModel();
				TableColumn tableColumn = columnModel.getColumn(columncount);
				columnModel.removeColumn(tableColumn);
				defaultModel.setColumnCount(columncount);
			}
		}
		if (e.getActionCommand().equals("删除行")) {
			int rowcount = defaultModel.getRowCount() - 1;
			if (rowcount >= 0) {
				defaultModel.removeRow(rowcount);
				defaultModel.setRowCount(rowcount);
			}
		}
		table.revalidate();
	}
	public static void main(String[] args) {
		AddAndRemoveCells frame = new AddAndRemoveCells();
		frame.setSize(500, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
