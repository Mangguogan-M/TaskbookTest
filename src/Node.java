import java.util.Scanner;

/**
 * @author 马坤
 * @date May 11, 2019
 * @version 1.0
 */

public class Node {
	private Object data; // 存放结点值
	private Node next; // 后继结点的引用

	public Node() { // 无参数时的构造函数
		this(null, null);
	}

	public Node(Object data) { // 构造值为data的结点
		this(data, null);
	}

	public Node(Object data, Node next) {
		this.data = data;
		this.next = next;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}

// 实现链表的基本操作类
class LinkList {
	Node head = new Node();// 生成一个带头结点的空链表
	// 根据输入的一系列整数，以0标志结束，用头插法建立单链表

	public void creat() throws Exception {
		Scanner sc = new Scanner(System.in); // 构造用于输入的对象
		for (int x = sc.nextInt(); x != 0; x = sc.nextInt()) // 输入若干个数据元素的值(以0结束)
			insert(0, x);// 生成新结点,插入到表头
	}

	// 返回带头结点的单链表中第i个结点的数据域的值。其中：0≤i≤curLen-1
	public Object get(int i) throws Exception {
		Node p = head.getNext();// 初始化，p指向首结点，j为计数器
		int j = 0;
		while (p != null && j < i) {// 从首结点开始向后查找，直到p指向第i个结点或p为空
			p = p.getNext();// 指向后继结点
			++j;// 计数器的值增1
		}
		if (j > i || p == null) { // i小于0或者大于表长减1
			throw new Exception("第" + i + "个元素不存在");// 抛出异常
		}
		return p.getData(); // 返回结点p的数据域的值
	}

	// 在带头结点的单链表中的第i个数据元素之前插入一个值为x的元素
	public void insert(int i, Object x) throws Exception {
		Node p = head;// 初始化p为头结点,j为计数器
		int j = -1;
		while (p != null && j < i - 1) {// 寻找i个结点的前驱
			p = p.getNext();
			++j;// 计数器的值增1
		}
		if (j > i - 1 || p == null) // i不合法
			throw new Exception("插入位置不合理");// 输出异常

		Node s = new Node(x); // 生成新结点
		s.setNext(p.getNext());// 插入单链表中
		p.setNext(s);
	}

	// 删除带头结点的第i个数据元素。其中i取值范围为：0≤i≤length()- 1,如果i值不在此范围则抛出异常
	public void remove(int i) throws Exception {
		Node p = head;// 初始化p为头结点,j为计数器
		int j = -1;
		while (p.getNext() != null && j < i - 1) {// 寻找i个结点的前驱
			p = p.getNext();
			++j;// 计数器的值增1
		}
		if (j > i - 1 || p.getNext() == null) { // i小于0或者大于表长减1
			throw new Exception("删除位置不合理");// 输出异常
		}
		p.setNext(p.getNext().getNext());// 删除结点
	}

	// 输出线性表中的数据元素
	public void display() {
		Node p = head.getNext();// 取出带头结点的单链表中的首结点元素
		while (p != null) {
			System.out.print(p.getData() + " ");// 输出数据元素的值
			p = p.getNext();// 取下一个结点
		}
		System.out.println();// 换行
	}

}
