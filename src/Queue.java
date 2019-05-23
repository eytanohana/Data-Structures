import lists.LinkedList;

public class Queue<T> {
    private LinkedList<T> queue;

    public Queue() {
        queue = new LinkedList<>();
    }

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void enqueue(T element) {
        queue.addFirst(element);
    }

    public T dequeue() {
        return queue.remove(queue.size()-1);
    }

    @Override
    public String toString() {
        return queue.toString();
    }



    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();
        for (int i = 0; i < 10; i++)
            q.enqueue(i);
        System.out.println(q);

        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
    }

}
