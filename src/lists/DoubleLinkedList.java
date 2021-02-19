package lists;

public class DoubleLinkedList<T> implements ListInterface<T> {

    private DoubleNode<T> head;
    private DoubleNode<T> tail;
    private int size;


    public DoubleLinkedList () {
        this.head = new DoubleNode<>(null);
        this.tail = new DoubleNode<>(null);

        this.head.setNext(tail);
        this.tail.setPrevious(head);
        this.size = 0;
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
        return size;
    }



    public static void main(String[] args) {
        DoubleLinkedList<Integer> dls = new DoubleLinkedList<>();

        System.out.println(dls);
    }
}
