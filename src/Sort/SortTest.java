/**  
* <p>Title: SortTest.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) May 5, 2019</p>  
* @author ����  
* @date May 5, 2019  
* @version 1.0  
*/ 
package Sort;

public class SortTest {
	public static void main(String[] args) {
		int[] array = {3, 17, 12, 61, 8, 70, 97, 75, 53, 26, 54, 61};
		Sort s = new Sort(array);
		System.out.println("���������Ԫ��");
		s.display();
		
		s.insertSort();
		System.out.println("ֱ�Ӳ�������:");
		s.display();
		
		s.shellSort();
		System.out.println("ϣ������:");
		s.display();
		
		s.bobSort();
		System.out.println("ð������:");
		s.display();
		
		s.quickSort();
		System.out.println("��������:");
		s.display();
		
		s.chooseSort();
		System.out.println("ѡ������:");
		s.display();
		
		s.mergeSort();
		System.out.println("�鲢����:");
		s.display();
	}
	
	

}
