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
 * Description: 数制转换算法 顺序栈：先进后出
 * </p>
 * 
 * @author 马坤
 * @date Mar 25, 2019
 */
public class chap3_1 {
	public static void conversion(int N, int r) {
		sequenceStack<Integer> s = new sequenceStack<Integer>();
		/* 定义一个顺序栈 */
		while (N != 0) {
			s.push(N % r);
			N = N / r;
		}
		System.out.println("转换结果为：");
		while (!s.isEmpty()) {
			System.out.print(s.pop());
		}
	}

	public static void main(String[] args) {
		BufferedReader bReader;
		Integer num, radix;
		try {
			bReader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("输入一个十进制整数：");
			num = Integer.parseInt(bReader.readLine());
			System.out.print("转换进制：");
			radix = Integer.parseInt(bReader.readLine());
			conversion(num, radix);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
