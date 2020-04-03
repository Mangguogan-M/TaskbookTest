package Chapter11;
/**
 * 单客户端Socket通信
 * 客户端
 * @author 马坤
 *
 */
import java.net.*;
import java.io.*;

public class chatClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket s1;
		InputStream in;
		DataInputStream din;
		s1 = new Socket("localhost", 5600);
		in = s1.getInputStream();
		din = new DataInputStream(in);
		String str = new String(din.readUTF());
		System.out.println(str);
		in.close();
		s1.close();
	}

}
