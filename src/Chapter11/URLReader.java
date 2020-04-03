package Chapter11;
/**
 * ͨ��URL��URLConnection����WWW��Դ
 * @author ����
 *
 */
import java.util.*;
import java.net.*;
import java.io.*;

public class URLReader {
	public static void main(String[] args) throws Exception{
		URL obj = new URL("http://www.cqu.edu.cn/");
		BufferedReader in = new BufferedReader(new InputStreamReader(obj.openStream()));
		String inputLine;
		//FileWriter fout = new FileWriter("f.txt");
		while((inputLine = in.readLine()) != null)
			System.out.println(inputLine);
			//fout.write(inputLine);
		//fout.close();
		in.close();
		
		URLConnection conn = obj.openConnection();
		conn.connect();
		System.out.println("��ȡ������Ӧ���ȣ�");
		System.out.println(conn.getContentLength());
		System.out.println("��ȡ������Ӧ���ͣ�");
		System.out.println(conn.getContentType());
		in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line;
		String result = null;
		while((line = in.readLine()) != null) {
			result += line;
		}
		System.out.println(result);
		in.close();
	}

}
