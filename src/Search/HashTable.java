/**  
* <p>Title: HashTable.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) May 5, 2019</p>  
* @author ����  
* @date May 5, 2019  
* @version 1.0  
*/
package Search;

/**
 * ���ÿ��ŵ�ַ���Ĺ�ϣ����
 */
class HashTable {
	private RecordNode[] table; // ��ϣ��Ķ�������

	public HashTable(int size) { // ����ָ����С�Ĺ�ϣ��
		this.table = new RecordNode[size];
		for (int i = 0; i < table.length; i++) {
			table[i] = new RecordNode(0);
		}
	}

	public int hash(int key) { // �����෨����ϣ����
		return key % 19;
	}

	/**��
	 * ���ŵ�ַ��ϣ��Ĳ���
	 */
	public RecordNode hashSearch(int key) {
		int i = hash(key); // ���ϣ��ַ
		int j = 0;
		while ((table[i].getKey().compareTo(0) != 0) && (table[i].getKey().compareTo(key) != 0) && (j < table.length)) {
			// ��λ���в�Ϊ�ղ��ҹؼ�����key�����
			j++;
			i = (i + j) % 20; // ������̽����ɢ�з������һ̽���ַ
		} // iָʾ���ҵ��ļ�¼�ڱ��еĴ洢λ�û�ָʾ����λ��
		if (j >= table.length) { // ������Ѿ�Ϊ��
			System.out.println("��ϣ������");
			return null;
		} else
			return table[i];
	}

	/**
	 * ���ŵ�ַ��ϣ��Ĳ���
	 */
	public void hashInsert(int key) {
		RecordNode p = hashSearch(key);
		if (p.getKey().compareTo(0) == 0)
			p.setKey(key); // ����
		else
			System.out.println(" �˹ؼ��ּ�¼�Ѵ��ڻ��ϣ������");

	}

	/**
	 * ��ϣ������
	 */
	void Hashdisplay() {
		for (int i = 0; i < table.length; i++)
			System.out.print(table[i].getKey().toString() + "  ");
		System.out.println();
	}
}
