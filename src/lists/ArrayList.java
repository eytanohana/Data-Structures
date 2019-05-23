package lists;

public class ArrayList<T> implements ListInterface {

    private Object[] arrList;
    private int size;
    private int capacity;

    private static final int DEFAULT_CAPACITY = 10;


    /**
     * Constructs a new ArrayList object with a given initial capacity.
     * @param capacity the initial capacity of the list.
     */
    public ArrayList(int capacity) {
        arrList = new Object[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Resizes the arrayList to contain twice the capacity as before.
     *
     * Runs in O(n).
     */
    private void resize() {
        Object[] arr = new Object[capacity * 2];
        System.arraycopy(arrList, 0, arr, 0, size);
        capacity *= 2;
        arrList = arr;
    }

    /**
     * Adds a new elements to the end of the list. If the list is full
     * the capacity is doubled and every element is copied into the new list.
     *
     * In the worst case runs in O(n). In most cases runs in O(1).
     *
     * @param element The element to add.
     */
    @Override
    public void add(Object element) {
        if (size == capacity) {
            resize();
        }

        arrList[size] = element;
        size++;
    }

    /**
     * Adds an elements at the specified index and shifts all other elements over. If the index is less than 0,
     * then it returns false. Otherwise if the index is greater than the size,
     * then just add it to the end.
     *
     * Runs in O(n).
     *
     * @param element The element to add.
     * @param index   The index of the new elements to add.
     * @return true if the element was added, false otherwise.
     */
    @Override
    public boolean add(Object element, int index) {
        if (index < 0)
            return false;

        if (index > size) {
            add(element);
            return true;
        }

        else {
            if (size == capacity) {
                resize();
                System.arraycopy(arrList, index, arrList, index + 1, size - index);
            }
            else
                System.arraycopy(arrList, index, arrList, index + 1, size - index);
            arrList[index] = element;
            size++;
            return true;
        }
    }

    /**
     * Clears the entire list.
     */
    @Override
    public void clear() {
        arrList = new Object[DEFAULT_CAPACITY];
        size = 0;
        capacity = DEFAULT_CAPACITY;
    }

    /**
     * Checks whether a certain element is contained in the given list.
     *
     * Runs in O(n).
     *
     * @param element The element to search for.
     * @return True if the element is in the list, false otherwise.
     */
    @Override
    public boolean contains(Object element) {
        for (int i = 0; i < size; i++) {
            if (arrList[i].equals(element))
                return true;
        }

        return false;
    }

    /**
     * Retrieves the element at the specified index.
     *
     * Runs in O(1).
     *
     * @param index The index of the element.
     * @return The element itself.
     */
    @Override
    public T get(int index) {
        if (index < 0 || index >= size)
            return null;

        return (T) arrList[index];
    }

    /**
     * @param element The element to look fpr
     * @return The index of the first occurrence of the given element.
     * or -1 if it's not in the list.
     */
    @Override
    public int indexOf(Object element) {
        for (int i = 0; i < size; i++) {
            if (arrList[i].equals(element))
                return i;
        }
        return -1;
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
     * Removes the element at the specified index and
     * shifts the rest of the elements back one place.
     *
     * @param index The index of the element to remove.
     * @return The removed element if there was one. otherwise null
     */
    @Override
    public Object remove(int index) {
        if (index < 0 || index >= size)
            return null;

        Object removed = arrList[index];

        System.arraycopy(arrList, index+1, arrList, index, size - index);
        size--;
        return removed;
    }

    /**
     * Removes the first occurrence of the specified element from the list.
     *
     * @param element The element to remove.
     */
    @Override
    public void remove(Object element) {
        remove(indexOf(element));
    }

    /**
     * @return The size of the list.
     */
    @Override
    public int size() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String arrow = " -> ";
        for (int i = 0; i < size; i++) {
            sb.append(arrList[i]);
            sb.append(arrow);
        }
        sb.append("\\\\");
        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayList<Integer> ls = new ArrayList<>();

        for (int i = 0; i < 10; i++)
            ls.add(i);
        System.out.println(ls.size());

        System.out.println(ls);

        ls.add(999, 9);
        System.out.println(ls);
        System.out.println(ls.getCapacity());

        System.out.println(ls);
        System.out.println(ls.get(11));

        System.out.println(ls.indexOf(99));

        System.out.println(ls.remove(9));
        System.out.println(ls);

        Integer x = 4;
        ls.remove(x);
        System.out.println(ls);
    }
}
