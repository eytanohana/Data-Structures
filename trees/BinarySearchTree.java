package trees;

public class BinarySearchTree<T extends Comparable<T>> {

    private BinarySearchTree<T> left;
    private BinarySearchTree<T> right;
    private BinarySearchTree<T> parent;

    private T data;

    // Supposed to hold the size of the tree -- not implemented yet.
    private int size;

    public BinarySearchTree(T data) {
        this(data, null, null);
    }



    public BinarySearchTree(T data, BinarySearchTree<T> left, BinarySearchTree<T> right) {
        this.data = data;

        this.left = left;
        this.right = right;

        this.size = 1;
        if (left != null) size += left.size;
        if (right != null) size += right.size;
    }

    public void setRight(BinarySearchTree<T> rightChild) {
        right = rightChild;
    }

    public BinarySearchTree<T> getLeft() {
        return left;
    }

    public void setLeft(BinarySearchTree<T> leftChild) {
        left = leftChild;
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
        // size should be 2
        System.out.println(tree.size);


        tree.insert(0);
        // size should be 3
        System.out.println(tree.size);


        tree.insert(-5);
        // size should be 4
        System.out.println(tree.size);


        tree.insert(3);
        // size should be 5
        System.out.println(tree.size);


        tree.insert(7);
        // size should be 6
        System.out.println(tree.size);


        tree.insert(15);
        // size should be 7
        System.out.println(tree.size);

        //tree.printTree();

        System.out.println();
        System.out.println();

        // need to fix inOrderTraversal
        //tree.inOrderTraversal();
    }
}
