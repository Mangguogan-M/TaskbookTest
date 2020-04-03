/**  
* <p>Title: BSTree.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) Apr 28, 2019</p>  
* @author ����  
* @date Apr 28, 2019  
* @version 1.0  
*/
package BSTree;

class BSTree { // ������������
	protected BiTreeNode root; // �����

	public BSTree() { // ����ն���������
		root = null;
	}

	public BSTree(BiTreeNode root) { // ��������Ϊroot�Ķ���������
		this.root = root;
	}

	public BiTreeNode getRoot() {
		return root;
	}

	public void setRoot(BiTreeNode root) {
		this.root = root;
	}

	public void inOrderTraverse(BiTreeNode T) { // �и����������T���Ϊ���Ķ�����
		if (T != null) {
			inOrderTraverse(T.getLchild());
			System.out.print(T.getKey() + "  ");
			inOrderTraverse(T.getRchild());
		}
	}

	// ���ҹؼ���ֵΪkey�Ľ��,�����ҳɹ����ظý�㣬���򷵻�null
	public BiTreeNode searchBST(int key) {
		return searchBST(root, key);
	}

	// �������������ҵĵݹ��㷨
	private BiTreeNode searchBST(BiTreeNode p, int key) {
		if (p != null) {
			if (key == p.getKey()) // ���ҳɹ�
			{
				return p;
			}
			// System.out.print(((RecordNode) p.getData()).getKey() + "? ");
			if (key < p.getKey()) {
				return searchBST(p.getLchild(), key); // ���������в���
			} else {
				return searchBST(p.getRchild(), key); // ���������в���
			}
		}
		return null;
	}

	// �ڶ����������в���ؼ���ΪKeyt�Ľ��,������ɹ�����true,���򷵻�false
	public boolean insertBST(int key) {
		if (root == null) {
			root = new BiTreeNode(key); // ���������
			return true;
		}
		return insertBST(root, key);
	}

	// ���ؼ���Ϊkeyt�Ľ����뵽��pΪ���Ķ����������еĵݹ��㷨
	private boolean insertBST(BiTreeNode p, int key) {
		if (key == p.getKey()) {
			return false; // ������ؼ����ظ��Ľ��
		}
		if (key < p.getKey()) {
			if (p.getLchild() == null) { // ��p��������Ϊ��
				p.setLchild(new BiTreeNode(key)); // ����Ҷ�ӽ����Ϊp������
				return true;
			} else { // ��p���������ǿ�
				return insertBST(p.getLchild(), key); // ���뵽p����������
			}
		} else if (p.getRchild() == null) { // ��p��������Ϊ��
			p.setRchild(new BiTreeNode(key)); // ����Ҷ�ӽ����Ϊp���Һ���
			return true;
		} else { // ��p���������ǿ�
			return insertBST(p.getRchild(), key); // ���뵽p����������
		}
	}
}
