/**  
* <p>Title: RecordNode.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) May 5, 2019</p>  
* @author ����  
* @date May 5, 2019  
* @version 1.0  
*/
package Search;

class RecordNode {// ��¼�����
	private Comparable key; // �ؼ���
	private Object element; // ����Ԫ��

	public Object getElement() {
		return element;
	}

	public void setElement(Object element) {
		this.element = element;
	}

	public Comparable getKey() {
		return key;
	}

	public void setKey(Comparable key) {
		this.key = key;
	}

	public RecordNode(Comparable key) { // ���췽��1
		this.key = key;
	}

	public RecordNode(Comparable key, Object element) { // ���췽��2
		this.key = key;
		this.element = element;
	}

	public String toString() { // ����toString()����
		return "[" + key + "," + element + "]";
	}
}
