package Chapter11;
/**
 * ���㲥
 * @author ����
 *�ͻ���
 */
import java.net.*;
public class UDPMulticastClient {
	static String destAddressStr = "224.0.0.1";
	static int destPortInt = 9998;
	static int TTLTime = 4;
	public static void main(String[] args) throws Exception {
		InetAddress destAddress = InetAddress.getByName(destAddressStr);
		if (!destAddress.isMulticastAddress()) {//�����ߵ�ַ�Ƿ�Ϊ�ಥ��ַ
			throw new Exception("��ַ���Ƕಥ��ַ");
		}
		int destPort = destPortInt;
		int TTL = TTLTime;
		MulticastSocket multicastSocket = new MulticastSocket();
		multicastSocket.setTimeToLive(TTL);
		byte[] sendMSG = "Hello".getBytes();
		DatagramPacket dp = new DatagramPacket(sendMSG, sendMSG.length, destAddress, destPort);
		multicastSocket.send(dp);
		multicastSocket.close();
	}

}
