package lists;

public class DoubleLinkedList<T> implements ListInterface<T> {

    private final DoubleNode<T> head;
    private final DoubleNode<T> tail;
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
        if (index < 0) {
            return false;
        } else if (index >= size) {
            add(element);
            return true;
        } else {
            DoubleNode<T> node = new DoubleNode<>(element);
            if (index >= size / 2) {
                DoubleNode<T> curr = tail.getPrevious();
                for (int i = size - 1; i >= index; i--) {
                    curr = curr.getPrevious();
                }
                node.connect(curr.getNext());
                curr.connect(node);
            }
            else {
                DoubleNode<T> curr = head.getNext();
                for (int i = 0; i < index; i++) {
                    curr = curr.getNext();
                }
                curr.getPrevious().connect(node);
                node.connect(curr);
            }
            size++;
            return true;
        }
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
        try {
            return getNode(index).getData();
        } catch (NullPointerException e) {
            return null;
        }
    }

    private DoubleNode<T> getNode(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        DoubleNode<T> curr;
        if (index > size / 2) {
            curr = tail.getPrevious();
            for (int i = size-1; i > index; i--) {
                curr = curr.getPrevious();
            }
        } else {
            curr = head.getNext();
            for (int i = 0; i < index; i++) {
                curr = curr.getNext();
            }
        }
        return curr;
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
    public T removeIndex(int index) {
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
        dls.add(99, 1);
        dls.add(100, 2);
        dls.add(200, 7);
        dls.add(300, 8);
        dls.add(350, 8);
        dls.add(400, 8);
        System.out.println(dls);
        System.out.println(dls.size());
    }
}
