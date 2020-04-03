/**  
* <p>Title: SY8_HashSearch_1.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) May 5, 2019</p>  
* @author ����  
* @date May 5, 2019  
* @version 1.0  
*/
package Search;

import java.util.Scanner;

//������
public class SY8_HashSearch_1 {
	static HashTable T = null;

	// ���������ҵĹ�ϣ��
	public static void createHashtable() throws Exception {
		T = new HashTable(20);
		Scanner sc = new Scanner(System.in);
		System.out.print("����������ҵĹؼ��ֵĸ���:");
		int n = sc.nextInt();
		System.out.print("��������ұ��еĹؼ�������:");
		for (int i = 0; i < n; i++) { // ����ؼ�������,�������ϣ����
			T.hashInsert(sc.nextInt());
		}
	}

	public static void main(String[] args) throws Exception {
		System.out.println("---������ϣ��---");
		createHashtable();
		System.out.println("�����Ĺ�ϣ��Ϊ:");
		T.Hashdisplay();
		System.out.print("����������ҵĹؼ���:");
		Scanner sc = new Scanner(System.in);
		int key = sc.nextInt();
		RecordNode p = T.hashSearch(key);
		if ((p.getKey()).compareTo(key) == 0)
			System.out.println(" ���ҳɹ�!");
		else
			System.out.println(" ����ʧ��!");
	}
}
