package lists;

public class Node<T> {

	private T data;
	private Node next;
	
	public Node(T data, Node next) {
		this.data = data;
		this.setNext(next);
	}
	
	public Node(T data) {
		this(data, null);
	}
	
	
	public T getData() {
		return this.data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
}
