package Chapter11;
import java.io.IOException;
/**
 * ����ƶ����������л��IP
 * @author ����
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
					System.out.println("������" + ip + "����");
				}
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
}
