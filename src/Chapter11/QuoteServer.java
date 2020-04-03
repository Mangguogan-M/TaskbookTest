package Chapter11;
/**
 * 服务端主程序UDP
 * @author 马坤
 */
public class QuoteServer {
	public static void main(String[] args) throws java.io.IOException{
		new QuoteServserThread().start();
	}

}
