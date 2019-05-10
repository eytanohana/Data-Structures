package trees;

public class BinarySearchTree<T extends Comparable<T>> {

    private BinarySearchTree<T> left;
    private BinarySearchTree<T> right;

    private T data;

    // Supposed to hold the size of the tree -- not implemented yet.
    private int size;

    public BinarySearchTree(T data) {
        this(data, null, null);
    }

    public  BinarySearchTree(T data, BinarySearchTree<T> left, BinarySearchTree<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public void setRight(BinarySearchTree<T> rightChild) {
        right = rightChild;
    }

    public BinarySearchTree<T> getLeft() {
        return left;
    }

    public void setLeft(BinarySearchTree<T> leftChild) {
        this.left = leftChild;
    }

    public BinarySearchTree<T> getRight() {
        return right;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    public boolean isLeaf() {
        return right == null && left == null;
    }

    public void insert(T data) {
        if (this.data.compareTo(data) < 1) {
            if (left != null)
                left.insert(data);
            else
                left = new BinarySearchTree<>(data);
        }

        else {
            if (right != null)
                right.insert(data);
            else
                right = new BinarySearchTree<>(data);
        }
    }

    public static void printTree(BinarySearchTree root, int depth) {

        if (root == null)
            return;

        System.out.println(root.data);

        if (root.isLeaf())
            return;

        else {
            depth += 1;
            for (int i = 0; i < depth; i++)
                System.out.print("   ");
            printTree(root.right, depth);

            for (int i = 0; i < depth; i++)
                System.out.print("   ");
            printTree(root.left, depth);
        }
    }

    public static void printTree(BinarySearchTree root) {
        printTree(root, 0);
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(5);

        tree.insert(10);
        tree.insert(0);

        tree.insert(-5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(15);

        printTree(tree);
    }





}
