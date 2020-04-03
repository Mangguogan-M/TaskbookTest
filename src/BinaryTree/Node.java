/**  
* <p>Title: Node.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) Apr 27, 2019</p>  
* @author ����  
* @date Apr 27, 2019  
* @version 1.0  
*/ 
package BinaryTree;

public class Node <T>{
	/**
	 * ����
	 */
	public Node<T> lChild;
	/**
	 * ����
	 */
	private T data;
	/**
	 * �Һ���
	 */
	public Node<T> rChild;
	/**
	 * ����һ���սڵ�
	 */
	public Node() {
		data = null;
		lChild = null;
		rChild = null;
	}
	/**
	 * ����һ��������x�Ľ��
	 */
	public Node(T x){
		data = x;
		lChild = null;
		rChild = null;
	}
	/**
	 * <p>Title: getData</p>  
	 * <p>Description: �õ��ýڵ������</p>  
	 * @return
	 */
	public Object getData(){
		return data;
	}

}
