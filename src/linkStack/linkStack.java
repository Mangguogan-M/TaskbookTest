package linkStack;

public class linkStack <T>{
	private Node<T> top;		//栈顶指针
	private int length;			//栈长度
	public linkStack() {
		length = 0;
		top = null;
	}
	public void push (T obj) {		//入栈
		top = new Node<T>(obj, top);
		length++;
	}
	public T pop() {
		if (top == null) {
			System.out.println("栈已空，无法删除元素！");
			return null;
		}
		T x = top.data;
		top = top.next;
		length--;
		return x;
	}
	public T getHead() {
		if (top == null) {
			System.out.println("栈已空，无法删除元素！");
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
