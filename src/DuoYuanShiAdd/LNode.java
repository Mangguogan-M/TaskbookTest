package DuoYuanShiAdd;

public class LNode<T> {
    //����
    private T data;
    //��һ���ڵ�
    private  LNode<T> next;
    
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LNode<T> getNext() {
        return next;
    }

    public void setNext(LNode<T> next) {
        this.next = next;
    }
}
