/**  
* <p>Title: KeyType.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) May 5, 2019</p>  
* @author ����  
* @date May 5, 2019  
* @version 1.0  
*/
package Search;

class KeyType implements Comparable<KeyType> { // ��¼�ؼ�����
	private int key; // �ؼ���

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

	public String toString() { // ����toString()����
		return key + "";
	}

	public int compareTo(KeyType another) { // ����Comparable�ӿ��бȽϹؼ��ִ�С�ķ���
		int thisVal = this.key;
		int anotherVal = another.key;
		return (thisVal < anotherVal ? -1 : (thisVal == anotherVal ? 0 : 1));
	}
}
