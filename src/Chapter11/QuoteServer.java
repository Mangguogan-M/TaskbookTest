package Chapter11;
/**
 * �����������UDP
 * @author ����
 */
public class QuoteServer {
	public static void main(String[] args) throws java.io.IOException{
		new QuoteServserThread().start();
	}

}
