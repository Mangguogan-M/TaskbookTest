package Chapter11;
import java.io.IOException;
/**
 * 获得制定内网中所有活动的IP
 * @author 马坤
 *
 */
import java.net.InetAddress;
import java.net.UnknownHostException;
public class TestAllIp {
	public static void main(String[] args) {
		String ip = "172.20.52.";
		for (int i = 1; i < 255; i++) {
			String host = ip + i;
			new ThreadIP(host).start();
		}
	}
	static class ThreadIP extends Thread{
		String ip = null;
		public ThreadIP(String ip) {
			super();
			this.ip = ip;
		}
		@Override
		public void run() {
			super.run();
			InetAddress ia;
			try {
				ia = InetAddress.getByName(ip);
				boolean bool = ia.isReachable(1500);
				if(bool) {
					System.out.println("主机：" + ip + "可用");
				}
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
}
