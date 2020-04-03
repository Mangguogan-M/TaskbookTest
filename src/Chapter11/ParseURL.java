package Chapter11;

import java.net.*;
public class ParseURL {

	public static void main(String[] args) throws Exception{
		URL cqu = new URL("http://www.cqu.edu.cn/index.html#top");
		System.out.println("protocol = " + cqu.getProtocol());
		System.out.println("host = " + cqu.getHost());
		System.out.println("fileName = " + cqu.getFile());
		System.out.println("port = " + cqu.getPort());
		System.out.println("ref = " + cqu.getRef());
	}

}
