package lists;

/**
 * @author eitanohana
 *
 */
 public interface ListInterface<T> {
	
	void add(T t);
	
	boolean add(T element, int index);
	
	 void clear();
	
	 boolean contains(T element);
	
	 T get(int index);
	
	 int indexOf(T element);
	
	 boolean isEmpty();
	
	 T remove(int index);
	
	 void remove(T element);
	
	 int size();
	
}
