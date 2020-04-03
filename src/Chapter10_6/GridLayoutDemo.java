package Chapter10_6;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridLayoutDemo extends JFrame{
	private JButton button1 = new JButton("����1");
	private JButton button2 = new JButton("����2");
	private JButton button3 = new JButton("����3");
	private JButton button4 = new JButton("����4");
	public GridLayoutDemo() {
		setSize(300, 300);
		setLocation(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//���ò��ַ�ʽΪgridlayout--��������--���񲼾�
		setLayout(new GridLayout(2, 2));
		add(button1);
		add(button2);
		add(button3);
		add(button4);
	}
	public static void main(String[] args) {
		GridLayoutDemo frame = new GridLayoutDemo();
		frame.setVisible(true);
	}
	
}
