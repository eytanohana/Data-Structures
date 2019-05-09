package trees;

public class BinarySearchTree<T> {

    class Node<T> {
        private T data;
        private Node<T> leftChild;
        private Node<T> rightChild;

        public Node(T data, Node<T> left, Node<T> right) {
            this.data = data;
            this.leftChild = left;
            this.rightChild = right;
        }

        public Node(T data) {
            this(data, null, null);
        }


        public T getData() {
            return this.data;
        }

        public Node<T> getLeftChild() {
            return leftChild;
        }

        public Node<T> getRightChild() {
            return rightChild;
        }

        public void setLeftChild(Node<T> left) {
            leftChild = left;
        }

        public void setRightChild(Node<T> right) {
            rightChild = right;
        }
    }

    private Node<T> root;
    private int size;

    public BinarySearchTree(T data) {
        root = new Node(data);
        size = 0;
    }

    public static void main(String[] args) {

    }





}
