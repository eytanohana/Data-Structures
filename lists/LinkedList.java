package lists;

public class LinkedList<T> implements ListInterface<T>{
	
	private int size;
	private Node<T> head;
	
	public LinkedList() {
		head = new Node<T>(null);
		size = 0;
	}


	@Override
	public void add(T t) {
		Node<T> current = head;
		
		while(current.getNext() != null)
			current = current.getNext();
		
		current.setNext(new Node<T>(t));
		size++;
	}

	
	@Override
	public boolean add(int index, T element) {
		if (index < 0)
			return false;
		
		Node<T> current = head;
		Node<T> prev = head;
		
		int i = -1;
		
		while (current != null && i < index) {
			prev = current;
			current = current.getNext();
			i++;
		}
		
		prev.setNext(new Node<T>(element, current));
		size++;
		
		return true;
	}

	
	@Override
	public void clear() {
		head.setNext(null);
		size = 0;
	}

	@Override
	public boolean contains(T element) {
		Node<T> current = head;
		
		while (current.getNext() != null && current.getData() != element) 
			current = current.getNext();
		
		return current.getData() == element;
	}

	@Override
	public T get(int index) {
		if (index < 0 || index > size)
			return null;
		
		Node<T> current = head;
		
		int i = -1;
		while (current.getNext() != null && i < index) {
			current = current.getNext();
			i++;
		}
		return current.getData();
	}

	@Override
	public int indexOf(T element) {
		int index = 0;
		
		Node<T> current = head.getNext();
		
		while (current != null && !current.getData().equals(element)) {
			current = current.getNext();
			index++;
		}
		
		return current != null && current.getData().equals(element) ? index : -1;
	}

	@Override
	public int isEmpty() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(T element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node<T> current = head;
		while(current.getNext() != null) {
			current = current.getNext();
			sb.append(current.getData() + " -> ");
		}
		sb.append("\\\\");
		return sb.toString();
	}

}
