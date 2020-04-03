package linkStack;

public class linkStack <T>{
	private Node<T> top;		//ջ��ָ��
	private int length;			//ջ����
	public linkStack() {
		length = 0;
		top = null;
	}
	public void push (T obj) {		//��ջ
		top = new Node<T>(obj, top);
		length++;
	}
	public T pop() {
		if (top == null) {
			System.out.println("ջ�ѿգ��޷�ɾ��Ԫ�أ�");
			return null;
		}
		T x = top.data;
		top = top.next;
		length--;
		return x;
	}
	public T getHead() {
		if (top == null) {
			System.out.println("ջ�ѿգ��޷�ɾ��Ԫ�أ�");
			return null;
		}
		return top.data;
	}
	public int size() {
		return length;
	}
	public boolean isEmpty() {
		return top == null;
	}
	public void nextOrder() {
		Node<T> p = top;
		while (p != null) {
			System.out.println(p.data);
			p = p.next;
		}
	}
	public void clear() {
		top = null;
	}
}
