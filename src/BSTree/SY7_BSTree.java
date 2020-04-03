/**  
* <p>Title: SY7_BSTree.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) Apr 28, 2019</p>  
* @author 马坤  
* @date Apr 28, 2019  
* @version 1.0  
*/
package BSTree;

import java.util.Scanner;

public class SY7_BSTree {
	public static void main(String args[]) {
		BSTree bstree = new BSTree();
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入二叉排序树的结点个数:");
		int n = sc.nextInt();
		System.out.print("请输入结点的关键字序列:");
		for (int i = 0; i < n; i++) { // 输入关键字序列
			bstree.insertBST(sc.nextInt());
		}
		System.out.println("\n创建的二叉排序树的中序遍历序列为：  ");
		bstree.inOrderTraverse(bstree.getRoot());
		System.out.println();
		System.out.println("请输入待查找的关键字：  ");
		int key = sc.nextInt();
		BiTreeNode found = bstree.searchBST(key);
		if (found != null) {
			System.out.println("查找成功!");
		} else {
			System.out.println("查找失败!");
		}
	}
}
