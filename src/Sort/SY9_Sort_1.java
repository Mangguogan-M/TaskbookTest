/**  
* <p>Title: bubbleSort.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) May 5, 2019</p>  
* @author 马坤  
* @date May 5, 2019  
* @version 1.0  
*/
package Sort;

import java.util.Scanner;

//测试类
public class SY9_Sort_1 {
	static SeqList ST = null;

	// 建立待排序的顺序表
	public static void createSearchList() throws Exception {
		ST = new SeqList(20);
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入排序表的表长:");
		int n = sc.nextInt();
		KeyType[] k = new KeyType[n];
		System.out.print("请输入排序表中的关键字序列:");
		for (int i = 0; i < n; i++) { // 输入关键字序列
			k[i] = new KeyType(sc.nextInt());
		}
		for (int i = 0; i < n; i++) { // 创建顺序排序表
			RecordNode r = new RecordNode(k[i]);
			ST.insert(i, r);
		}
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		// System.out.println("创建顺序查找表");
		// createSearchList();
		while (true) {
			System.out.println(" 1--直接插入排序    2--冒泡排序    3--简单选择排序    4--退出");
			System.out.print("请输入选择(1-4):");
			int i = sc.nextInt();
			switch (i) {
			case 1:
				System.out.println("---直接插入排序---");
				System.out.println("创建顺序排序表");
				createSearchList();
				ST.insertSort();
				System.out.print("排序结果:");
				ST.display();
				System.out.println("比较次数为:" + ST.cm[0].getCpn());
				System.out.println("移动次数为:" + ST.cm[0].getMvn());
				break;
			case 2:
				System.out.println("---冒泡排序---");
				System.out.println("创建顺序排序表");
				createSearchList();
				ST.bubbleSort();
				System.out.print("排序结果:");
				ST.display();
				System.out.println("比较次数为:" + ST.cm[1].getCpn());
				System.out.println("移动次数为:" + ST.cm[1].getMvn());
				break;
			case 3:
				System.out.print("---简单选择排序---");
				System.out.println("创建顺序排序表");
				createSearchList();
				ST.selectSort();
				System.out.print("排序结果:");
				ST.display();
				System.out.println("比较次数为:" + ST.cm[2].getCpn());
				System.out.println("移动次数为:" + ST.cm[2].getMvn());
				break;
			case 4:
				return;
			}
		}
	}
}
