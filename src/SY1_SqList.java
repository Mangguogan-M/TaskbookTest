import java.util.Scanner;

/**
 * @author ����
 * @date May 11, 2019
 * @version 1.0
 */

public class SY1_SqList {
	public static void main(String[] args) throws Exception {
		SqList L = new SqList(20); // ����һ���洢����Ϊ0�Ŀ�˳���
		Scanner sc = new Scanner(System.in);
		System.out.println("������˳���ĳ���:");
		int n = sc.nextInt();
		System.out.println("������˳����еĸ�������Ԫ��:");
		for (int i = 0; i < n; i++)
			L.insert(i, sc.nextInt());
		System.out.println("������������λ��i(0��curLen):");
		int i = sc.nextInt();
		System.out.println("����������������ֵx:");
		int x = sc.nextInt();
		L.insert(i, x);
		System.out.println("������˳���Ϊ:");
		L.display();
		System.out.println("�������ɾ��Ԫ�ص�λ��(0��curLen-1):");
		i = sc.nextInt();
		L.remove(i);
		System.out.println("ɾ�����˳���Ϊ:");
		L.display();
		System.out.println("����������ҵ�����Ԫ��:");
		x = sc.nextInt();
		int order = L.indexOf(x);
		if (order == -1)
			System.out.println("��˳����в�����ֵΪ" + x + "������Ԫ��!");
		else
			System.out.println("ֵΪ" + x + "Ԫ����˳����еĵ�" + order + "��λ����");
	}

}
