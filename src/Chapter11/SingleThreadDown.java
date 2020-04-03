package Chapter11;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SingleThreadDown extends JFrame implements ActionListener{
	private final JPanel panel = new JPanel();
	private final JLabel label1 = new JLabel("������Դ�ĵ��߳����أ�");
	private final JLabel label2 = new JLabel("������Դ����ַ��");
	JButton StartButton = new JButton("������ʼ����");
	JButton resetButton = new JButton("���");
	JButton exitButton = new JButton("�˳�");
	JTextField urlFiled = new JTextField(20);
	
	public SingleThreadDown() {
		panel.setLayout(new FlowLayout());
		label1.setFont(new Font("�ź�", Font.BOLD, 15));
		panel.add(label1);
		panel.add(label2);
		panel.add(urlFiled);
		panel.add(StartButton);
		panel.add(resetButton);
		panel.add(exitButton);
		setContentPane(panel);
		StartButton.addActionListener(this);
		resetButton.addActionListener(this);
		exitButton.addActionListener(this);
		setSize(400, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void doenload(String address) throws Exception{
		URL url = new URL(address);
		URLConnection urlcon = url.openConnection();
		urlcon.connect();
		InputStream in = urlcon.getInputStream();
		String filePath = url.getFile();
		int pos = filePath.lastIndexOf("/");
		String fileName = filePath.substring(pos + 1);
		FileOutputStream out = new FileOutputStream("D:\\" + fileName);
		byte[] bytes = new byte[1014];
		int len = in.read();
		while(len != -1) {
			out.write(bytes, 0, len);
			len = in.read();
		}
		out.close();in.close();
		JOptionPane.showMessageDialog(this, "�������");
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == StartButton) {
			if ("".equals(urlFiled.getText())) {
				JOptionPane.showMessageDialog(this, "��������Դ��ַ");
			}
			String url = urlFiled.getText();
			try {
				doenload(url);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "��Դ��ַ�������飬лл��");
				e2.printStackTrace();
			}
		}else if (e.getSource() == resetButton) {
			urlFiled.setText("");
		}else {
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new SingleThreadDown();
	}
	
	
}
