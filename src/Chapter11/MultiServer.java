package Chapter11;
/**
 * ���߳�ͨ��
 * ��������
 * @author ����
 */
import java.net.*;
import java.io.*;

public class MultiServer {
	public static void main(String[] args) {
		try {
			System.out.println("�ȴ�����");
			ServerSocket serverSocket = new ServerSocket(5500);
			Socket s = null;
			while (true) {
				//�ȴ��ͻ��˵�����
				s = serverSocket.accept();
				//ÿ����������һ���س�������
				new ServerThread(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
