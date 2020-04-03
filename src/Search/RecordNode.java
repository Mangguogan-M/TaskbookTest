/**  
* <p>Title: RecordNode.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) May 5, 2019</p>  
* @author 马坤  
* @date May 5, 2019  
* @version 1.0  
*/
package Search;

class RecordNode {// 记录结点类
	private Comparable key; // 关键字
	private Object element; // 数据元素

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

	public RecordNode(Comparable key) { // 构造方法1
		this.key = key;
	}

	public RecordNode(Comparable key, Object element) { // 构造方法2
		this.key = key;
		this.element = element;
	}

	public String toString() { // 覆盖toString()方法
		return "[" + key + "," + element + "]";
	}
}
