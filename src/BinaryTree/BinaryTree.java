/**  
* <p>Title: BinaryTree.java</p>  
* <p>Description: 二叉树的基本操作</p>  
* <p>Copyright: Copyright (c) Apr 27, 2019</p>  
* @author 马坤  
* @date Apr 27, 2019  
* @version 1.0  
*/
package BinaryTree;

public class BinaryTree<T> {
	/**
	 * 最大节点数
	 */
	public int maxNodes = 10;
	public String[] list = new String[3];
	public int Index = 0;
	public Node<T> root;

	/**
	 * 创建一个根节点，该根节点的数据是空
	 */
	public BinaryTree() {
		this.root = new Node<T>();
	}

	/**
	 * 创建一个数据是x的根节点的二叉树
	 */
	public BinaryTree(T x) {
		this.root = new Node<T>(x);
	}

	/**
	 * <p>
	 * Title: insertLeft
	 * </p>
	 * <p>
	 * Description: 向parent结点插入数据为x的结点，如果parent结点有左结点，则把旧结点作为新结点的左结点，新结点作为parent的左子树
	 * </p>
	 * 
	 * @param x
	 *            结点的数据
	 * @param parent
	 *            父节点
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
	 * Description: 向parent结点插入数据为x的结点，如果parent结点有右结点，则把旧结点作为新结点的右结点，新结点作为parent的右子树
	 * </p>
	 * 
	 * @param x
	 *            新结点的数据
	 * @param parent
	 *            父结点
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
	 * Description: 删除parent的左子树
	 * </p>
	 * 
	 * @param parent
	 *            结点
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
	 * Description: 删除parent的右子树
	 * </p>
	 * 
	 * @param parent
	 *            结点
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
	 * Description: 先序遍历二叉树DLR
	 * </p>
	 * 
	 * @param node
	 */
	public void preorder(Node<T> node) {
		if (node == null)
			return;
		else {
			System.out.print(node.getData() + "->");// 输出数据
			preorder(node.lChild);// 先序遍历左孩子
			preorder(node.rChild);// 先序遍历右孩子
		}
	}

	/**
	 * <p>
	 * Title: preorder
	 * </p>
	 * <p>
	 * Description: 中序遍历二叉树LDR
	 * </p>
	 * 
	 * @param node
	 */
	public void inorder(Node<T> node) {
		if (node == null)
			return;
		else {
			inorder(node.lChild);// 遍历左孩子
			System.out.print(node.getData() + "->");// 得到数据
			inorder(node.rChild);// 遍历右孩子
		}
	}

	/**
	 * <p>
	 * Title: preorder
	 * </p>
	 * <p>
	 * Description: 后序遍历二叉树LRD
	 * </p>
	 * 
	 * @param node
	 */
	public void postorder(Node<T> node) {
		if (node == null)
			return;
		else {
			postorder(node.lChild);// 遍历左孩子
			postorder(node.rChild);// 遍历右孩子
			System.out.print(node.getData() + "->");// 得到数据
		}
	}

	public void levelorder() {
		Node<T>[] queue = new Node[this.maxNodes];// 构造一个队列
		int front, rear;// 队首指针，队尾指针
		if (this.root == null)
			return;
		front = -1;// 队列暂时为空，指针不知想任何元素
		rear = 0;
		queue[rear] = this.root;// 二叉树的根节点进入队列
		while (front != rear) {
			front++;
			System.out.print(queue[front].getData() + "->");// 访问对手指针的数据
			// 将队首节点的左孩子结点进队列
			if (queue[front].lChild != null) {
				rear++;
				queue[rear] = queue[front].lChild;
			}
			// 将对手结点的右孩子结点进队列
			if (queue[front].rChild != null) {
				rear++;
				queue[rear] = queue[front].rChild;
			}
		}
	}

	/**
	 * 按指定方式遍历二叉树 0表示先序，1表示中序，2表示后序，3表示按层次
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
	 * Description: 使用后序遍历计算二叉树的高度，当parent为root时，即可计算当前二叉树的高度
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
					System.out.print("路径为：");
					for (String string : list) {
						System.out.print(string + "->");
					}
					System.out.println(P.getData());
				}else if(R.equals(P.getData())){
					list[Index++] = (String) T.getData();
					System.out.print("路径为：");
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
