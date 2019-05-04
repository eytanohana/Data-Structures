package lists;

public class Node<T> {

	private T data;
	private Node<T> next;
	
	public Node(T data, Node<T> next) {
		this.data = data;
		this.setNext(next);
	}
	
	public Node(T data) {
		this(data, null);
	}
	
	
	public T getData() {
		return this.data;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}
	
}
