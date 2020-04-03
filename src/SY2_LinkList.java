import java.util.Scanner;

/**
 * @author 马坤
 * @date May 11, 2019
 * @version 1.0
 */

public class SY2_LinkList {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		LinkList L = new LinkList();
		System.out.println("请输入链表中的各个数据元素(0为结束):");
		L.creat();
		System.out.println("建立的单链表为:");
		L.display();
		System.out.println("请输入待插入的位置i(0～curLen):");
		int i = sc.nextInt();
		System.out.println("请输入待插入的数据值x:");
		int x = sc.nextInt();
		L.insert(i, x);
		System.out.println("插入后的链表为:");
		L.display();
		System.out.println("请输入待删除元素的位置(0～curLen-1):");
		i = sc.nextInt();
		L.remove(i);
		System.out.println("删除后的链表为:");
		L.display();
		System.out.println("请输入待查找的数据元素的位序号(0～curLen-1):");
		i = sc.nextInt();
		Object o = L.get(i);
		System.out.println("此单链表中第" + i + "个结点的数据元素值为" + o);

	}

}
