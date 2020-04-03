/**  
* <p>Title: SeqList.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) May 5, 2019</p>  
* @author ����  
* @date May 5, 2019  
* @version 1.0  
*/
package Search;

class SeqList {// ˳����ұ���
	private RecordNode[] r; // ˳����¼�������
	private int curlen; // ˳�����,����¼����
	// ˳���Ĺ��췽��������һ���洢�ռ�����ΪmaxSize��˳���

	public SeqList(int maxSize) {
		this.r = new RecordNode[maxSize]; // Ϊ˳������maxSize���洢��Ԫ
		this.curlen = 0; // ��˳���ĵ�ǰ����Ϊ0
	}

	// ��˳����е�����Ԫ�ظ������ɺ���������ֵ
	public int length() {
		return curlen; // ����˳���ĵ�ǰ����
	}

	public int getCurlen() {
		return curlen;
	}

	public void setCurlen(int curlen) {
		this.curlen = curlen;
	}

	/*
	 * �ڵ�ǰ˳���ĵ�i�����֮ǰ����һ��RecordNode���͵Ľ��x������iȡֵ��ΧΪ��0��i��curlen�����iֵ���ڴ˷�Χ���׳��쳣,��i=
	 * 0ʱ��ʾ�ڱ�ͷ����һ������Ԫ��x, ��i=curlenʱ��ʾ�ڱ�β����һ������Ԫ��x
	 */
	public void insert(int i, RecordNode x) throws Exception {
		if (curlen == r.length - 1) { // �ж�˳����Ƿ�����,0�Ŵ洢��Ԫ�����Ԫ��
			throw new Exception("˳�������");
		}
		if (i < 0 || i > curlen + 1) { // iС��0���ߴ��ڱ�
			throw new Exception("����λ�ò�����");
		}
		for (int j = curlen; j > i; j--) {
			r[j + 1] = r[j]; // ����λ�ü�֮���Ԫ�غ���
		}
		r[i] = x; // ����x
		this.curlen++; // ������1
	}

	/* ˳����ң���˳���r[1]��r[n]��n��Ԫ����˳����ҳ��ؼ���Ϊkey�ļ�¼�������ҳɹ��������±꣬���򷵻�-1 */
	public int seqSearch(Comparable key) {
		int i = 1, n = length();
		while (i < n + 1 && r[i].getKey().compareTo(key) != 0) {
			i++;
		}
		if (i < n + 1) { // ���ҳɹ��򷵻ظ�Ԫ�ص��±�i�����򷵻�-1
			return i;
		} else {
			return -1;
		}
	}

	/* ���ֲ��ң�����Ԫ���Ѱ��������У���˳���r[1]��r[n]��n��Ԫ���в��ҳ��ؼ���Ϊkey��Ԫ�أ������ҳɹ�����Ԫ���±꣬���򷵻�-1 */
	public int binarySearch(Comparable key) {
		if (length() > 0) {
			int low = 1, high = length(); // ���ҷ�Χ���½���Ͻ�
			while (low <= high) {
				int mid = (low + high) / 2; // �м�λ�ã���ǰ�Ƚ�Ԫ��λ��
				// System.out.print(r[mid].getKey() + "? ");
				if (r[mid].getKey().compareTo(key) == 0) {
					return mid; // ���ҳɹ�
				} else if (r[mid].getKey().compareTo(key) > 0) { // ����ֵ��С
					high = mid - 1; // ���ҷ�Χ��С��ǰ���
				} else {
					low = mid + 1; // ���ҷ�Χ��С������
				}
			}
		}
		return -1; // ���Ҳ��ɹ�
	}
}
