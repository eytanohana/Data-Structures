package lists;

/**
 * @author eitanohana
 * @author barakdimand
 *
 */
 public interface ListInterface<T> {

	/**
	 * Adds a new elements to the end of the list.
	 * @param element The element to add.
	 */
	void add(T element);

	/**
	 * Adds an elements at the specified index. If the index is less than 0,
	 * then it returns false. Otherwise if the index is greater than the size,
	 * then just add it to the end.
	 *
	 * @param index The index of the new elements to add.
	 * @param element The element to add.
	 * @return true if the element was added, false otherwise.
	 */
	boolean add(T element, int index);

	/**
	 * Clears the entire list.
	 */
	 void clear();

	/**
	 * Checks whether a certain element is contained in the given list.
	 *
	 * @param element The element to search for.
	 * @return True if the element is in the list, false otherwise.
	 */
	 boolean contains(T element);


	/**
	 * Retrieves the element at the specified index.
	 *
	 * @param index The index of the element.
	 * @return The element itself.
	 */
	 T get(int index);


	/**
	 * @param element The element to look fpr
	 * @return The index of the first occurrence of the given element.
	 * or -1 if it's not in the list.
	 */
	 int indexOf(T element);


	/**
	 * Checks whether the list is empty.
	 *
	 * @return True if it's empty, false otherwise.
	 */
	 boolean isEmpty();


	/**
	 * Removes the element at the specified index.
	 *
	 * @param index The index of the element to remove.
	 * @return The removed element if there was one. otherwise null
	 */
	 T remove(int index);


	/**
	 * Removes the first occurrence of the specified element from the list.
	 * @param element The element to remove.
	 */
	 void remove(T element);


	/**
	 * @return The size of the list.
	 */
	 int size();
}
