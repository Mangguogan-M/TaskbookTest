/**  
* <p>Title: Sort.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) May 5, 2019</p>  
* @author 马坤  
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
	 * 直接插入排序
	 */
	public void insertSort() {
		for (int index = 1; index < length; index++) {// 外层向右的index，即作为比较对象的数据的index
			int temp = array[index];// 用作比较的数据
			int leftindex = index - 1;
			while (leftindex >= 0 && array[leftindex] > temp) {// 当比到最左边或者遇到比temp小的数据时，结束循环
				array[leftindex + 1] = array[leftindex];
				leftindex--;
			}
			array[leftindex + 1] = temp;// 把temp放到空位上
		}
	}

	/**
	 * 希尔排序
	 */
	public void shellSort() {
		// i表示希尔排序中的第n/2+1个元素（或者n/4+1）
		// j表示希尔排序中从0到n/2的元素（n/4）
		// r表示希尔排序中n/2+1或者n/4+1的值
		int i, j, r, tmp;
		// 划组排序
		for (r = length / 2; r >= 1; r = r / 2) {
			for (i = r; i < length; i++) {
				tmp = array[i];
				j = i - r;
				// 一轮排序
				while (j >= 0 && tmp < array[j]) {
					array[j + r] = array[j];
					j -= r;
				}
				array[j + r] = tmp;
			}
		}
	}

	/**
	 * 冒泡排序
	 */
	public void bobSort() {
		for (int i = 0; i < length - 1; i++) {// 排序轮数
			for (int j = 0; j < length - 1 - i; j++) {// 比较次数
				if (array[j] > array[j + 1]) {
					int temp = array[j + 1];
					array[j + 1] = array[j];
					array[j] = temp;
				}
			}
		}
	}

	/**
	 * 快速排序
	 */
	public void quickSort() {
		quickSort(array, 0, array.length - 1);
	}

	private static void quickSort(int[] arr, int left, int right) {
		int t;
		int ltemp = left;
		int rtemp = right;
		// 分界值
		int fIndex = arr[(left + right) / 2];
		while (ltemp < rtemp) {
			// 从左侧开始查找比分界值大的数
			while (arr[ltemp] < fIndex) {
				// 元素小于分界值，继续查找
				++ltemp;
			}
			// 从右侧开始查找比分界值小的数
			while (arr[rtemp] > fIndex) {
				// 元素大于分界值，继续查找
				--rtemp;
			}
			// 如果查到的比分界值大的数的下标小于等于比分界值小的数的下标，则进行交换
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
	 * 选择排序
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
	 * 归并排序
	 */
	public void mergeSort() {
		mergeSort(array, 0, length - 1);
	}

	private static void mergeSort(int[] a, int start, int end) {
		if (start < end) {// 当子序列中只有一个元素时结束递归
			int mid = (start + end) / 2;// 划分子序列
			mergeSort(a, start, mid);// 对左侧子序列进行递归排序
			mergeSort(a, mid + 1, end);// 对右侧子序列进行递归排序
			merge(a, start, mid, end);// 合并
		}
	}

	// 两路归并算法，两个排好序的子序列合并为一个子序列
	private static void merge(int[] a, int left, int mid, int right) {
		int[] tmp = new int[a.length];// 辅助数组
		int p1 = left, p2 = mid + 1, k = left;// p1、p2是检测指针，k是存放指针

		while (p1 <= mid && p2 <= right) {
			if (a[p1] <= a[p2])
				tmp[k++] = a[p1++];
			else
				tmp[k++] = a[p2++];
		}

		while (p1 <= mid)
			tmp[k++] = a[p1++];// 如果第一个序列未检测完，直接将后面所有元素加到合并的序列中
		while (p2 <= right)
			tmp[k++] = a[p2++];// 同上

		// 复制回原素组
		for (int i = left; i <= right; i++)
			a[i] = tmp[i];
	}

	/**
	 * 打印数组中的所有元素
	 */
	public void display() {
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
