import java.util.Scanner;

/**
 * @author 马坤
 * @date May 11, 2019
 * @version 1.0
 */

public class SY3_SqStack {
	public static void main(String[] args) throws Exception {
		SqStack S = new SqStack(100); // 初始化一个新的容量为100的顺序栈
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入顺序栈的长度:");
		int n = sc.nextInt();
		System.out.println("请输入顺序栈中的各个数据元素值:");
		for (int i = 0; i < n; i++)
			S.push(sc.nextInt());
		System.out.println("建立的顺序栈中各元素为(从栈顶到栈底)： ");
		S.display();
		System.out.println("请输入待入栈的数据值e:");
		int e = sc.nextInt();
		S.push(e);
		System.out.println("入栈后的顺序栈中各元素为(从栈顶到栈底):");
		S.display();
		System.out.println("去除栈顶元素后，顺序栈中各元素为(从栈顶到栈底)：  ");
		S.pop();
		S.display();
	}

}
