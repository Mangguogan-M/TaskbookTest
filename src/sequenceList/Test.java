package sequenceList;
public class Test {
	public static <T extends Comparable> void MergeList_Sq(sequenceList<T> LA, sequenceList<T> LB, sequenceList<T> LC) {
		int i = 1, j = 1, k = 1;
		while (i <= LA.size() && j <= LB.size()) {
			if (LA.value(i).compareTo(LB.value(j)) <= 0) {
				LC.add(LA.value(i), k);
				i++;
			} else {
				LC.add(LB.value(j), k);
				j++;
			}
			k++;
		}
		while (i <= LA.size()) {
			LC.add(LA.value(i), k);
			i++;
			k++;
		}
		while (j <= LB.size()) {
			LC.add(LB.value(j), k);
			j++;
			k++;
		}
	}

	public static void main(String[] args) {
		int[] a = { 12, 23, 35, 49, 56 };
		int[] b = { 10, 15, 20 };
		sequenceList<Integer> La = new sequenceList<Integer>();
		sequenceList<Integer> Lb = new sequenceList<Integer>();
		sequenceList<Integer> Lc = new sequenceList<Integer>();
		for (int i = 0; i < a.length; i++) {
			La.add(a[i], i + 1);
		}
		System.out.println("顺序表a中的元素为：");
		La.nextOrder();
		for (int j = 0; j < b.length; j++) {
			Lb.add(b[j], j + 1);
		}
		System.out.println("顺序表b中的元素为：");
		Lb.nextOrder();
		MergeList_Sq(La, Lb, Lc);
		System.out.println("顺序表c中的元素为：");
		Lc.nextOrder();
	}
}
