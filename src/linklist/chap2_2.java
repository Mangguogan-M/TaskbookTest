package linklist;
/**
 * 链表的应用
 * @author 马坤
 *
 */
public class chap2_2 {
	public static <T extends Comparable> void MergeList_L(linkList<T> La, linkList<T> Lb, linkList<T> Lc) {
		/*已知单链表La和Lb的元素按值非递减排列，归并La和Lb得到新的链表Lc
		 * Lc的元素也是非递减排列
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
		System.out.println("单链表a中的数据元素为：");
		La.nextOrder();
		for (j = 0; j < b.length; j++) {
			Lb.add(b[j], j+1);
		}
		System.out.println("单链表b中的数据元素为：");
		Lb.nextOrder();
		MergeList_L(La, Lb, Lc);
		System.out.println("单链表c中的数据元素为：");
		Lc.nextOrder();
	}
	
}
