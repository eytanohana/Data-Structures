package lists;

public class DoubleNode<T> {
    private T data;
    private DoubleNode<T> next;
    private DoubleNode<T> previous;

    /**
     *
     * @param data the data the node will hold
     * @param next the next DoubleNode being pointed at
     * @param previous the previous DoubleNode before
     */
    public DoubleNode(T data, DoubleNode<T> previous, DoubleNode<T> next) {
        this.data = data;
        this.previous = previous;
        this.next = next;
    }

    public DoubleNode(T data) {
        this(data, null, null);
    }


    public T getData() {
        return this.data;
    }

    public DoubleNode<T> getNext() {
        return next;
    }

    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }

    public DoubleNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(DoubleNode<T> previous) {
        this.previous = previous;
    }
}