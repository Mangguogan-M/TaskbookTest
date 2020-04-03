package sequenceStack;
/**
 * 顺序栈
 * @author 马坤
 *
 * @param <T>
 */
public class sequenceStack<T> {
	final int MaxSize = 10;
	private T[] stackArray;
	private int top;
	public sequenceStack() {		//栈的初始化
		top = -1;
		stackArray = (T[]) new Object[MaxSize];
	}
	public sequenceStack(int n) {
		if (n <= 0) {
			System.out.println("数组长度要大于0，否则退出程序！");
			System.exit(1);
		}
		top = -1;
		stackArray = (T[]) new Object[n];
	}
	public void push(T obj) {		//入栈
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
	public T pop() {		//出栈
		if (top == -1) {
			System.out.println("数据栈已空，无法删除元素。");
			return null;
		}
		top--;
		return stackArray[top+1];
	}
	public T getHead() {		//取栈顶元素
		if (top == -1) {
			System.out.println("数据栈已空，无法删除元素！");
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
