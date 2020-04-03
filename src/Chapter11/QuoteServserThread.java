package Chapter11;
/**
 * �������̳߳���UDP
 * @author ����
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
		socket = new DatagramSocket(4445);		//�������ݱ�Socket
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
				//�������ݱ���׼������
				socket.receive(packet);
				String dString = null;
				if (bReader == null) {
					dString = new Date().toString();
				}else
					dString = getNextQuotes();
				buf = dString.getBytes();
				//������Ӧ���ͻ��ˣ�ʹ���յ������ݱ���address��port
				InetAddress address = packet.getAddress();
				int port = packet.getPort();
				packet = new DatagramPacket(buf, buf.length, address, port);	//�����������ݱ�
				socket.send(packet); 			//
			}catch (IOException e) {
				e.printStackTrace();
				moreQuotes = false;
			}
		}
		socket.close();
	}
	//��ȡ��һ����Ҫ���͵���������Ŷ��                                        
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
