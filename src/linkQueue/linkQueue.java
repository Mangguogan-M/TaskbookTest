package linkQueue;

/**
 * ����
 * 
 * @author ����
 *
 * @param <T>
 */
public class linkQueue<T> {
	private Node<T> front, rear;
	private int length;

	public linkQueue() {
		length = 0;
		front = rear = new Node<T>(null); // ���б�ͷ��������
	}

	public void EnQueue(T obj) {
		rear = rear.next = new Node<T>(obj, null);
		length++;
	}

	public T DeQueue() {
		if (isEmpty()) {
			System.out.println("�����ѿգ��޷����ԣ�");
			return null;
		}
		Node<T> p = front.next;
		T x = p.data;
		front.next = p.next;
		length--;
		if (front.next == null) {
			rear = front;
		}
		return x;
	}

	public T getHead() {
		if (isEmpty()) {
			System.out.println("�����ѿգ��޷���ȡԪ�أ�");
			return null;
		}
		return front.next.data;
	}

	public int size() {
		return length;
	}

	public boolean isEmpty() {
		return front.next == null;
	}

	public void nextOrder() {
		Node<T> p = front.next;
		while (p != null) {
			System.out.println(p.data);
			p = p.next;
		}
	}

	public void clear() {
		front.next = rear.next = null;
	}
}
