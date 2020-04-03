/**  
* <p>Title: BinaryTree.java</p>  
* <p>Description: �������Ļ�������</p>  
* <p>Copyright: Copyright (c) Apr 27, 2019</p>  
* @author ����  
* @date Apr 27, 2019  
* @version 1.0  
*/
package BinaryTree;

public class BinaryTree<T> {
	/**
	 * ���ڵ���
	 */
	public int maxNodes = 10;
	public String[] list = new String[3];
	public int Index = 0;
	public Node<T> root;

	/**
	 * ����һ�����ڵ㣬�ø��ڵ�������ǿ�
	 */
	public BinaryTree() {
		this.root = new Node<T>();
	}

	/**
	 * ����һ��������x�ĸ��ڵ�Ķ�����
	 */
	public BinaryTree(T x) {
		this.root = new Node<T>(x);
	}

	/**
	 * <p>
	 * Title: insertLeft
	 * </p>
	 * <p>
	 * Description: ��parent����������Ϊx�Ľ�㣬���parent��������㣬��Ѿɽ����Ϊ�½������㣬�½����Ϊparent��������
	 * </p>
	 * 
	 * @param x
	 *            ��������
	 * @param parent
	 *            ���ڵ�
	 * @return
	 */
	public boolean insertLeft(T x, Node<T> parent) {
		if (parent == null)
			return false;
		Node<T> p = new Node<T>(x);
		if (parent.lChild == null) {
			parent.lChild = p;
		} else {
			p.lChild = parent.lChild;
			parent.lChild = p;
		}
		return true;
	}

	/**
	 * <p>
	 * Title: insertRight
	 * </p>
	 * <p>
	 * Description: ��parent����������Ϊx�Ľ�㣬���parent������ҽ�㣬��Ѿɽ����Ϊ�½����ҽ�㣬�½����Ϊparent��������
	 * </p>
	 * 
	 * @param x
	 *            �½�������
	 * @param parent
	 *            �����
	 * @return
	 */
	public boolean insertRight(T x, Node<T> parent) {
		if (parent == null)
			return false;
		Node<T> p = new Node<T>(x);
		if (parent.rChild == null) {
			parent.rChild = p;
		} else {
			p.rChild = parent.rChild;
			parent.rChild = p;
		}
		return true;
	}

	/**
	 * <p>
	 * Title: deleteLeft
	 * </p>
	 * <p>
	 * Description: ɾ��parent��������
	 * </p>
	 * 
	 * @param parent
	 *            ���
	 * @return
	 */
	public boolean deleteLeft(Node<T> parent) {
		if (parent == null) {
			return false;
		} else {
			parent.lChild = null;
			return true;
		}
	}

	/**
	 * <p>
	 * Title: deleteLeft
	 * </p>
	 * <p>
	 * Description: ɾ��parent��������
	 * </p>
	 * 
	 * @param parent
	 *            ���
	 * @return
	 */
	public boolean deleteRight(Node<T> parent) {
		if (parent == null) {
			return false;
		} else {
			parent.rChild = null;
			return true;
		}
	}

	/**
	 * <p>
	 * Title: preorder
	 * </p>
	 * <p>
	 * Description: �������������DLR
	 * </p>
	 * 
	 * @param node
	 */
	public void preorder(Node<T> node) {
		if (node == null)
			return;
		else {
			System.out.print(node.getData() + "->");// �������
			preorder(node.lChild);// �����������
			preorder(node.rChild);// ��������Һ���
		}
	}

	/**
	 * <p>
	 * Title: preorder
	 * </p>
	 * <p>
	 * Description: �������������LDR
	 * </p>
	 * 
	 * @param node
	 */
	public void inorder(Node<T> node) {
		if (node == null)
			return;
		else {
			inorder(node.lChild);// ��������
			System.out.print(node.getData() + "->");// �õ�����
			inorder(node.rChild);// �����Һ���
		}
	}

	/**
	 * <p>
	 * Title: preorder
	 * </p>
	 * <p>
	 * Description: �������������LRD
	 * </p>
	 * 
	 * @param node
	 */
	public void postorder(Node<T> node) {
		if (node == null)
			return;
		else {
			postorder(node.lChild);// ��������
			postorder(node.rChild);// �����Һ���
			System.out.print(node.getData() + "->");// �õ�����
		}
	}

	public void levelorder() {
		Node<T>[] queue = new Node[this.maxNodes];// ����һ������
		int front, rear;// ����ָ�룬��βָ��
		if (this.root == null)
			return;
		front = -1;// ������ʱΪ�գ�ָ�벻֪���κ�Ԫ��
		rear = 0;
		queue[rear] = this.root;// �������ĸ��ڵ�������
		while (front != rear) {
			front++;
			System.out.print(queue[front].getData() + "->");// ���ʶ���ָ�������
			// �����׽ڵ�����ӽ�������
			if (queue[front].lChild != null) {
				rear++;
				queue[rear] = queue[front].lChild;
			}
			// �����ֽ����Һ��ӽ�������
			if (queue[front].rChild != null) {
				rear++;
				queue[rear] = queue[front].rChild;
			}
		}
	}

	/**
	 * ��ָ����ʽ���������� 0��ʾ����1��ʾ����2��ʾ����3��ʾ�����
	 */
	public void traversal(int i) {
		switch (i) {
		case 0:
			preorder(this.root);
			break;
		case 1:
			inorder(this.root);
			break;
		case 2:
			postorder(this.root);
			break;
		default:
			levelorder();
		}
	}

	/**
	 * <p>
	 * Title: getHeight
	 * </p>
	 * <p>
	 * Description: ʹ�ú����������������ĸ߶ȣ���parentΪrootʱ�����ɼ��㵱ǰ�������ĸ߶�
	 * </p>
	 * 
	 * @param parent
	 * @return
	 */
	public int getHeight(Node<T> parent) {
		int lh, rh, max;
		if (parent != null) {
			lh = getHeight(parent.lChild);
			rh = getHeight(parent.rChild);
			max = lh > rh ? lh : rh;
			return max + 1;
		} else
			return 0;
	}

	public void getPath(Node root, Node p) {
		if(root == null && p == null)
			return;
		else {
			Node T = root;
			Node P = p;
			String L = null;
			String R = null;
			try {
					L = (String) T.lChild.getData();
				
					R = (String) T.rChild.getData();
				
				if(L.equals(P.getData())){
					list[Index++] = (String) T.getData();
					System.out.print("·��Ϊ��");
					for (String string : list) {
						System.out.print(string + "->");
					}
					System.out.println(P.getData());
				}else if(R.equals(P.getData())){
					list[Index++] = (String) T.getData();
					System.out.print("·��Ϊ��");
					for (String string : list) {
						System.out.print(string + "->");
					}
					System.out.println(P.getData());
				}else {
					list[Index++] = (String) T.getData();
					getPath(root.lChild, P);
					getPath(root.rChild, P);
				}
			}catch (NullPointerException e) {
					e.printStackTrace();
			}
		}
	}
}
