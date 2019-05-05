package lists;

/**
 * @author eitanohana
 *
 */
public interface ListInterface<T> {
	
	public void add(T t);
	
	public boolean add(int index, T element);
	
	public void clear();
	
	public boolean contains(T element);
	
	public T get(int index);
	
	public int indexOf(T element);
	
	public boolean isEmpty();
	
	public T remove(int index);
	
	public void remove(T element);
	
	public int size();
	
}
