/**  
* <p>Title: chap3_2.java</p>  
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
* <p>Title: chap3_2</p>  
* <p>Description: �����ж�</p>  
* @author ����  
* @date Mar 25, 2019  
*/
public class chap3_2 {
	public static boolean matching(char []exp) {
		int state = 1, i = 0;
		sequenceStack<Character> s = new sequenceStack<Character>();
		while(i < exp.length && state == 1) {
			switch(exp[i]) {
			case '[':
			case '(':
			{
				s.push(exp[i]);
				i++;
				break;
			}
			case ']':
			{
				if (!s.isEmpty()) {
					if (s.getHead() == '[') {
						s.pop();
						i++;
					}
					else state = 0;
				}
				else state = 0;
				break;
			}
			case ')':
			{
				if (!s.isEmpty()) {
					if (s.getHead() == '(') {
						s.pop();
						i++;
					}
					else state = 0;
				}
				else state = 0;
				break;
			}
			default: {i++; break;}
			}
		}
		if(s.isEmpty() && state == 1)
			return true;
		else return false;
	}
	public static void main(String[] args) {
		BufferedReader bReader;
		String s;
		char[] us;
		try {
			bReader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("����һ�����У�����[]�ı��ʽ��");
			s = bReader.readLine();
			us = s.toCharArray();
			if (matching(us)) {
				System.out.println("���ʽ������ƥ��");
			}else {
				System.out.println("���ʽ�����Ų�ƥ��");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
