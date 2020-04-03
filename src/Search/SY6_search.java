/**  
* <p>Title: SY6_search.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) May 5, 2019</p>  
* @author ����  
* @date May 5, 2019  
* @version 1.0  
*/
package Search;

import java.util.Scanner;

//������
public class SY6_search {
	static SeqList ST = null;

	// ���������ҵ�˳���
	public static void createSearchList() throws Exception {
		ST = new SeqList(20);
		Scanner sc = new Scanner(System.in);
		System.out.print("��������ұ�ı�:");
		int n = sc.nextInt();
		KeyType[] k = new KeyType[n];
		System.out.print("��������ұ��еĹؼ�������:");
		for (int i = 0; i < n; i++) { // ����ؼ�������
			k[i] = new KeyType(sc.nextInt());
		}
		for (int i = 1; i < n + 1; i++) { // ������¼˳���,0�Ŵ洢��Ԫ�����Ԫ��
			RecordNode r = new RecordNode(k[i - 1]);
			ST.insert(i, r);
		}
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		KeyType key1, key2;
		while (true) {
			System.out.println(" 1--˳�����    2--���ֲ���    3--�˳�");
			System.out.print("������ѡ��(1-3):");
			int i = sc.nextInt();
			switch (i) {
			case 1:
				System.out.println("����˳����ұ�");
				createSearchList();
				System.out.print("���������������ҵĹؼ���:");
				key1 = new KeyType(sc.nextInt());
				key2 = new KeyType(sc.nextInt());
				System.out.println("seqSearch(" + key1.getKey() + ")=" + ST.seqSearch(key1));
				System.out.println("seqSearch(" + key2.getKey() + ")=" + ST.seqSearch(key2));
				break;
			case 2:
				System.out.println("���������˳����ұ�");
				createSearchList();
				System.out.print("���������������ҵĹؼ���:");
				key1 = new KeyType(sc.nextInt());
				key2 = new KeyType(sc.nextInt());
				System.out.println("binarySearch(" + key1.getKey() + ")=" + ST.binarySearch(key1));
				System.out.println("binarySearch(" + key2.getKey() + ")=" + ST.binarySearch(key2));
				break;
			case 3:
				return;
			}
		}
	}
}
