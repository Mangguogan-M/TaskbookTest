package Chapter11;
/**
 * 简单的UDP通信
 * 客户端
 * @author 马坤
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
		DatagramSocket socket = new DatagramSocket();	//创建数据报Socket
		//发送请求
		byte[] buf = new byte[256];
		InetAddress address = InetAddress.getByName(args[0]);		//获取目标地址
		DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 4445);
		//创建发送数据报
		socket.send(packet);
		//获取响应
		packet = new DatagramPacket(buf, buf.length);		//创建接受数据报
		socket.receive(packet);
		//显示相应
		String received = new String(packet.getData());
		System.out.println("Quote of the Moment:" + received);
		socket.close();
	}
}
