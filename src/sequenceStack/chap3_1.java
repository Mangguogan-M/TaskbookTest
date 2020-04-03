/**  
* <p>Title: chap3_1.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.baidudu.com</p>  
* @author shenlan  
* @date Mar 25, 2019  
* @version 1.0  
*/
package sequenceStack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p>
 * Title: chap3_1
 * </p>
 * <p>
 * Description: ����ת���㷨 ˳��ջ���Ƚ����
 * </p>
 * 
 * @author ����
 * @date Mar 25, 2019
 */
public class chap3_1 {
	public static void conversion(int N, int r) {
		sequenceStack<Integer> s = new sequenceStack<Integer>();
		/* ����һ��˳��ջ */
		while (N != 0) {
			s.push(N % r);
			N = N / r;
		}
		System.out.println("ת�����Ϊ��");
		while (!s.isEmpty()) {
			System.out.print(s.pop());
		}
	}

	public static void main(String[] args) {
		BufferedReader bReader;
		Integer num, radix;
		try {
			bReader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("����һ��ʮ����������");
			num = Integer.parseInt(bReader.readLine());
			System.out.print("ת�����ƣ�");
			radix = Integer.parseInt(bReader.readLine());
			conversion(num, radix);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
