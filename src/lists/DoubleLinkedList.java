package lists;

public class DoubleLinkedList<T> implements ListInterface<T> {

    private DoubleNode<T> head;
    private DoubleNode<T> tail;

    public DoubleLinkedList () {

    }

    @Override
    public void add(T element) {

    }

    @Override
    public boolean add(T element, int index) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean contains(T element) {
        return false;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public int indexOf(T element) {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public void remove(T element) {

    }

    @Override
    public int size() {
        return 0;
    }



    public static void main(String[] args) {
        DoubleLinkedList<Integer> dls = new DoubleLinkedList<>();

        System.out.println(dls);
    }
}
