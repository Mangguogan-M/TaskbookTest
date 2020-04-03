/**
 * @author ����
 * @date May 11, 2019
 * @version 1.0
 */

public class SqStack {
	private Object[] stackElem; // ջ�洢�ռ�
	private int top; // �ǿ�ջ��ʼ�ձ�ʾջ��Ԫ�ص���һ��λ�ã���ջΪ��ʱ��ֵΪ0
	// ջ�Ĺ��캯��������һ���洢�ռ�����ΪmaxSize��ջ

	public SqStack(int maxSize) {
		top = 0; // ��ʼ��topΪ0
		stackElem = new Object[maxSize];// Ϊջ����maxSize���洢��Ԫ
	}

	// �Ƴ�ջ��������Ϊ�˺�����ֵ���ظö���
	public Object pop() {
		if (top == 0)// ջΪ��
			return null;
		else {// ջ�ǿ�
			return stackElem[--top];// �޸�ջ��ָ�룬������ջ��Ԫ��
		}
	}

	// ������Ԫ��eѹ��ջ��
	public void push(Object e) throws Exception {
		if (top == stackElem.length)// ջ��
			throw new Exception("ջ����");// ����쳣
		else
			// ջδ��
			stackElem[top++] = e;// e����ջ��Ԫ�غ�top��1
	}

	// ������������ջ�����е�Ԫ��(��ջ����ջ��)
	public void display() {
		for (int i = top - 1; i >= 0; i--)
			System.out.print(stackElem[i].toString() + " ");// ��ӡ
		System.out.println();
	}

}
