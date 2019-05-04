package lists;

public class LinkedList<T> implements ListInterface<T>{
	
	private int size;
	private Node<T> head;
	
	public LinkedList() {
		head = new Node<T>(null);
		size = 0;
	}


	@SuppressWarnings("unchecked")
	@Override
	public void add(T t) {
		Node<T> current = head;
		
		while(current.getNext() != null)
			current = current.getNext();
		
		current.setNext(new Node<T>(t));
		size++;
	}

	@Override
	public void add(int index, T element) {
		// TODO Auto-generated method stub
		int counter = 0;
		Node<T> current = head;
	
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(T element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(T element) {
		// TODO Auto-generated method stub
		return 0;
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
	
	@SuppressWarnings("unchecked")
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
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> ls = new LinkedList<>();
		System.out.println(ls);
		
		for (int i = 0; i < 10; i++)
			ls.add(i);
		
		System.out.println(ls);
	}

}
