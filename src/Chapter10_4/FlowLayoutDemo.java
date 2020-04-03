package Chapter10_4;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutDemo extends JFrame{
	private JButton button1 = new JButton("按键1");
	private JButton button2 = new JButton("按键2");
	private JButton button3 = new JButton("按键3");
	private JButton button4 = new JButton("按键4");
	public FlowLayoutDemo() {
		setSize(300,150);
		setLocation(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置布局方式为flowlayout
		setLayout(new FlowLayout());
		add(button1);
		add(button2);
		add(button3);
		add(button4);
	}
	public static void main(String[] args) {
		FlowLayoutDemo frame = new FlowLayoutDemo();
		frame.setVisible(true);
	}
}
