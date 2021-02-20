package lists;

public class DoubleLinkedList<T> implements ListInterface<T> {

    private DoubleNode<T> head;
    private DoubleNode<T> tail;
    private int size;


    public DoubleLinkedList () {
        head = new DoubleNode<>(null);
        tail = new DoubleNode<>(null);
        head.connect(tail);
        size = 0;
    }

    @Override
    public void add(T element) {
        DoubleNode<T> node = new DoubleNode<>(element);
        DoubleNode<T> last = tail.getPrevious();

        last.connect(node);
        node.connect(tail);
        size++;
    }

    @Override
    public boolean add(T element, int index) {
        return false;
    }

    @Override
    public void clear() {
        head.connect(tail);
        size = 0;
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
        return size == 0;
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

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder("\\ <-> ");
        DoubleNode<T> current = head.getNext();
        while (!current.equals(tail)) {
            strBuilder.append(current.getData()).append(" <-> ");
            current = current.getNext();
        }
        strBuilder.append("/");
        return strBuilder.toString();
    }


    public static void main(String[] args) {
        DoubleLinkedList<Integer> dls = new DoubleLinkedList<>();
        System.out.println(dls);
        System.out.println(dls.size());
        for(int i = 0; i < 5; i++)
            dls.add(i);
        System.out.println(dls);
        System.out.println(dls.size());
    }
}
