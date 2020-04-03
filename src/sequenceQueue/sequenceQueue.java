package sequenceQueue;
/**
 * 循环顺序队列
 * @author 马坤
 *
 */

import sequenceStack.sequenceStack;

public class sequenceQueue<T> {
	final int MaxSize = 10;
	private T queueArray[];
	private int front, rear;

	public sequenceQueue() {
		front = rear = 0;
		queueArray = (T[]) new Object[MaxSize];
	}
	
	public void EnQueue(T obj) {
		if ((rear + 1)% queueArray.length == front) {
			T[] p = (T[]) new Object[queueArray.length*2];
			if (rear == ((T[])queueArray).length - 1) {
				for (int i = 1; i <= rear; i++) {
					p[i] = queueArray[i];
				}
			}else {
				int j = 1;
				for (int i = front+1; i < queueArray.length; i++, j++) {
					p[j] = queueArray[i];
				}
				for (int i = 0; i <= rear; i++, j++) {
					p[j] = queueArray[i];
				}
				front = 0;
				rear = queueArray.length-1;
			}
			queueArray = p;
		}
		rear = (rear+1)%queueArray.length;
		queueArray[rear] = obj;
	}
	public T DeQueue() {
		if (isEmpty()) {
			System.out.println("队列已空，无法出对！");
			return null;
		}
		front = (front+1)%queueArray.length;
		return queueArray[front];
	}
	public T GetTop() {
		if (isEmpty()) {
			System.out.println("队列已空，无法出对！");
			return null;
		}
		return queueArray[(front+1)%queueArray.length];
	}
	
	public boolean isEmpty() {
		return front == rear;
	}
	public int size() {
		return (rear - front + queueArray.length)%queueArray.length;
	}
	public void nextOrder() {
		int i, j = front;
		for (i = 1; i <= size(); i++) {
			j = (j + 1)%queueArray.length;
			System.out.println(queueArray[j]);
		}
	}
	public void clear() {
		front = rear = 0;
	}
}
