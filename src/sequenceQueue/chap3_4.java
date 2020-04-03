/**  
* <p>Title: chap3_4.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.baidudu.com</p>  
* @author shenlan  
* @date Mar 25, 2019  
* @version 1.0  
*/ 
package sequenceQueue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**  
* <p>Title: chap3_4</p>  
* <p>Description: 银行业务模拟</p>  
* @author 马坤  
* @date Mar 25, 2019  
*/
public class chap3_4 {
	public static void main(String[] args) {
		int dwait = 0, clock = 0, wait = 0, count = 0, have = 0, finish;
		int arr, tre;
		QNode curr, temp;
		StringTokenizer r;
		sequenceQueue<QNode> wa = new sequenceQueue<QNode>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("customer.txt"));
			String s;
			s = br.readLine();
			r = new StringTokenizer(s);
			arr = Integer.parseInt(r.nextToken());
			tre = Integer.parseInt(r.nextToken());
			temp = new QNode(arr, tre);
			while (wa.size() != 0 || s != null) {
				if (wa.size() == 0 && s != null) {
					dwait += temp.arrive - clock;
					clock = temp.arrive;
					wa.EnQueue(temp);
					s = br.readLine();
					if (s != null) {
						r = new StringTokenizer(s);
						arr = Integer.parseInt(r.nextToken());
						tre = Integer.parseInt(r.nextToken());
						temp = new QNode(arr, tre);
					}
				}
				count++;
				curr = wa.DeQueue();
				wait += clock-curr.arrive;
				finish = clock + curr.treat;
				while (s != null && temp.arrive <= finish) {
					wa.EnQueue(temp);
					s = br.readLine();
					r = new StringTokenizer(s);
					arr = Integer.parseInt(r.nextToken());
					tre = Integer.parseInt(r.nextToken());
					temp = new QNode(arr, tre);
				}
				clock = finish;
			}
		} catch (IOException e) {
			System.out.println("文件访问异常！" + e);
			e.printStackTrace();
		}
		System.out.println("业务员等待时间           客户平均等待时间");
		System.out.println(dwait + "      " + (double)wait/count);
		System.out.println("模拟总时间    客户人数    总等待时间");
		System.out.println(clock + "   " + count + "    " + wait);
	}
}
