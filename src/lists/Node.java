package lists;

public class Node<T> {
    private T data;
    private Node<T> next;
    private Node<T> previous;


    public Node(T data, Node<T> previous, Node<T> next) {
        this.data = data;
        this.previous = previous;
        this.next = next;
    }

    public Node(T data, Node<T> next) {
        this(data, null, next);
    }

    public Node(T data) {
        this(data, null, null);
    }


    public T getData() {
        return this.data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }
}