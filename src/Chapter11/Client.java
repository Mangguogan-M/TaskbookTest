package Chapter11;
/**
 * ���߳�ͨ��
 * �ͻ��˳���
 * @author ����
 */
import java.net.*;
import java.io.*;

public class Client {
	public static void main(String[] args) {
		try {
			//���ӵ��������˿ں�5500
			Socket s = new Socket("localhost", 5500);
			//�����������������ᵽsocket��
			DataInputStream din = new DataInputStream(s.getInputStream());
			//����������������ӵ�socket��
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			System.out.println("�������ƽ��ֵ������bye������");
			String outStr, inStr;
			boolean NotEnd = true;
			BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
			//�������û������ݲ�����
			while (NotEnd) {
				outStr = bReader.readLine();
				dout.writeUTF(outStr);
				dout.flush();
				inStr = din.readUTF();
				if (!inStr.equals("bye")) {
					System.out.println("���ؽ����" + inStr);
				}else
					NotEnd = false;
			}
			din.close();
			dout.close();
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
