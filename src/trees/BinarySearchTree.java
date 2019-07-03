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


    /**
     * My own personal implementation of printTree.
     * There's a more visually appealing implementation
     * found on stack overflow below.
     */
    private void printTree(int depth) {

        if (this == null)
            return;

        System.out.println(this.data);
        for (int i = 0; i < depth; i++)
            System.out.print("   ");
        System.out.print('|');

        if (this.isLeaf())
            return;

        else {
            depth += 1;
            if (right != null) {
                for (int i = 0; i < depth; i++)
                    System.out.print("--");
                right.printTree(depth);
            }

            if (left != null) {
                for (int i = 0; i < depth; i++)
                    System.out.print("--");
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
        System.out.print(data + "  ");

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

        System.out.print(data + "  ");
    }

    /**
     * A more visually appealing implementation of printTree adapted from
     * code found on stackoverflow.
     * https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram
     *
     * @return A String representation of the tree
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (right != null) {
            right.toString(true, "", sb);
        }

        sb.append(data + "\n");

        if (left != null)
            left.toString(false, "", sb);

        return sb.toString();
    }


    private void toString(boolean hasRight, String indent, StringBuilder sb) {
        if (right != null) {
            right.toString(true, indent + (hasRight ? "        " : " |      "), sb);
        }

        sb.append(indent);
        if (hasRight)
            sb.append(" /");
        else
            sb.append(" \\");

        sb.append("----- ");
        sb.append(data + "\n");

        if (left != null) {
            left.toString(false, indent + (hasRight ? " |      " : "        "), sb);
        }
    }



    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(5);
        tree.insert(10);
        tree.insert(0);
        tree.insert(-5);


        tree.insert(3);
        tree.insert(7);
        tree.insert(15);
        tree.insert(32);
        tree.insert(62);
        tree.insert(19);
        tree.insert(16);
        tree.insert(12);
        tree.insert(2);

        tree.inOrderTraversal();
        System.out.println();
        tree.preOrderTraversal();
        System.out.println();
        tree.postOrderTraversal();

        System.out.println("\n\n");

        System.out.println(tree);
    }
}

