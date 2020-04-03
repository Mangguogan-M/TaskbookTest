/**
 * @author 马坤
 * @date May 11, 2019
 * @version 1.0
 */

public class SqStack {
	private Object[] stackElem; // 栈存储空间
	private int top; // 非空栈中始终表示栈顶元素的下一个位置，当栈为空时其值为0
	// 栈的构造函数，构造一个存储空间容量为maxSize的栈

	public SqStack(int maxSize) {
		top = 0; // 初始化top为0
		stackElem = new Object[maxSize];// 为栈分配maxSize个存储单元
	}

	// 移除栈顶对象并作为此函数的值返回该对象
	public Object pop() {
		if (top == 0)// 栈为空
			return null;
		else {// 栈非空
			return stackElem[--top];// 修改栈顶指针，并返回栈顶元素
		}
	}

	// 将数据元素e压入栈顶
	public void push(Object e) throws Exception {
		if (top == stackElem.length)// 栈满
			throw new Exception("栈已满");// 输出异常
		else
			// 栈未满
			stackElem[top++] = e;// e赋给栈顶元素后，top增1
	}

	// 输出函数，输出栈中所有的元素(从栈顶到栈底)
	public void display() {
		for (int i = top - 1; i >= 0; i--)
			System.out.print(stackElem[i].toString() + " ");// 打印
		System.out.println();
	}

}
