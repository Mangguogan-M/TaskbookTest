import java.util.Scanner;

/**
 * @author ����
 * @date May 11, 2019
 * @version 1.0
 */

public class SY3_SqStack {
	public static void main(String[] args) throws Exception {
		SqStack S = new SqStack(100); // ��ʼ��һ���µ�����Ϊ100��˳��ջ
		Scanner sc = new Scanner(System.in);
		System.out.print("������˳��ջ�ĳ���:");
		int n = sc.nextInt();
		System.out.println("������˳��ջ�еĸ�������Ԫ��ֵ:");
		for (int i = 0; i < n; i++)
			S.push(sc.nextInt());
		System.out.println("������˳��ջ�и�Ԫ��Ϊ(��ջ����ջ��)�� ");
		S.display();
		System.out.println("���������ջ������ֵe:");
		int e = sc.nextInt();
		S.push(e);
		System.out.println("��ջ���˳��ջ�и�Ԫ��Ϊ(��ջ����ջ��):");
		S.display();
		System.out.println("ȥ��ջ��Ԫ�غ�˳��ջ�и�Ԫ��Ϊ(��ջ����ջ��)��  ");
		S.pop();
		S.display();
	}

}
