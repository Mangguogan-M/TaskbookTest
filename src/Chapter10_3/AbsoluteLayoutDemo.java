package Chapter10_3;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class AbsoluteLayoutDemo extends JFrame{
	private JButton button = new JButton("����");
	private JTextField textField = new JTextField("�ı���");
	public AbsoluteLayoutDemo() {
		setSize(500, 200);
		setLocation(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//����û�в��ֹ�����
		setLayout(null);
		//����������λ��
		textField.setBounds(20, 20, 200, 100);
		add(textField);
		//���ð�����λ��
		button.setLocation(300, 50);
		button.setSize(100, 20);
		add(button);
	}
	public static void main(String[] args) {
		AbsoluteLayoutDemo frame = new AbsoluteLayoutDemo();
		frame.setVisible(true);
	}
}
