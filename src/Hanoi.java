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
* @author ����  
* @date Apr 20, 2019  
*/
public class Hanoi {
	public void move(char X, int n, char Z) {
		//��X�Ͻ�n��Բ�����ƶ���Z��
		System.out.println("��"+ X +"���ϵ�" + n + "��Բ���ƶ���" + Z + "�ϣ�");
	}
	public void Hanoi(int n, char X,char Y,char Z) {
		//��X��n��Բ�̽�����Y���ƶ���Z��
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
