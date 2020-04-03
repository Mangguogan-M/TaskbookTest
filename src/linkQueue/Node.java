package linkQueue;

public class Node<T> {	//½ÚµãÀà
	T data;
	Node<T> next;
	public Node(Node<T> n) {
		next = n;
	}
	public Node(T obj, Node<T> n) {
		data = obj;
		next = n;
	}
	public T getData() {
		return data;
	}
	public Node<T> getNext(){
		return next;
	}
}
