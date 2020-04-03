package linklist;

public class linkList<T> { // 单链表
	private Node<T> head; // 头指针
	private int length; // 单链表的长度

	public linkList() { // 单链表的初始化
		length = 0;
		head = new Node<T>(null);
	}

	public Node<T> getHead() { // 获取单链表头节点的地址
		return head;
	}

	public boolean add(T obj, int pos) { // 添加链表的元素
		if ((pos < 1 || pos > length + 1)) {
			System.out.println("pos值不合法");
			return false;
		}
		int num = 1;
		Node<T> p = head, q = head.next;
		while (num < pos) {
			p = q;
			q = q.next;
			num++;
		}
		p.next = new Node<T>(obj, q);
		length++;
		return true;
	}

	public T remove(int pos) { // 删除元素
		if (isEmpty()) {
			System.out.println("链表为空表");
			return null;
		} else {
			if ((pos < 1 || pos > length + 1)) {
				System.out.println("pos值不合法");
				return null;
			}
			int num = 1;
			Node<T> p = head, q = head.next;
			while (num < pos) {
				p = q;
				q = q.next;
				num++;
			}
			p.next = q.next;
			length--;
			return q.data;
		}
	}

	public int find(T obj) { // 查找元素
		if (isEmpty()) {
			System.out.println("链表为空表");
			return -1;
		}
		int num = 1;
		Node<T> p = head.next;
		while (p != null) {
			if (p.data.equals(obj) == false) {
				p = p.next;
				num++;
			} else
				break;
		}
		if (p == null) {
			return -1;
		}
		return num;
	}

	public T value(int pos) { // 获取单链表pos节点的值
		if (isEmpty()) {
			System.out.println("链表为空表");
			return null;
		} else {
			if ((pos < 1 || pos > length + 1)) {
				System.out.println("pos值不合法");
				return null;
			}
			int num = 1;
			Node<T> q = head.next;
			while (num < pos) {
				q = q.next;
				num++;
			}
			return q.data;
		}
	}

	public boolean modify(T obj, int pos) { // 更新单链表pos节点处的值
		if (isEmpty()) {
			System.out.println("链表为空表");
			return false;
		} else {
			if ((pos < 1 || pos > length + 1)) {
				System.out.println("pos值不合法");
				return false;
			}
			int num = 1;
			Node<T> q = head.next;
			while (num < pos) {
				q = q.next;
				num++;
			}
			q.data = obj;
			return true;
		}
	}

	public boolean isEmpty() { // 判空
		return length == 0;
	}

	public int size() { // 单链表的长度
		return length;
	}

	public void nextOrder() { // 单链表正序输出
		Node<T> p = head.next;
		while (p != null) {
			System.out.print(p.data + "\t");
			p = p.next;
		}
		System.out.println();
	}

	public void clear() { // 清空
		length = 0;
		head.next = null;
	}

	public void setLength(int size) {
		this.length = size;
	}
}
