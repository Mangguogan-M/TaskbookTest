/**  
* <p>Title: bubbleSort.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) May 5, 2019</p>  
* @author ����  
* @date May 5, 2019  
* @version 1.0  
*/
package Sort;

import java.util.Scanner;

//������
public class SY9_Sort_1 {
	static SeqList ST = null;

	// �����������˳���
	public static void createSearchList() throws Exception {
		ST = new SeqList(20);
		Scanner sc = new Scanner(System.in);
		System.out.print("�����������ı�:");
		int n = sc.nextInt();
		KeyType[] k = new KeyType[n];
		System.out.print("������������еĹؼ�������:");
		for (int i = 0; i < n; i++) { // ����ؼ�������
			k[i] = new KeyType(sc.nextInt());
		}
		for (int i = 0; i < n; i++) { // ����˳�������
			RecordNode r = new RecordNode(k[i]);
			ST.insert(i, r);
		}
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		// System.out.println("����˳����ұ�");
		// createSearchList();
		while (true) {
			System.out.println(" 1--ֱ�Ӳ�������    2--ð������    3--��ѡ������    4--�˳�");
			System.out.print("������ѡ��(1-4):");
			int i = sc.nextInt();
			switch (i) {
			case 1:
				System.out.println("---ֱ�Ӳ�������---");
				System.out.println("����˳�������");
				createSearchList();
				ST.insertSort();
				System.out.print("������:");
				ST.display();
				System.out.println("�Ƚϴ���Ϊ:" + ST.cm[0].getCpn());
				System.out.println("�ƶ�����Ϊ:" + ST.cm[0].getMvn());
				break;
			case 2:
				System.out.println("---ð������---");
				System.out.println("����˳�������");
				createSearchList();
				ST.bubbleSort();
				System.out.print("������:");
				ST.display();
				System.out.println("�Ƚϴ���Ϊ:" + ST.cm[1].getCpn());
				System.out.println("�ƶ�����Ϊ:" + ST.cm[1].getMvn());
				break;
			case 3:
				System.out.print("---��ѡ������---");
				System.out.println("����˳�������");
				createSearchList();
				ST.selectSort();
				System.out.print("������:");
				ST.display();
				System.out.println("�Ƚϴ���Ϊ:" + ST.cm[2].getCpn());
				System.out.println("�ƶ�����Ϊ:" + ST.cm[2].getMvn());
				break;
			case 4:
				return;
			}
		}
	}
}
