/**  
* <p>Title: Node.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) Apr 27, 2019</p>  
* @author 马坤  
* @date Apr 27, 2019  
* @version 1.0  
*/ 
package BinaryTree;

public class Node <T>{
	/**
	 * 左孩子
	 */
	public Node<T> lChild;
	/**
	 * 数据
	 */
	private T data;
	/**
	 * 右孩子
	 */
	public Node<T> rChild;
	/**
	 * 构造一个空节点
	 */
	public Node() {
		data = null;
		lChild = null;
		rChild = null;
	}
	/**
	 * 构造一个数据是x的结点
	 */
	public Node(T x){
		data = x;
		lChild = null;
		rChild = null;
	}
	/**
	 * <p>Title: getData</p>  
	 * <p>Description: 得到该节点的数据</p>  
	 * @return
	 */
	public Object getData(){
		return data;
	}

}
