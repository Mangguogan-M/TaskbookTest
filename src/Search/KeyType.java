/**  
* <p>Title: KeyType.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) May 5, 2019</p>  
* @author 马坤  
* @date May 5, 2019  
* @version 1.0  
*/
package Search;

class KeyType implements Comparable<KeyType> { // 记录关键字类
	private int key; // 关键字

	public KeyType() {
	}

	public KeyType(int key) {
		this.key = key;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String toString() { // 覆盖toString()方法
		return key + "";
	}

	public int compareTo(KeyType another) { // 覆盖Comparable接口中比较关键字大小的方法
		int thisVal = this.key;
		int anotherVal = another.key;
		return (thisVal < anotherVal ? -1 : (thisVal == anotherVal ? 0 : 1));
	}
}
