package Chapter10_2;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

public class AWTFrame extends Frame{
	private Button button = new Button("����");
	public AWTFrame() {
		setSize(300, 300);
		setLocation(400, 400);
		setTitle("����һ��");
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}
		});
		setLayout(new FlowLayout());		//���ò��ֹ�����
		//��Ӱ����¼�
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				JOptionPane.showMessageDialog(null, "�����˰���");
			}
		});
		add(button);				//����˰���
	}
	public static void main(String[] args) {
		AWTFrame frame = new AWTFrame();
		frame.setVisible(true);
	}
}
