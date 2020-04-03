import java.util.Scanner;

/**
 * @author ����
 * @date May 11, 2019
 * @version 1.0
 */

public class Node {
	private Object data; // ��Ž��ֵ
	private Node next; // ��̽�������

	public Node() { // �޲���ʱ�Ĺ��캯��
		this(null, null);
	}

	public Node(Object data) { // ����ֵΪdata�Ľ��
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

// ʵ������Ļ���������
class LinkList {
	Node head = new Node();// ����һ����ͷ���Ŀ�����
	// ���������һϵ����������0��־��������ͷ�巨����������

	public void creat() throws Exception {
		Scanner sc = new Scanner(System.in); // ������������Ķ���
		for (int x = sc.nextInt(); x != 0; x = sc.nextInt()) // �������ɸ�����Ԫ�ص�ֵ(��0����)
			insert(0, x);// �����½��,���뵽��ͷ
	}

	// ���ش�ͷ���ĵ������е�i�������������ֵ�����У�0��i��curLen-1
	public Object get(int i) throws Exception {
		Node p = head.getNext();// ��ʼ����pָ���׽�㣬jΪ������
		int j = 0;
		while (p != null && j < i) {// ���׽�㿪ʼ�����ң�ֱ��pָ���i������pΪ��
			p = p.getNext();// ָ���̽��
			++j;// ��������ֵ��1
		}
		if (j > i || p == null) { // iС��0���ߴ��ڱ���1
			throw new Exception("��" + i + "��Ԫ�ز�����");// �׳��쳣
		}
		return p.getData(); // ���ؽ��p���������ֵ
	}

	// �ڴ�ͷ���ĵ������еĵ�i������Ԫ��֮ǰ����һ��ֵΪx��Ԫ��
	public void insert(int i, Object x) throws Exception {
		Node p = head;// ��ʼ��pΪͷ���,jΪ������
		int j = -1;
		while (p != null && j < i - 1) {// Ѱ��i������ǰ��
			p = p.getNext();
			++j;// ��������ֵ��1
		}
		if (j > i - 1 || p == null) // i���Ϸ�
			throw new Exception("����λ�ò�����");// ����쳣

		Node s = new Node(x); // �����½��
		s.setNext(p.getNext());// ���뵥������
		p.setNext(s);
	}

	// ɾ����ͷ���ĵ�i������Ԫ�ء�����iȡֵ��ΧΪ��0��i��length()- 1,���iֵ���ڴ˷�Χ���׳��쳣
	public void remove(int i) throws Exception {
		Node p = head;// ��ʼ��pΪͷ���,jΪ������
		int j = -1;
		while (p.getNext() != null && j < i - 1) {// Ѱ��i������ǰ��
			p = p.getNext();
			++j;// ��������ֵ��1
		}
		if (j > i - 1 || p.getNext() == null) { // iС��0���ߴ��ڱ���1
			throw new Exception("ɾ��λ�ò�����");// ����쳣
		}
		p.setNext(p.getNext().getNext());// ɾ�����
	}

	// ������Ա��е�����Ԫ��
	public void display() {
		Node p = head.getNext();// ȡ����ͷ���ĵ������е��׽��Ԫ��
		while (p != null) {
			System.out.print(p.getData() + " ");// �������Ԫ�ص�ֵ
			p = p.getNext();// ȡ��һ�����
		}
		System.out.println();// ����
	}

}
