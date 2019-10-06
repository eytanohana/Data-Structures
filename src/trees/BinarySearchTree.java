package trees;

import lists.Node;

public class BinarySearchTree<T extends Comparable> {


    Node<T> root;
    private int size;



    public BinarySearchTree(T data, Node<T> left, Node<T> right, Node<T> parent) {

        root = new Node<>(data, parent, left, right);
        size = 1;

        if (left != null) {
            root.setLeft(left);
            size++;
        }
        if (right != null) {
            root.setRight(right);
            size++;
        }
    }


    public BinarySearchTree(T data) {
        this(data, null, null, null);
    }

    public BinarySearchTree() {
        this(null, null, null, null);
    }


    public boolean hasChildren() {
        return hasLeft() || hasRight();
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

    public BinarySearchTree<T> find(T data) {
        BinarySearchTree<T> current = this;

        while (current != null && current.data != data) {
            if (data.compareTo(current.data) < 1) {
                current = current.left;
            }
            else {
                current = current.right;
            }
        }
        return current;
    }

    public void delete(T data) {
        BinarySearchTree<T> toDelete;

        if ((toDelete = find(data)) == null) {
            return;
        }


        BinarySearchTree<T> parent;

        if (!toDelete.hasChildren()) {
            parent = toDelete.parent;

            if (parent.left == toDelete) {
                parent.left = null;
                return;
            }
            else {
                parent.right = null;
                return;
            }
        }

        /********* need to implement other cases and setting size *************/
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


    private class Node<T extends Comparable> {
        T data;
        Node<T> parent;
        Node<T> left;
        Node<T> right;


        public Node(T data, Node<T> parent, Node<T> left, Node<T> right) {
            this.data = data;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getParent() {
            return parent;
        }

        public void setParent(Node<T> parent) {
            this.parent = parent;
        }

        public Node<T> getLeft() {
            return left;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public Node<T> getRight() {
            return right;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }

        public boolean hasLeft() {
            return left != null;
        }

        public boolean hasRight() {
            return right != null;
        }


        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", parent=" + parent +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
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
        System.out.println();
        System.out.println(tree);
        System.out.println(tree.getSize());
    }
}

