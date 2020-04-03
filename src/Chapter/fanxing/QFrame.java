package Chapter.fanxing;

import java.awt.event.*;
import javax.swing.*;

public class QFrame extends JFrame{
	public QFrame() {
		JButton jbtNew = new JButton("New");
		JPanel panel = new JPanel();
		panel.add(jbtNew);
		add(panel);
		jbtNew.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "单机了新建按钮！");
				System.out.println("Process New!");
			}
		});
	}
	public static void main(String[] args) {
		JFrame frame = new QFrame();
		frame.setTitle("按钮");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
	}
}
