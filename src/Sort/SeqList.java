/**  
* <p>Title: SeqList.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) May 5, 2019</p>  
* @author 马坤  
* @date May 5, 2019  
* @version 1.0  
*/
package Sort;

import java.util.Arrays;

//顺序排序表类
class SeqList {
	CopareMoveNum[] cm; // 比较和移动次数
	private RecordNode[] r; // 顺序表记录结点数组
	private int curlen; // 顺序表长度,即记录个数

	public RecordNode[] getRecord() {
		return r;
	}

	public void setRecord(RecordNode[] r) {
		this.r = r;
	}

	// 顺序表的构造方法：构造一个存储空间容量为maxSize的顺序表，同时建立记录比较与移动次数的数组对象并赋初值
	public SeqList(int maxSize) {
		this.r = new RecordNode[maxSize]; // 为顺序表分配maxSize个存储单元
		this.curlen = 0; // 置顺序表的当前长度为0
		this.cm = new CopareMoveNum[3]; // 记录比较和移动次数的数组
		for (int i = 0; i < 3; i++) { // 数组初始化为0
			this.cm[i] = new CopareMoveNum();
			this.cm[i].setCpn(0);
			this.cm[i].setMvn(0);
		}
	}

	// 求顺序表中的数据元素个数并由函数返回其值
	public int length() {
		return curlen; // 返回顺序表的当前长度
	}

	// 在当前顺序表的第i个结点之前插入一个RecordNode类型的结点x
	// 其中i取值范围为：0≤i≤length()。
	// 如果i值不在此范围则抛出异常,当i=0时表示在表头插入一个数据元素x,
	// 当i=length()时表示在表尾插入一个数据元素x
	public void insert(int i, RecordNode x) throws Exception {
		if (curlen == r.length) { // 判断顺序表是否已满
			throw new Exception("顺序表已满");
		}
		if (i < 0 || i > curlen) { // i小于0或者大于表长
			throw new Exception("插入位置不合理");
		}
		for (int j = curlen; j > i; j--) {
			r[j] = r[j - 1]; // 插入位置及之后的元素后移
		}
		r[i] = x; // 插入x
		this.curlen++; // 表长度增1
	}

	// 输出数组元素
	public void display() {
		for (int i = 0; i < this.curlen; i++) {
			System.out.print(" " + r[i].getKey().toString());
		}
		System.out.println();
	}

	/**
	 * 不带监视哨的直接插入排序算法
	 */
	public void insertSort() {
		RecordNode temp;
		int i, j;
		for (i = 1; i < this.curlen; i++) {// n-1趟扫描
			temp = r[i]; // 将待插入的第i条记录暂存在temp中
			cm[0].setMvn(cm[0].getMvn() + 1); // 移动次数加1;
			for (j = i - 1; j >= 0 && temp.getKey().compareTo(r[j].getKey()) < 0; j--) { // 将前面比r[i]大的记录向后移动
				cm[0].setCpn(cm[0].getCpn() + 1); // 比较次数加1
				r[j + 1] = r[j];
				cm[0].setMvn(cm[0].getMvn() + 1); // 移动次数加1;
			}
			r[j + 1] = temp; // r[i]插入到第j+1个位置
			cm[0].setMvn(cm[0].getMvn() + 1); // 移动次数加1;
		}
	}

	/**
	 * 冒泡排序算法
	 */
	public void bubbleSort() {
		RecordNode temp; // 辅助结点
		boolean flag = true; // 是否交换的标记
		for (int i = 1; i < this.curlen && flag; i++) { // 有交换时再进行下一趟，最多n-1趟
			flag = false; // 假定元素未交换
			for (int j = 0; j < this.curlen - i; j++) { // 一次比较、交换
				cm[1].setCpn(cm[1].getCpn() + 1); // 比较次数加1
				if (r[j].getKey().compareTo(r[j + 1].getKey()) > 0) { // 逆序时，交换
					temp = r[j];
					r[j] = r[j + 1];
					r[j + 1] = temp;
					cm[1].setMvn(cm[1].getMvn() + 3); // 移动次数加3;
					flag = true;
				}
			}
		}
	}

	/**
	 * 简单选择排序
	 */
	public void selectSort() {
		RecordNode temp; // 辅助结点
		for (int i = 0; i < this.curlen - 1; i++) {// n-1趟排序
			// 每趟在从r[i]开始的子序列中寻找最小元素
			int min = i; // 设第i条记录的关键字最小
			for (int j = i + 1; j < this.curlen; j++) {// 在子序列中选择关键字最小的记录
				cm[2].setCpn(cm[2].getCpn() + 1); // 比较次数加1
				if (r[j].getKey().compareTo(r[min].getKey()) < 0) {
					min = j; // 记住关键字最小记录的下标
				}
			}
			if (min != i) { // 将本趟关键字最小的记录与第i条记录交换
				temp = r[i];
				r[i] = r[min];
				r[min] = temp;
				cm[2].setMvn(cm[2].getMvn() + 3); // 移动次数加3;
			}
		}
	}

	/**
	 * 希尔排序
	 */
	public void shellSort(int[] arr) {
		// i表示希尔排序中的第n/2+1个元素（或者n/4+1）
		// j表示希尔排序中从0到n/2的元素（n/4）
		// r表示希尔排序中n/2+1或者n/4+1的值
		int i, j, r, tmp;
		// 划组排序
		for (r = arr.length / 2; r >= 1; r = r / 2) {
			for (i = r; i < arr.length; i++) {
				tmp = arr[i];
				j = i - r;
				// 一轮排序
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
