package Chapter11;
/**
 * 多线程通信
 * 服务器端
 * @author 马坤
 */
import java.net.*;
import java.io.*;

public class MultiServer {
	public static void main(String[] args) {
		try {
			System.out.println("等待连接");
			ServerSocket serverSocket = new ServerSocket(5500);
			Socket s = null;
			while (true) {
				//等待客户端的请求
				s = serverSocket.accept();
				//每次请求都启动一个县城来处理
				new ServerThread(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
