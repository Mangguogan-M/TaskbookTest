package linklist;

public class Test4 {
	public static void main(String[] args) {
		linkList<Integer> L = new linkList<Integer>();
		int i;
		int a[] = {23, 56, 12, 49, 35};
		for (i = 0; i < a.length; i++) {
			L.add(a[i], i+1);
		}
		System.out.println("�������е�����Ϊ��");
		L.nextOrder();
		L.add(30, 4);
		System.out.println("ִ�в�����������������Ϊ��");
		L.nextOrder();
		L.remove(5);
		System.out.println("ִ��ɾ�������������е�����Ԫ��Ϊ��");
		L.nextOrder();
		i = L.find(12);
		System.out.println("Ԫ��12�ڵ������е�Ϊ��Ϊ��" + i);
	}
	
	
}
