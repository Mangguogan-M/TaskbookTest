package BinaryTree;

//������ʽ�洢�ṹ�µĶ�������
class BiTree {
	public BiTreeNode root;// ���ĸ����

	public BiTree() {// ����һ�ÿ���
		this.root = null;
	}

	public BiTree(BiTreeNode root) {// ����һ����
		this.root = root;
	}

	// �ɱ������������ȸ��������н���һ�ö�����
	public static int index;// ���ڼ�¼preStr������ֵ

	public BiTree(String preStr) {
		char c = preStr.charAt(index++);// ȡ���ַ�������Ϊindex���ַ�����index��1
		if (c != '#') {// �ַ���Ϊ#-----abc##d##e#f##
			root = new BiTreeNode(c);// �������ĸ����
			root.setLchild(new BiTree(preStr).root);// ��������������
			root.setRchild(new BiTree(preStr).root);// ��������������
		} else
			root = null;
	}

	// �ȸ��������������������ĵݹ��㷨
	public void preRootTraverse(BiTreeNode T) {
		if (T != null) {
			System.out.print(T.getData()); // ���ʸ����
			preRootTraverse(T.getLchild());// ����������
			preRootTraverse(T.getRchild());// ����������
		}
	}

	// �и��������������������ĵݹ��㷨
	public void inRootTraverse(BiTreeNode T) {
		if (T != null) {
			inRootTraverse(T.getLchild());// ����������
			System.out.print(T.getData()); // ���ʸ����
			inRootTraverse(T.getRchild());// ����������
		}
	}

	// ����������������������ĵݹ��㷨
	public void postRootTraverse(BiTreeNode T) {
		if (T != null) {
			postRootTraverse(T.getLchild());// ����������
			postRootTraverse(T.getRchild());// ����������
			System.out.print(T.getData()); // ���ʸ����
		}
	}

	public BiTreeNode getRoot() {
		return root;
	}

	public void setRoot(BiTreeNode root) {
		this.root = root;
	}
	
	boolean isEqual_post(BiTreeNode T1,BiTreeNode T2){
        if (T1==null&&T2==null)
            return true;
        if (T1!=null&&T2!=null)
            if (isEqual_post(T1.getLchild(),T2.getLchild()))
                if(isEqual_post(T1.getRchild(),T2.getRchild()))
                   if (T1.getData().equals(T2.getData()))
                       return true;
        return false;
}

}
