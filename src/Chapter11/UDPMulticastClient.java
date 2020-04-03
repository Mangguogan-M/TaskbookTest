package Chapter11;
/**
 * 多点广播
 * @author 马坤
 *客户端
 */
import java.net.*;
public class UDPMulticastClient {
	static String destAddressStr = "224.0.0.1";
	static int destPortInt = 9998;
	static int TTLTime = 4;
	public static void main(String[] args) throws Exception {
		InetAddress destAddress = InetAddress.getByName(destAddressStr);
		if (!destAddress.isMulticastAddress()) {//检验者地址是否为多播地址
			throw new Exception("地址不是多播地址");
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
