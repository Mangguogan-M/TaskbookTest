package Chapter11;
/**
 * �����ƶ�����������IP��ַ
 * @author ����
 *
 */
import java.net.*;

public class GetIP {
	public static void main(String[] args) {
		try {
			System.out.println("����IPΪ��" + InetAddress.getByName(args[0]));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

}
