/**  
* <p>Title: hanluo.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.baidudu.com</p>  
* @author shenlan  
* @date Apr 20, 2019  
* @version 1.0  
*/

/**  
* <p>Title: hanluo</p>  
* <p>Description: </p>  
* @author 马坤  
* @date Apr 20, 2019  
*/
public class Hanoi {
	public void move(char X, int n, char Z) {
		//从X上将n个圆盘有移动到Z上
		System.out.println("将"+ X +"塔上的" + n + "个圆盘移动到" + Z + "上！");
	}
	public void Hanoi(int n, char X,char Y,char Z) {
		//将X上n个圆盘借助于Y塔移动到Z上
		if (n == 1) {
			move(X, 1, Z);
		}else {
			Hanoi(n-1, X, Z, Y);
			move(X, 1, Z);
			Hanoi(n-1, Y, X, Z);
		}
	}
	public static void main(String[] args) {
		Hanoi hanoi = new Hanoi();
		hanoi.Hanoi(3, 'X', 'Y', 'Z');
	}
}
