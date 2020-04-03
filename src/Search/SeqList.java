/**  
* <p>Title: SeqList.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) May 5, 2019</p>  
* @author 马坤  
* @date May 5, 2019  
* @version 1.0  
*/
package Search;

class SeqList {// 顺序查找表类
	private RecordNode[] r; // 顺序表记录结点数组
	private int curlen; // 顺序表长度,即记录个数
	// 顺序表的构造方法：构造一个存储空间容量为maxSize的顺序表

	public SeqList(int maxSize) {
		this.r = new RecordNode[maxSize]; // 为顺序表分配maxSize个存储单元
		this.curlen = 0; // 置顺序表的当前长度为0
	}

	// 求顺序表中的数据元素个数并由函数返回其值
	public int length() {
		return curlen; // 返回顺序表的当前长度
	}

	public int getCurlen() {
		return curlen;
	}

	public void setCurlen(int curlen) {
		this.curlen = curlen;
	}

	/*
	 * 在当前顺序表的第i个结点之前插入一个RecordNode类型的结点x，其中i取值范围为：0≤i≤curlen。如果i值不在此范围则抛出异常,当i=
	 * 0时表示在表头插入一个数据元素x, 当i=curlen时表示在表尾插入一个数据元素x
	 */
	public void insert(int i, RecordNode x) throws Exception {
		if (curlen == r.length - 1) { // 判断顺序表是否已满,0号存储单元不存放元素
			throw new Exception("顺序表已满");
		}
		if (i < 0 || i > curlen + 1) { // i小于0或者大于表长
			throw new Exception("插入位置不合理");
		}
		for (int j = curlen; j > i; j--) {
			r[j + 1] = r[j]; // 插入位置及之后的元素后移
		}
		r[i] = x; // 插入x
		this.curlen++; // 表长度增1
	}

	/* 顺序查找：从顺序表r[1]到r[n]的n个元素中顺序查找出关键字为key的记录，若查找成功返回其下标，否则返回-1 */
	public int seqSearch(Comparable key) {
		int i = 1, n = length();
		while (i < n + 1 && r[i].getKey().compareTo(key) != 0) {
			i++;
		}
		if (i < n + 1) { // 查找成功则返回该元素的下标i，否则返回-1
			return i;
		} else {
			return -1;
		}
	}

	/* 二分查找：数组元素已按升序排列，从顺序表r[1]到r[n]的n个元素中查找出关键字为key的元素，若查找成功返回元素下标，否则返回-1 */
	public int binarySearch(Comparable key) {
		if (length() > 0) {
			int low = 1, high = length(); // 查找范围的下界和上界
			while (low <= high) {
				int mid = (low + high) / 2; // 中间位置，当前比较元素位置
				// System.out.print(r[mid].getKey() + "? ");
				if (r[mid].getKey().compareTo(key) == 0) {
					return mid; // 查找成功
				} else if (r[mid].getKey().compareTo(key) > 0) { // 给定值更小
					high = mid - 1; // 查找范围缩小到前半段
				} else {
					low = mid + 1; // 查找范围缩小到后半段
				}
			}
		}
		return -1; // 查找不成功
	}
}
