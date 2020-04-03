package Chapter11;
/**
 * ʵ����ҳģ���½
 * @author ����
 */
import java.io.*;
import java.net.*;
public class Login {
	public static void main(String[] args) {
		try {
			//��֤��½����վ��URL
			URL url = new URL("http://localhost:8088/webapp/action.jsp");
			//�򿪸���ҳ��url����
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			//���ø���ҳ���ӿ����������������Ϣ
			conn.setDoOutput(true);
			//���������ύ�ķ�ʽ
			conn.setRequestMethod("POST");
			//����������Ͱ����û���������ĵ�½��֤��ѯ��
			conn.getOutputStream().write("username = a & password = a".getBytes());
			conn.getOutputStream().flush();
			conn.getOutputStream().close();
			//��ȡ��ҳ�еı�ͷ��Ϣ
			String cookieVal = conn.getHeaderField("Set-Cookie");
			//���ӷ�����
			conn.connect();
			conn.disconnect();
			
			//����ү��url
			url = new URL("http://localhost:8088/webapp/index.jsp");
			//�򿪸���ҳ��������
			conn = (HttpURLConnection) url.openConnection();
			
			conn.setRequestProperty("Cookie", cookieVal);
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = rd.readLine()) != null) {
				System.out.println(line);
			}
			rd.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
