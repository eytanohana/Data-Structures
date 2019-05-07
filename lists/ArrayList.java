package lists;

public class ArrayList<T> implements ListInterface {

    private Object[] arrList;
    private int size;
    private int capacity;

    private static final int DEFAULT_CAPACITY = 10;


    public ArrayList(int capacity) {
        arrList = new Object[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Adds a new elements to the end of the list. If the list is full
     * the capacity is doubled and every element is copied into the new list.
     *
     * @param element The element to add.
     */
    @Override
    public void add(Object element) {
        if (size == capacity) {
            Object[] arr = new Object[capacity * 2];
            System.arraycopy(arrList, 0, arr, 0, size);
            capacity *= 2;
            arrList = arr;
        }

        arrList[size] = element;
        size++;
    }

    /**
     * Adds an elements at the specified index. If the index is less than 0,
     * then it returns false. Otherwise if the index is greater than the size,
     * then just add it to the end.
     *
     * @param element The element to add.
     * @param index   The index of the new elements to add.
     * @return true if the element was added, false otherwise.
     */
    @Override
    public boolean add(Object element, int index) {
        return false;
    }

    /**
     * Clears the entire list.
     */
    @Override
    public void clear() {

    }

    /**
     * Checks whether a certain element is contained in the given list.
     *
     * @param element The element to search for.
     * @return True if the element is in the list, false otherwise.
     */
    @Override
    public boolean contains(Object element) {
        return false;
    }

    /**
     * Retrieves the element at the specified index.
     *
     * @param index The index of the element.
     * @return The element itself.
     */
    @Override
    public Object get(int index) {
        return null;
    }

    /**
     * @param element The element to look fpr
     * @return The index of the first occurrence of the given element.
     */
    @Override
    public int indexOf(Object element) {
        return 0;
    }

    /**
     * Checks whether the list is empty.
     *
     * @return True if it's empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * Removes the element at the specified index.
     *
     * @param index The index of the element to remove.
     * @return The removed element if there was one. otherwise null
     */
    @Override
    public Object remove(int index) {
        return null;
    }

    /**
     * Removes the first occurrence of the specified element from the list.
     *
     * @param element The element to remove.
     */
    @Override
    public void remove(Object element) {

    }

    /**
     * @return The size of the list.
     */
    @Override
    public int size() {
        return 0;
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
        System.out.println(ls);
    }
}
