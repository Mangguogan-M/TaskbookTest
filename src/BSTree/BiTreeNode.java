/**  
* <p>Title: BiTreeNode.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) Apr 28, 2019</p>  
* @author ����  
* @date Apr 28, 2019  
* @version 1.0  
*/
package BSTree;

//�������Ķ�������Ľ����
class BiTreeNode {
	private int key;// ���Ĺؼ���
	private BiTreeNode lchild, rchild; // ���Һ���

	public BiTreeNode(int key) {// ����һ�����Һ���Ϊ�յĽ��
		this(key, null, null);
	}
	/**
	* <p>Title: </p>  
	* <p>Description: ����һ������Ԫ�غ����Һ��Ӷ���Ϊ�յĽ��</p>  
	* @param key
	* @param lchild
	* @param rchild
	 */
	public BiTreeNode(int key, BiTreeNode lchild, BiTreeNode rchild) {
		this.key = key;
		this.lchild = lchild;
		this.rchild = rchild;
	}

	public int getKey() {
		return key;
	}

	public BiTreeNode getLchild() {
		return lchild;
	}

	public BiTreeNode getRchild() {
		return rchild;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public void setLchild(BiTreeNode lchild) {
		this.lchild = lchild;
	}

	public void setRchild(BiTreeNode rchild) {
		this.rchild = rchild;
	}
}
