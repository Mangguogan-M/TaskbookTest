package Chapter11;
/**
 * 通过URL和URLConnection访问WWW资源
 * @author 马坤
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
		System.out.println("获取到的响应长度：");
		System.out.println(conn.getContentLength());
		System.out.println("获取到的响应类型：");
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
