package sequenceStack;
/**
 * ˳��ջ
 * @author ����
 *
 * @param <T>
 */
public class sequenceStack<T> {
	final int MaxSize = 10;
	private T[] stackArray;
	private int top;
	public sequenceStack() {		//ջ�ĳ�ʼ��
		top = -1;
		stackArray = (T[]) new Object[MaxSize];
	}
	public sequenceStack(int n) {
		if (n <= 0) {
			System.out.println("���鳤��Ҫ����0�������˳�����");
			System.exit(1);
		}
		top = -1;
		stackArray = (T[]) new Object[n];
	}
	public void push(T obj) {		//��ջ
		if (top == stackArray.length-1) {
			T[] p =(T[]) new Object[top*2+2];
			for (int i = 0; i < top; i++) {
				p[i] = stackArray[i];
			}
			stackArray = p;
		}
		top++;
		stackArray[top] = obj;
	}
	public T pop() {		//��ջ
		if (top == -1) {
			System.out.println("����ջ�ѿգ��޷�ɾ��Ԫ�ء�");
			return null;
		}
		top--;
		return stackArray[top+1];
	}
	public T getHead() {		//ȡջ��Ԫ��
		if (top == -1) {
			System.out.println("����ջ�ѿգ��޷�ɾ��Ԫ�أ�");
			return null;
		}
		return stackArray[top];
	}
	public boolean isEmpty() {
		return top == -1;
	}
	public int size() {
		return top+1;
	}
	public void nextOrder() {
		for (int i = top; i >= 0; i--) {
			System.out.println(stackArray[i]);
		}
	}
	public void clear() {
		top = -1;
	}
}
