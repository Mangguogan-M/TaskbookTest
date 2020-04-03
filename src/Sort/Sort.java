/**  
* <p>Title: Sort.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) May 5, 2019</p>  
* @author ����  
* @date May 5, 2019  
* @version 1.0  
*/
package Sort;

public class Sort {
	private int[] array;
	private int length;

	public Sort(int[] array) {
		this.array = array;
		this.length = array.length;
	}

	/**
	 * ֱ�Ӳ�������
	 */
	public void insertSort() {
		for (int index = 1; index < length; index++) {// ������ҵ�index������Ϊ�Ƚ϶�������ݵ�index
			int temp = array[index];// �����Ƚϵ�����
			int leftindex = index - 1;
			while (leftindex >= 0 && array[leftindex] > temp) {// ���ȵ�����߻���������tempС������ʱ������ѭ��
				array[leftindex + 1] = array[leftindex];
				leftindex--;
			}
			array[leftindex + 1] = temp;// ��temp�ŵ���λ��
		}
	}

	/**
	 * ϣ������
	 */
	public void shellSort() {
		// i��ʾϣ�������еĵ�n/2+1��Ԫ�أ�����n/4+1��
		// j��ʾϣ�������д�0��n/2��Ԫ�أ�n/4��
		// r��ʾϣ��������n/2+1����n/4+1��ֵ
		int i, j, r, tmp;
		// ��������
		for (r = length / 2; r >= 1; r = r / 2) {
			for (i = r; i < length; i++) {
				tmp = array[i];
				j = i - r;
				// һ������
				while (j >= 0 && tmp < array[j]) {
					array[j + r] = array[j];
					j -= r;
				}
				array[j + r] = tmp;
			}
		}
	}

	/**
	 * ð������
	 */
	public void bobSort() {
		for (int i = 0; i < length - 1; i++) {// ��������
			for (int j = 0; j < length - 1 - i; j++) {// �Ƚϴ���
				if (array[j] > array[j + 1]) {
					int temp = array[j + 1];
					array[j + 1] = array[j];
					array[j] = temp;
				}
			}
		}
	}

	/**
	 * ��������
	 */
	public void quickSort() {
		quickSort(array, 0, array.length - 1);
	}

	private static void quickSort(int[] arr, int left, int right) {
		int t;
		int ltemp = left;
		int rtemp = right;
		// �ֽ�ֵ
		int fIndex = arr[(left + right) / 2];
		while (ltemp < rtemp) {
			// ����࿪ʼ���ұȷֽ�ֵ�����
			while (arr[ltemp] < fIndex) {
				// Ԫ��С�ڷֽ�ֵ����������
				++ltemp;
			}
			// ���Ҳ࿪ʼ���ұȷֽ�ֵС����
			while (arr[rtemp] > fIndex) {
				// Ԫ�ش��ڷֽ�ֵ����������
				--rtemp;
			}
			// ����鵽�ıȷֽ�ֵ��������±�С�ڵ��ڱȷֽ�ֵС�������±꣬����н���
			if (ltemp <= rtemp) {
				t = arr[ltemp];
				arr[ltemp] = arr[rtemp];
				arr[rtemp] = t;
				--rtemp;
				++ltemp;
			}
			if (ltemp == rtemp) {
				ltemp++;
			}
			if (left < rtemp) {
				quickSort(arr, left, ltemp - 1);
			}
			if (ltemp < right) {
				quickSort(arr, rtemp + 1, right);
			}
		}
	}

	/**
	 * ѡ������
	 */
	public void chooseSort() {
		for (int i = 0; i < length - 1; i++) {
			int minIndex = i;
			for (int j = minIndex + 1; j < length; j++) {
				if (array[j] < array[minIndex]) {
					minIndex = j;
				}
			}
			int temp = array[i];
			array[i] = array[minIndex];
			array[minIndex] = temp;
		}
	}

	/**
	 * �鲢����
	 */
	public void mergeSort() {
		mergeSort(array, 0, length - 1);
	}

	private static void mergeSort(int[] a, int start, int end) {
		if (start < end) {// ����������ֻ��һ��Ԫ��ʱ�����ݹ�
			int mid = (start + end) / 2;// ����������
			mergeSort(a, start, mid);// ����������н��еݹ�����
			mergeSort(a, mid + 1, end);// ���Ҳ������н��еݹ�����
			merge(a, start, mid, end);// �ϲ�
		}
	}

	// ��·�鲢�㷨�������ź���������кϲ�Ϊһ��������
	private static void merge(int[] a, int left, int mid, int right) {
		int[] tmp = new int[a.length];// ��������
		int p1 = left, p2 = mid + 1, k = left;// p1��p2�Ǽ��ָ�룬k�Ǵ��ָ��

		while (p1 <= mid && p2 <= right) {
			if (a[p1] <= a[p2])
				tmp[k++] = a[p1++];
			else
				tmp[k++] = a[p2++];
		}

		while (p1 <= mid)
			tmp[k++] = a[p1++];// �����һ������δ����ֱ꣬�ӽ���������Ԫ�ؼӵ��ϲ���������
		while (p2 <= right)
			tmp[k++] = a[p2++];// ͬ��

		// ���ƻ�ԭ����
		for (int i = left; i <= right; i++)
			a[i] = tmp[i];
	}

	/**
	 * ��ӡ�����е�����Ԫ��
	 */
	public void display() {
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
