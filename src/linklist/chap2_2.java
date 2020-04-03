package linklist;
/**
 * �����Ӧ��
 * @author ����
 *
 */
public class chap2_2 {
	public static <T extends Comparable> void MergeList_L(linkList<T> La, linkList<T> Lb, linkList<T> Lc) {
		/*��֪������La��Lb��Ԫ�ذ�ֵ�ǵݼ����У��鲢La��Lb�õ��µ�����Lc
		 * Lc��Ԫ��Ҳ�Ƿǵݼ�����
		 */
		Node<T> pa, pb, pc;
		pa = La.getHead().next;
		pb = Lb.getHead().next;
		pc = Lc.getHead();
		while (pa != null && pb != null) {
			if (pa.data.compareTo(pb.data) <= 0) {
				pc.next = pa;
				pc = pa;
				pa = pa.next;
			}else {
				pc.next = pb;
				pc = pb;
				pb = pb.next;
			}
		}
		while (pa != null) {
			pc.next = pa;
			pc = pa;
			pa = pa.next;
		}
		while (pb != null) {
			pc.next = pb;
			pc = pb;
			pb = pb.next;
		}
		La.clear();
		Lb.clear();
	}
	public static void main(String[] args) {
		int i, j, k;
		int[] a = {12, 23, 35, 49, 56};
		int[] b = {10, 15, 20};
		linkList<Integer> La = new linkList<>();
		linkList<Integer> Lb = new linkList<>();
		linkList<Integer> Lc = new linkList<>();
		for (i = 0; i < a.length; i++) {
			La.add(a[i], i+1);
		}
		System.out.println("������a�е�����Ԫ��Ϊ��");
		La.nextOrder();
		for (j = 0; j < b.length; j++) {
			Lb.add(b[j], j+1);
		}
		System.out.println("������b�е�����Ԫ��Ϊ��");
		Lb.nextOrder();
		MergeList_L(La, Lb, Lc);
		System.out.println("������c�е�����Ԫ��Ϊ��");
		Lc.nextOrder();
	}
	
}
