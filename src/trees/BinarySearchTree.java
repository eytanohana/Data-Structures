package trees;

public class BinarySearchTree<T extends Comparable<T>> {

    private BinarySearchTree<T> left;
    private BinarySearchTree<T> right;
    private BinarySearchTree<T> parent;

    private T data;
    private int size;

    public BinarySearchTree(T data) {
        this(data, null, null);
    }



    public BinarySearchTree(T data, BinarySearchTree<T> left, BinarySearchTree<T> right) {
        this.data = data;

        this.parent = null;
        if (left != null) setLeft(left);
        if (right != null) setRight(right);

        this.size = 1;
        if (left != null) size += left.size;
        if (right != null) size += right.size;
    }

    private void setRight(BinarySearchTree<T> rightChild) {
        right = rightChild;
        right.parent = this;
    }

    public BinarySearchTree<T> getRight() {
        return right;
    }

    private void setLeft(BinarySearchTree<T> leftChild) {
        left = leftChild;
        left.parent = this;
    }

    public BinarySearchTree<T> getLeft() {
        return left;
    }

    public BinarySearchTree<T> getParent() {
        return parent;
    }

    public T getData() {
        return data;
    }

    public int getSize() {
        return size;
    }


    public boolean isLeaf() {
        return right == null && left == null;
    }

    public void insert(T data) {
        if (data.compareTo(this.data) < 1) {
            if (left != null)
                left.insert(data);
            else
                setLeft(new BinarySearchTree<>(data));
        }

        else {
            if (right != null)
                right.insert(data);
            else
                setRight(new BinarySearchTree<>(data));
        }
        size += 1;
    }

    private void printTree(int depth) {

        if (this == null)
            return;

        System.out.println(this.data);

        if (this.isLeaf())
            return;

        else {
            depth += 1;
            if (right != null) {
                for (int i = 0; i < depth; i++)
                    System.out.print('\t');
                right.printTree(depth);
            }

            if (left != null) {
                for (int i = 0; i < depth; i++)
                    System.out.print('\t');
                left.printTree(depth);
            }
        }
    }

    public void printTree() {
        printTree(0);
    }


    public void inOrderTraversal() {
        if (left != null) {
            left.inOrderTraversal();
        }

        System.out.print(data + "  ");


        if (right != null) {
            right.inOrderTraversal();
        }
    }

    public void preOrderTraversal() {
        if (this != null) {
            System.out.print(data + "  ");
        }

        if (left != null) {
            left.preOrderTraversal();
        }

        if (right != null) {
            right.preOrderTraversal();
        }
    }

    public void postOrderTraversal() {
        if (left != null) {
            left.postOrderTraversal();
        }

        if (right != null) {
            right.postOrderTraversal();
        }

        if (this != null) {
            System.out.print(data + "  ");
        }

    }
}
