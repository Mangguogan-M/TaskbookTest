package Chapter11;
/**
 * 但客户端Socket通信
 * 服务器端
 * @author 马坤
 *
 */
import java.net.*;
import java.io.*;

public class chatServer {
	public static void main(String[] args) {
		ServerSocket s = null;
		Socket s1;
		String sendString = "Hello Net World!";
		OutputStream out;
		DataOutputStream dout;
		try {
			s = new ServerSocket(5600);
		} catch (IOException e) {
			e.printStackTrace();
		}
		while (true) {
			try {
				s1 = s.accept();
				out = s1.getOutputStream();
				dout = new DataOutputStream(out);
				dout.writeUTF(sendString);
				out.close();
				s1.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
