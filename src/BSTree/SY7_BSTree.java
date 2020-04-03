/**  
* <p>Title: SY7_BSTree.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) Apr 28, 2019</p>  
* @author ����  
* @date Apr 28, 2019  
* @version 1.0  
*/
package BSTree;

import java.util.Scanner;

public class SY7_BSTree {
	public static void main(String args[]) {
		BSTree bstree = new BSTree();
		Scanner sc = new Scanner(System.in);
		System.out.print("����������������Ľ�����:");
		int n = sc.nextInt();
		System.out.print("��������Ĺؼ�������:");
		for (int i = 0; i < n; i++) { // ����ؼ�������
			bstree.insertBST(sc.nextInt());
		}
		System.out.println("\n�����Ķ����������������������Ϊ��  ");
		bstree.inOrderTraverse(bstree.getRoot());
		System.out.println();
		System.out.println("����������ҵĹؼ��֣�  ");
		int key = sc.nextInt();
		BiTreeNode found = bstree.searchBST(key);
		if (found != null) {
			System.out.println("���ҳɹ�!");
		} else {
			System.out.println("����ʧ��!");
		}
	}
}
