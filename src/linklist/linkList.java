package linklist;

public class linkList<T> { // ������
	private Node<T> head; // ͷָ��
	private int length; // ������ĳ���

	public linkList() { // ������ĳ�ʼ��
		length = 0;
		head = new Node<T>(null);
	}

	public Node<T> getHead() { // ��ȡ������ͷ�ڵ�ĵ�ַ
		return head;
	}

	public boolean add(T obj, int pos) { // ��������Ԫ��
		if ((pos < 1 || pos > length + 1)) {
			System.out.println("posֵ���Ϸ�");
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

	public T remove(int pos) { // ɾ��Ԫ��
		if (isEmpty()) {
			System.out.println("����Ϊ�ձ�");
			return null;
		} else {
			if ((pos < 1 || pos > length + 1)) {
				System.out.println("posֵ���Ϸ�");
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

	public int find(T obj) { // ����Ԫ��
		if (isEmpty()) {
			System.out.println("����Ϊ�ձ�");
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

	public T value(int pos) { // ��ȡ������pos�ڵ��ֵ
		if (isEmpty()) {
			System.out.println("����Ϊ�ձ�");
			return null;
		} else {
			if ((pos < 1 || pos > length + 1)) {
				System.out.println("posֵ���Ϸ�");
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

	public boolean modify(T obj, int pos) { // ���µ�����pos�ڵ㴦��ֵ
		if (isEmpty()) {
			System.out.println("����Ϊ�ձ�");
			return false;
		} else {
			if ((pos < 1 || pos > length + 1)) {
				System.out.println("posֵ���Ϸ�");
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

	public boolean isEmpty() { // �п�
		return length == 0;
	}

	public int size() { // ������ĳ���
		return length;
	}

	public void nextOrder() { // �������������
		Node<T> p = head.next;
		while (p != null) {
			System.out.print(p.data + "\t");
			p = p.next;
		}
		System.out.println();
	}

	public void clear() { // ���
		length = 0;
		head.next = null;
	}

	public void setLength(int size) {
		this.length = size;
	}
}
