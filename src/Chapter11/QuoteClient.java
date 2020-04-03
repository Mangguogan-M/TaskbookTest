package Chapter11;
/**
 * �򵥵�UDPͨ��
 * �ͻ���
 * @author ����
 */
import java.net.*;
import java.io.*;
import java.util.*;
public class QuoteClient {
	public static void main(String[] args) throws SocketException, IOException {
		if (args.length != 1) {
			System.out.println("Usage: java QuoteClient<hostname>");
			return;
		}
		DatagramSocket socket = new DatagramSocket();	//�������ݱ�Socket
		//��������
		byte[] buf = new byte[256];
		InetAddress address = InetAddress.getByName(args[0]);		//��ȡĿ���ַ
		DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 4445);
		//�����������ݱ�
		socket.send(packet);
		//��ȡ��Ӧ
		packet = new DatagramPacket(buf, buf.length);		//�����������ݱ�
		socket.receive(packet);
		//��ʾ��Ӧ
		String received = new String(packet.getData());
		System.out.println("Quote of the Moment:" + received);
		socket.close();
	}
}
