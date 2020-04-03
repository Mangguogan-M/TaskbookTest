package Chapter11;
/**
 * 服务器线程程序UDP
 * @author 马坤
 */
import java.net.*;
import java.io.*;
import java.util.*;

import javax.xml.crypto.Data;
public class QuoteServserThread extends Thread{
	protected DatagramSocket socket = null;
	protected BufferedReader bReader = null;
	protected boolean moreQuotes = true;
	public QuoteServserThread() throws IOException{
		this("QuoteServerThread");
	}
	public QuoteServserThread(String name) throws IOException{
		super(name);
		socket = new DatagramSocket(4445);		//创建数据报Socket
		try {
			bReader = new BufferedReader(new FileReader("one.txt"));
		} catch (FileNotFoundException e) {
			System.err.println("Could not open quote file. Serving time instead.");
		}
	}
	@Override
	public void run() {
		while(moreQuotes) {
			try {
				byte[] buf = new byte[256];
				DatagramPacket packet = new DatagramPacket(buf, buf.length);
				//生成数据报，准备接受
				socket.receive(packet);
				String dString = null;
				if (bReader == null) {
					dString = new Date().toString();
				}else
					dString = getNextQuotes();
				buf = dString.getBytes();
				//发送响应给客户端，使用收到的数据报的address和port
				InetAddress address = packet.getAddress();
				int port = packet.getPort();
				packet = new DatagramPacket(buf, buf.length, address, port);	//创建发送数据报
				socket.send(packet); 			//
			}catch (IOException e) {
				e.printStackTrace();
				moreQuotes = false;
			}
		}
		socket.close();
	}
	//获取下一个需要发送的数据内容哦，                                        
	protected String getNextQuotes() {
		String returnValue = null;
		try {
			if ((returnValue = bReader.readLine()) == null) {
				bReader.close();
				moreQuotes = false;
				returnValue = "No more quotes.Goodbye";
			}
		} catch (IOException e) {
			returnValue = "IOException occurred in server";
		}
		return returnValue;
	}
}
