package linklist;

public class Test4 {
	public static void main(String[] args) {
		linkList<Integer> L = new linkList<Integer>();
		int i;
		int a[] = {23, 56, 12, 49, 35};
		for (i = 0; i < a.length; i++) {
			L.add(a[i], i+1);
		}
		System.out.println("单链表中的数据为：");
		L.nextOrder();
		L.add(30, 4);
		System.out.println("执行插入操作后单链表的数据为：");
		L.nextOrder();
		L.remove(5);
		System.out.println("执行删除操作后单链表中的数据元素为：");
		L.nextOrder();
		i = L.find(12);
		System.out.println("元素12在单链表中的为序为：" + i);
	}
	
	
}
