import lists.LinkedList;

public class Stack<T> {

    private LinkedList<T> stack;

    public Stack() {
        stack = new LinkedList();
    }

    public void push(T elem) {
        stack.add(0, elem);
    }

    public T pop() {
        return stack.remove(0);
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public String toString() {
        return stack.toString();
    }


    public static void main(String[] args) {
        Stack<LinkedList<Integer>> stack = new Stack<>();
        LinkedList<Integer>[] ls = new LinkedList[4];
        for (int i = 0; i < 4; i++) {
            ls[i] = new LinkedList<>();
            for (int j = 0; j < 3; j++) {
                ls[i].add(j*i);
            }
            stack.push(ls[i]);
        }

        System.out.println(stack);
        System.out.println(stack.pop());






    }

}
