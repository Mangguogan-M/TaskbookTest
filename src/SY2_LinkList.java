import java.util.Scanner;

/**
 * @author ����
 * @date May 11, 2019
 * @version 1.0
 */

public class SY2_LinkList {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		LinkList L = new LinkList();
		System.out.println("�����������еĸ�������Ԫ��(0Ϊ����):");
		L.creat();
		System.out.println("�����ĵ�����Ϊ:");
		L.display();
		System.out.println("������������λ��i(0��curLen):");
		int i = sc.nextInt();
		System.out.println("����������������ֵx:");
		int x = sc.nextInt();
		L.insert(i, x);
		System.out.println("����������Ϊ:");
		L.display();
		System.out.println("�������ɾ��Ԫ�ص�λ��(0��curLen-1):");
		i = sc.nextInt();
		L.remove(i);
		System.out.println("ɾ���������Ϊ:");
		L.display();
		System.out.println("����������ҵ�����Ԫ�ص�λ���(0��curLen-1):");
		i = sc.nextInt();
		Object o = L.get(i);
		System.out.println("�˵������е�" + i + "����������Ԫ��ֵΪ" + o);

	}

}
