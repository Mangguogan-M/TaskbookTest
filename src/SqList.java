/**
 * @author ����
 * @date May 11, 2019
 * @version 1.0
 */

public class SqList {
	private Object[] listElem; // ���Ա�洢�ռ�
	private int curLen; // ��ǰ����

	public int getCurLen() {
		return curLen;
	}

	public void setCurLen(int curLen) {
		this.curLen = curLen;
	}

	public Object[] getListElem() {
		return listElem;
	}

	public void setListElem(Object[] listElem) {
		this.listElem = listElem;
	}

	// ˳���Ĺ��캯��������һ���洢�ռ�����ΪmaxSize�Ŀ����Ա�
	public SqList(int maxSize) {
		curLen = 0; // ��˳���ĵ�ǰ����Ϊ0
		listElem = new Object[maxSize];// Ϊ˳������maxSize���洢��Ԫ
	}

	// �����Ա�ĵ�i������Ԫ��֮ǰ����һ��ֵΪx������Ԫ�ء�����iȡֵ��ΧΪ��0��i��curLen��
	public void insert(int i, Object x) throws Exception {
		if (curLen == listElem.length) // �ж�˳����Ƿ�����
			throw new Exception("˳�������");// ����쳣
		if (i < 0 || i > curLen) // iС��0���ߴ��ڱ�
			throw new Exception("����λ�ò�����");// ����쳣
		for (int j = curLen; j > i; j--)
			listElem[j] = listElem[j - 1];// ����λ�ü�֮���Ԫ�غ���
		listElem[i] = x; // ����x
		curLen++;// ������1
	}

	// �����Ա��е�i������Ԫ��ɾ��������iȡֵ��ΧΪ��0��i��curLen- 1,���iֵ���ڴ˷�Χ���׳��쳣
	public void remove(int i) throws Exception {
		if (i < 0 || i > curLen - 1) // iС��1���ߴ��ڱ���1
			throw new Exception("ɾ��λ�ò�����");// ����쳣

		for (int j = i; j < curLen - 1; j++)
			listElem[j] = listElem[j + 1];// ��ɾ��Ԫ��֮���Ԫ������
		curLen--; // ���ȼ�1
	}

	// ����˳�����ֵ��xԪ��,�����ҳɹ��򷵻�Ԫ���ڱ��е�λ��(0��curLen-1),���򷵻�-1
	public int indexOf(Object x) {
		int j = 0; // jָʾ˳����д��Ƚϵ�����Ԫ�أ����ʼֵָʾ˳����е�0������Ԫ��
		while (j < curLen && !listElem[j].equals(x)) // ���αȽ�
			j++;
		if (j < curLen) // �ж�j��λ���Ƿ�λ��˳�����
			return j; // ����ֵΪx������Ԫ����˳����е�λ��
		else
			return -1; // ֵΪx������Ԫ����˳����в�����
	}

	// ���˳����е�����Ԫ��
	public void display() {
		for (int j = 0; j < curLen; j++)
			System.out.print(listElem[j] + " ");
		System.out.println();// ����
	}

}
