package Chapter10_5;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class borderLayoutDemo extends JFrame{
	private JButton north = new JButton("��");
	private JButton south = new JButton("��");
	private JButton east = new JButton("��");
	private JButton west = new JButton("��");
	private JButton center = new JButton("��");
	public borderLayoutDemo() {
		setSize(300, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//���ò��ַ�ʽΪborderlayout
		setLayout(new BorderLayout());
		//��Ӱ������κζ�������е����ö���ʧЧ
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
