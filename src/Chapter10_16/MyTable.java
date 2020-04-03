package Chapter10_16;

import javax.swing.table.AbstractTableModel;

public class MyTable extends AbstractTableModel{
	String[] columnNames= {"Frist Name","Last Name","Sport","#of Years","Vegetarian"};//±íÍ·Ãû³Æ
	Object[][] data = {
			{"Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false)},
			{"John", "doe", "rowing", new Integer(3), new Boolean(true)},
			{"sue", "black", "knitting", new Integer(2), new Boolean(false)},
			{"jane", "white", "speed reading", new Integer(20), new Boolean(true)},
			{"joe", "brown", "pool", new Integer(10), new Boolean(false)}
	};
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
	
	@Override
	public int getRowCount() {
		return data.length;
	}
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data[rowIndex][columnIndex];
	}
	
}
