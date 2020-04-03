/**  
* <p>Title: SortTest.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) May 5, 2019</p>  
* @author 马坤  
* @date May 5, 2019  
* @version 1.0  
*/ 
package Sort;

public class SortTest {
	public static void main(String[] args) {
		int[] array = {3, 17, 12, 61, 8, 70, 97, 75, 53, 26, 54, 61};
		Sort s = new Sort(array);
		System.out.println("无序的数组元素");
		s.display();
		
		s.insertSort();
		System.out.println("直接插入排序:");
		s.display();
		
		s.shellSort();
		System.out.println("希尔排序:");
		s.display();
		
		s.bobSort();
		System.out.println("冒泡排序:");
		s.display();
		
		s.quickSort();
		System.out.println("快速排序:");
		s.display();
		
		s.chooseSort();
		System.out.println("选择排序:");
		s.display();
		
		s.mergeSort();
		System.out.println("归并排序:");
		s.display();
	}
	
	

}
