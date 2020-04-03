/**  
* <p>Title: SY5Test.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) May 11, 2019</p>  
* @author 马坤  
* @date May 11, 2019  
* @version 1.0  
*/ 
package SY5;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class SY5Test {
	public static void main(String[] args) {
		Student stu1=new Student(20080808, "张三", "男", 12232613, "信管");
		Student stu2=new Student(20100203, "李四", "女", 3678263, "信息");
		Student stu3=new Student(20071010, "王五", "男", 32565645, "旅游");
		Student stu4=new Student(20080113, "朱六", "女", 6437657, "外语");
		Student stu5=new Student(20101030, "赵七", "男", 46357686, "国贸");
		Map<String,Student> map=new HashMap<String,Student>();
		map.put("20080808",stu1);
		map.put("20100203",stu2);
		map.put("20071010",stu3);
		map.put("20080113",stu4);
		map.put("20101030",stu5);
		String str=map.toString();
		byte b[]=str.getBytes();
		System.out.print("请输入学号:");
		Scanner input = new Scanner(System.in);
		String id = input.nextLine();
		Student val=map.get(id);
		System.out.println("学号为" + id + "学生的信息是:\n"+val);
//		System.out.println("全部的学生信息为：");
//		Collection<Student> values=map.values();
//		Iterator<Student> iter=values.iterator();
//		while(iter.hasNext()){
//		Student str1=iter.next();
//		System.out.println(str1);
//		}
		
	}

}
