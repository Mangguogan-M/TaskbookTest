/**  
* <p>Title: RootTest.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) Apr 27, 2019</p>  
* @author ����  
* @date Apr 27, 2019  
* @version 1.0  
*/ 
package BinaryTree;

import java.util.Scanner;

public class RootTest {
	public static void main(String[] args){
		System.out.println("ϵͳ�Զ���Ķ�����");
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
		System.out.print("�������Ϊ��");
		rootNodes.inorder(rootNodes.root);
		System.out.print("\n" + "�������Ϊ��");
		rootNodes.preorder(rootNodes.root);
		System.out.print("\n" + "�������Ϊ��");
		rootNodes.postorder(rootNodes.root);
		System.out.println("\n" + "����һ����㣬�������㵽�˽���·����");
		//(new Scanner(System.in)).next()
		Node pNode = new Node("H");
		System.out.println(pNode.getData());
		rootNodes.getPath(rootNodes.root, pNode);
	}
}
