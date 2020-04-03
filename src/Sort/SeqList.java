/**  
* <p>Title: SeqList.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) May 5, 2019</p>  
* @author ����  
* @date May 5, 2019  
* @version 1.0  
*/
package Sort;

import java.util.Arrays;

//˳���������
class SeqList {
	CopareMoveNum[] cm; // �ȽϺ��ƶ�����
	private RecordNode[] r; // ˳����¼�������
	private int curlen; // ˳�����,����¼����

	public RecordNode[] getRecord() {
		return r;
	}

	public void setRecord(RecordNode[] r) {
		this.r = r;
	}

	// ˳���Ĺ��췽��������һ���洢�ռ�����ΪmaxSize��˳���ͬʱ������¼�Ƚ����ƶ�������������󲢸���ֵ
	public SeqList(int maxSize) {
		this.r = new RecordNode[maxSize]; // Ϊ˳������maxSize���洢��Ԫ
		this.curlen = 0; // ��˳���ĵ�ǰ����Ϊ0
		this.cm = new CopareMoveNum[3]; // ��¼�ȽϺ��ƶ�����������
		for (int i = 0; i < 3; i++) { // �����ʼ��Ϊ0
			this.cm[i] = new CopareMoveNum();
			this.cm[i].setCpn(0);
			this.cm[i].setMvn(0);
		}
	}

	// ��˳����е�����Ԫ�ظ������ɺ���������ֵ
	public int length() {
		return curlen; // ����˳���ĵ�ǰ����
	}

	// �ڵ�ǰ˳���ĵ�i�����֮ǰ����һ��RecordNode���͵Ľ��x
	// ����iȡֵ��ΧΪ��0��i��length()��
	// ���iֵ���ڴ˷�Χ���׳��쳣,��i=0ʱ��ʾ�ڱ�ͷ����һ������Ԫ��x,
	// ��i=length()ʱ��ʾ�ڱ�β����һ������Ԫ��x
	public void insert(int i, RecordNode x) throws Exception {
		if (curlen == r.length) { // �ж�˳����Ƿ�����
			throw new Exception("˳�������");
		}
		if (i < 0 || i > curlen) { // iС��0���ߴ��ڱ�
			throw new Exception("����λ�ò�����");
		}
		for (int j = curlen; j > i; j--) {
			r[j] = r[j - 1]; // ����λ�ü�֮���Ԫ�غ���
		}
		r[i] = x; // ����x
		this.curlen++; // ������1
	}

	// �������Ԫ��
	public void display() {
		for (int i = 0; i < this.curlen; i++) {
			System.out.print(" " + r[i].getKey().toString());
		}
		System.out.println();
	}

	/**
	 * ���������ڵ�ֱ�Ӳ��������㷨
	 */
	public void insertSort() {
		RecordNode temp;
		int i, j;
		for (i = 1; i < this.curlen; i++) {// n-1��ɨ��
			temp = r[i]; // ��������ĵ�i����¼�ݴ���temp��
			cm[0].setMvn(cm[0].getMvn() + 1); // �ƶ�������1;
			for (j = i - 1; j >= 0 && temp.getKey().compareTo(r[j].getKey()) < 0; j--) { // ��ǰ���r[i]��ļ�¼����ƶ�
				cm[0].setCpn(cm[0].getCpn() + 1); // �Ƚϴ�����1
				r[j + 1] = r[j];
				cm[0].setMvn(cm[0].getMvn() + 1); // �ƶ�������1;
			}
			r[j + 1] = temp; // r[i]���뵽��j+1��λ��
			cm[0].setMvn(cm[0].getMvn() + 1); // �ƶ�������1;
		}
	}

	/**
	 * ð�������㷨
	 */
	public void bubbleSort() {
		RecordNode temp; // �������
		boolean flag = true; // �Ƿ񽻻��ı��
		for (int i = 1; i < this.curlen && flag; i++) { // �н���ʱ�ٽ�����һ�ˣ����n-1��
			flag = false; // �ٶ�Ԫ��δ����
			for (int j = 0; j < this.curlen - i; j++) { // һ�αȽϡ�����
				cm[1].setCpn(cm[1].getCpn() + 1); // �Ƚϴ�����1
				if (r[j].getKey().compareTo(r[j + 1].getKey()) > 0) { // ����ʱ������
					temp = r[j];
					r[j] = r[j + 1];
					r[j + 1] = temp;
					cm[1].setMvn(cm[1].getMvn() + 3); // �ƶ�������3;
					flag = true;
				}
			}
		}
	}

	/**
	 * ��ѡ������
	 */
	public void selectSort() {
		RecordNode temp; // �������
		for (int i = 0; i < this.curlen - 1; i++) {// n-1������
			// ÿ���ڴ�r[i]��ʼ����������Ѱ����СԪ��
			int min = i; // ���i����¼�Ĺؼ�����С
			for (int j = i + 1; j < this.curlen; j++) {// ����������ѡ��ؼ�����С�ļ�¼
				cm[2].setCpn(cm[2].getCpn() + 1); // �Ƚϴ�����1
				if (r[j].getKey().compareTo(r[min].getKey()) < 0) {
					min = j; // ��ס�ؼ�����С��¼���±�
				}
			}
			if (min != i) { // �����˹ؼ�����С�ļ�¼���i����¼����
				temp = r[i];
				r[i] = r[min];
				r[min] = temp;
				cm[2].setMvn(cm[2].getMvn() + 3); // �ƶ�������3;
			}
		}
	}

	/**
	 * ϣ������
	 */
	public void shellSort(int[] arr) {
		// i��ʾϣ�������еĵ�n/2+1��Ԫ�أ�����n/4+1��
		// j��ʾϣ�������д�0��n/2��Ԫ�أ�n/4��
		// r��ʾϣ��������n/2+1����n/4+1��ֵ
		int i, j, r, tmp;
		// ��������
		for (r = arr.length / 2; r >= 1; r = r / 2) {
			for (i = r; i < arr.length; i++) {
				tmp = arr[i];
				j = i - r;
				// һ������
				while (j >= 0 && tmp < arr[j]) {
					arr[j + r] = arr[j];
					j -= r;
				}
				arr[j + r] = tmp;
			}
			System.out.println(i + ":" + Arrays.toString(arr));
		}
	}
	
}
