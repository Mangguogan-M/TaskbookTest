package Chapter10_7;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class EventDemo extends JFrame{
	JButton button = new JButton("����");
	public EventDemo() {
		setSize(300, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//���ð����¼���ʹ����������
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//��ȡ�������İ���
				JButton clickedButton = (JButton)e.getSource();
				//�ı䱻���������ı���
				clickedButton.setText("�ұ�����");
			}
		});
		setLayout(new FlowLayout());
		add(button);
	}
	public static void main(String[] args) {
		EventDemo frame = new EventDemo();
		frame.setVisible(true);
	}
}
