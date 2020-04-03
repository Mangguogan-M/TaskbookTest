package Chapter11;
/**
 * 根据制定的域名查找IP地址
 * @author 马坤
 *
 */
import java.net.*;

public class GetIP {
	public static void main(String[] args) {
		try {
			System.out.println("本机IP为：" + InetAddress.getByName(args[0]));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

}
