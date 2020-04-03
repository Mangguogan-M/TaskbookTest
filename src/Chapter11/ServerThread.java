package Chapter11;
/**
 * 多客户端socket通信
 * 服务器线程
 * @author 马坤
 */
import java.net.*;
import java.io.*;

public class ServerThread extends Thread{
	private Socket s;
	private DataInputStream din;
	private DataOutputStream dout;
	//在构造方法中为每一个socket连接驶入输出流
	public ServerThread(Socket socket) throws IOException {
		super();
		s = socket;
		din = new DataInputStream(s.getInputStream());
		dout = new DataOutputStream(s.getOutputStream());
		start();//启动run（）方法
	}
	//在run（）方法中与客户端通信
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
					System.out.println("接收到的值：" + zhi);
					result = zhi * zhi;
					str = Double.toString(result);
					dout.writeUTF(str);
					dout.flush();
					System.out.println("平方值：" + str + "已经发送");
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
