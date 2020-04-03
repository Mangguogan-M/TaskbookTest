/**  
* <p>Title: RootTest.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) Apr 27, 2019</p>  
* @author 马坤  
* @date Apr 27, 2019  
* @version 1.0  
*/ 
package BinaryTree;

import java.util.Scanner;

public class RootTest {
	public static void main(String[] args){
		System.out.println("系统自定义的二叉树");
		BinaryTree<String> rootNodes = new BinaryTree<String>("A");
		rootNodes.insertLeft("H", rootNodes.root);
		rootNodes.insertLeft("D", rootNodes.root);
		rootNodes.insertRight("I", rootNodes.root.lChild);
//		System.out.println(rootNodes.root.lChild.rChild.getData());
		rootNodes.insertLeft("B", rootNodes.root);
		rootNodes.insertRight("E", rootNodes.root.lChild);
		rootNodes.insertLeft("J", rootNodes.root.lChild.rChild);
		
		rootNodes.insertRight("G", rootNodes.root);
		rootNodes.insertRight("C", rootNodes.root);
		rootNodes.insertLeft("F", rootNodes.root.rChild);
		System.out.print("中序遍历为：");
		rootNodes.inorder(rootNodes.root);
		System.out.print("\n" + "先序遍历为：");
		rootNodes.preorder(rootNodes.root);
		System.out.print("\n" + "后序遍历为：");
		rootNodes.postorder(rootNodes.root);
		System.out.println("\n" + "输入一个结点，输出根结点到此结点的路径：");
		//(new Scanner(System.in)).next()
		Node pNode = new Node("H");
		System.out.println(pNode.getData());
		rootNodes.getPath(rootNodes.root, pNode);
	}
}
