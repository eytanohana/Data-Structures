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
            System.out.print(data + "  ");
            return;
        }

        System.out.print(data + "  ");

        if (right != null) {
            right.inOrderTraversal();
            System.out.print(data + "  ");
            return;
        }

    }



    public static void main(String[] args) {
//           Build a tree that looks like:
 //
//                      5
//                    /   \
//                   0     10
//                 /   \  /  \
//                -5   3 7    15


        BinarySearchTree<Integer> tree = new BinarySearchTree<>(5);

        tree.insert(10);
        tree.insert(0);
        tree.insert(-5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(15);

        tree.printTree();

        System.out.println();
        System.out.println();

        System.out.println(tree.right.left.parent.data);

        // need to fix inOrderTraversal
        //tree.inOrderTraversal();
    }
}
