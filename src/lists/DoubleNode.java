package lists;

public class DoubleNode<T> {
    private T data;
    private DoubleNode<T> next;
    private DoubleNode<T> previous;


    public DoubleNode(T data, DoubleNode<T> next, DoubleNode<T> previous) {
        this.data = data;
        this.next = next;
        this.previous = previous;
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
}