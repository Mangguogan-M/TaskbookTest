package Chapter10_5;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class borderLayoutDemo extends JFrame{
	private JButton north = new JButton("北");
	private JButton south = new JButton("南");
	private JButton east = new JButton("东");
	private JButton west = new JButton("西");
	private JButton center = new JButton("中");
	public borderLayoutDemo() {
		setSize(300, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置布局方式为borderlayout
		setLayout(new BorderLayout());
		//添加按键，任何对组件进行的设置都会失效
		add(north,BorderLayout.NORTH);
		add(south, BorderLayout.SOUTH);
		add(east, BorderLayout.EAST);
		add(west, BorderLayout.WEST);
		add(center, BorderLayout.CENTER);
	}
	public static void main(String[] args) {
		borderLayoutDemo frame = new borderLayoutDemo();
		frame.setVisible(true);
	}
	
}
