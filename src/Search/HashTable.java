/**  
* <p>Title: HashTable.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) May 5, 2019</p>  
* @author 马坤  
* @date May 5, 2019  
* @version 1.0  
*/
package Search;

/**
 * 采用开放地址法的哈希表类
 */
class HashTable {
	private RecordNode[] table; // 哈希表的对象数组

	public HashTable(int size) { // 构造指定大小的哈希表
		this.table = new RecordNode[size];
		for (int i = 0; i < table.length; i++) {
			table[i] = new RecordNode(0);
		}
	}

	public int hash(int key) { // 除留余法数哈希函数
		return key % 19;
	}

	/**、
	 * 开放地址哈希表的查找
	 */
	public RecordNode hashSearch(int key) {
		int i = hash(key); // 求哈希地址
		int j = 0;
		while ((table[i].getKey().compareTo(0) != 0) && (table[i].getKey().compareTo(key) != 0) && (j < table.length)) {
			// 该位置中不为空并且关键字与key不相等
			j++;
			i = (i + j) % 20; // 用线性探测再散列法求得下一探测地址
		} // i指示查找到的记录在表中的存储位置或指示插入位置
		if (j >= table.length) { // 如果表已经为满
			System.out.println("哈希表已满");
			return null;
		} else
			return table[i];
	}

	/**
	 * 开放地址哈希表的插入
	 */
	public void hashInsert(int key) {
		RecordNode p = hashSearch(key);
		if (p.getKey().compareTo(0) == 0)
			p.setKey(key); // 插入
		else
			System.out.println(" 此关键字记录已存在或哈希表已满");

	}

	/**
	 * 哈希表的输出
	 */
	void Hashdisplay() {
		for (int i = 0; i < table.length; i++)
			System.out.print(table[i].getKey().toString() + "  ");
		System.out.println();
	}
}
