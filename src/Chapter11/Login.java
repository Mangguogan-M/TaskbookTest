package Chapter11;
/**
 * 实现网页模拟登陆
 * @author 马坤
 */
import java.io.*;
import java.net.*;
public class Login {
	public static void main(String[] args) {
		try {
			//验证登陆的网站的URL
			URL url = new URL("http://localhost:8088/webapp/action.jsp");
			//打开该网页的url连接
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			//设置该网页连接可以向服务器发送信息
			conn.setDoOutput(true);
			//设置请求提交的方式
			conn.setRequestMethod("POST");
			//向服务器发送包含用户名和密码的登陆认证查询串
			conn.getOutputStream().write("username = a & password = a".getBytes());
			conn.getOutputStream().flush();
			conn.getOutputStream().close();
			//获取网页中的表头信息
			String cookieVal = conn.getHeaderField("Set-Cookie");
			//连接服务器
			conn.connect();
			conn.disconnect();
			
			//著王爷的url
			url = new URL("http://localhost:8088/webapp/index.jsp");
			//打开该网页的来连接
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
