package Chapter11;
/**
 * ��ͻ���socketͨ��
 * �������߳�
 * @author ����
 */
import java.net.*;
import java.io.*;

public class ServerThread extends Thread{
	private Socket s;
	private DataInputStream din;
	private DataOutputStream dout;
	//�ڹ��췽����Ϊÿһ��socket����ʻ�������
	public ServerThread(Socket socket) throws IOException {
		super();
		s = socket;
		din = new DataInputStream(s.getInputStream());
		dout = new DataOutputStream(s.getOutputStream());
		start();//����run��������
	}
	//��run������������ͻ���ͨ��
	@Override
	public void run() {
		try {
			String str;
			double result, zhi;
			boolean NotEnd = true;
			while (NotEnd) {
				str = din.readUTF();
				if (!str.equals("bye")) {
					zhi = Double.parseDouble(str);
					System.out.println("���յ���ֵ��" + zhi);
					result = zhi * zhi;
					str = Double.toString(result);
					dout.writeUTF(str);
					dout.flush();
					System.out.println("ƽ��ֵ��" + str + "�Ѿ�����");
				}else {
					NotEnd = false;
					dout.writeUTF("bye");
					dout.flush();
				}
			}
			din.close();
			dout.close();
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
