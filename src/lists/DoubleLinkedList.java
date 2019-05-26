package lists;

public class DoubleLinkedList<T> extends LinkedList<T> {

    private Node<T> last;

    public DoubleLinkedList () {
        // creates a head with null and size 0 from the LinkedList constructor
        // (super must be first line of constructor)
        super();
        last = new Node(null, head, null);
        head.setNext(last);

    }

}
