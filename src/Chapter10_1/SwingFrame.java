package Chapter10_1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SwingFrame extends JFrame{
	private JButton button = new JButton("����");
	public SwingFrame() {
		setSize(300, 300);			//���ô����С
		setLocation(400, 400);		//���ô���λ��
		setTitle("����һ��");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//���ô���Ĭ�Ϲر��¼�
		setLayout(new FlowLayout());						//���ò��ֹ�����
		//��Ӱ����¼�
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "�����˰�����");
			}
		});
		add(button);
	}
	public static void main(String[] args) {
		SwingFrame frame = new SwingFrame();
		frame.setVisible(true);
	}
}
