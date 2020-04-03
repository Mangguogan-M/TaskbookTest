package Chapter11;
/**
 * 多线程通信
 * 客户端程序
 * @author 马坤
 */
import java.net.*;
import java.io.*;

public class Client {
	public static void main(String[] args) {
		try {
			//连接到本机，端口号5500
			Socket s = new Socket("localhost", 5500);
			//将数据输入流来凝结到socket上
			DataInputStream din = new DataInputStream(s.getInputStream());
			//将数据输出流来连接到socket上
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			System.out.println("输入待求平方值，输入bye结束：");
			String outStr, inStr;
			boolean NotEnd = true;
			BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
			//反复度用户的数据并计算
			while (NotEnd) {
				outStr = bReader.readLine();
				dout.writeUTF(outStr);
				dout.flush();
				inStr = din.readUTF();
				if (!inStr.equals("bye")) {
					System.out.println("返回结果：" + inStr);
				}else
					NotEnd = false;
			}
			din.close();
			dout.close();
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
