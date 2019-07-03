package lists;

public class LinkedList<T> implements ListInterface<T>{
	
	int size;
	Node<T> head;

	/**
	 * Establishes a new LinkedList with a pointer "head" to the empty list.
	 */
	public LinkedList() {
		head = new Node<>(null);
		size = 0;
	}

	/**
	 * Adds a new elements to the end of the list.
	 * @param element The element to add.
	 */
	@Override
	public void add(T element) {
		Node<T> current = head;
		
		while(current.getNext() != null)
			current = current.getNext();
		
		current.setNext(new Node<>(element));
		size++;
	}

	/**
	 * Adds an elements at the specified index. If the index is less than 0,
	 * then it returns false. Otherwise if the index is greater than the size,
	 * then just add it to the end.
	 *
	 * @param index The index of the new elements to add.
	 * @param element The element to add.
	 * @return true if the element was added, false otherwise.
	 */
	@Override
	public boolean add(T element, int index) {
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
		
		prev.setNext(new Node<>(element, current));
		size++;
		
		return true;
	}

	public void addFirst(T element) {
		add(element, 0);
	}

	public void addLast(T element) {
		add(element, size);
	}

	/**
	 * Clears the entire list.
	 */
	@Override
	public void clear() {
		head.setNext(null);
		size = 0;
	}

	/**
	 * Checks whether a certain element is contained in the given list.
	 *
	 * @param element The element to search for.
	 * @return True if the element is in the list, false otherwise.
	 */
	@Override
	public boolean contains(T element) {
		Node<T> current = head;
		
		while (current.getNext() != null && current.getData() != element) 
			current = current.getNext();
		
		return current.getData() == element;
	}

	/**
	 * Retrieves the element at the specified index.
	 *
	 * @param index The index of the element.
	 * @return The element itself.
	 */
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

	public T getFirst() {
		return get(0);
	}

	public T getLast() {
		return get(size-1);
	}


	/**
	 * @param element The element to look fpr
	 * @return The index of the first occurrence of the given element.
	 * or -1 if it's not in the list.
	 */
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

	/**
	 * Checks whether the list is empty.
	 *
	 * @return True if it's empty, false otherwise.
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Removes the element at the specified index.
	 *
	 * @param index The index of the element to remove.
	 * @return The removed element if there was one. otherwise null
	 */
	@Override
	public T remove(int index) {
		if (index < 0 || index >= size)
			return null;
		
		int i = -1;
		
		Node<T> current = head;
		Node<T> prev = head;
		
		while (current.getNext() != null && i < index) {
			prev = current;
			current = current.getNext();
			i++;
		}
		
		T element = current.getData();
		prev.setNext(current.getNext());
		size--;
		
		return element;
	}

	/**
	 * Removes the first occurrence of the specified element from the list.
	 * @param element The element to remove.
	 */
	@Override
	public void remove(T element) {
		remove(indexOf(element));
	}

	/**
	 * @return The size of the list.
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * @return A String representation of the list.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node<T> current = head;
		while(current.getNext() != null) {
			current = current.getNext();
			sb.append(current.getData());
			sb.append(" -> ");
		}
		sb.append("\\\\");
		return sb.toString();
	}



	public static void main(String[] args) {
		LinkedList<Integer> ls = new LinkedList<>();

		for (int i = 0; i < 10; i++)
			ls.add(i);

		ls.addLast(-1);

		System.out.println(ls);

		ls.add(6, 0);
		System.out.println(ls);

		ls.add(90 ,11);
		System.out.println(ls);

		System.out.println(ls.contains(11));

		System.out.println(ls.get(10));

		System.out.println(ls.indexOf(9));

		System.out.println(ls);
		ls.remove(0);
		System.out.println(ls);


		ls.remove(0);
		System.out.println(ls);
		System.out.println(ls.size());

		System.out.println(ls.getLast());
		System.out.println(ls.getFirst());
	}

}
