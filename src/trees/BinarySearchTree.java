package trees;


public class BinarySearchTree<T extends Comparable> {


    Node<T> root;
    private int size;

    /**
     * Constructs a binary tree with the root and its two children.
     *
     * @param data The data held in the root node.
     * @param left The left child.
     * @param right The right child.
     */
    public BinarySearchTree(T data, Node<T> left, Node<T> right) {

        root = new Node<>(data, null, left, right);
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

    /**
     * Constructs a binary tree with just the root node initialized with some data.
     *
     * @param data The data held in the root node.
     */
    public BinarySearchTree(T data) {
        this(data, null, null);
    }

    /**
     * Constructs an empty binary tree.
     */
    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    /**
     * @return The size of the tree.
     */
    public int getSize() {
        return size;
    }

    /**
     * Inserts a new node into the tree.
     * @param data The data to be stored in the node.
     */
    public void insert(T data) {
        if (root == null) {
            root = new Node<>(data);
        } else {
            Node<T> current = root;
            Node<T> newNode = new Node<>(data);

            while (true) {
                if (newNode.compareTo(current) <= 0) {
                    if (current.hasLeft()) {
                        current = current.getLeft();
                    } else {
                        current.setLeft(newNode);
                        break;
                    }
                } else {
                    if (current.hasRight()) {
                        current = current.getRight();
                    } else {
                        current.setRight(newNode);
                        break;
                    }
                }
            }
        }
        size++;
    }

    /**
     * Searches the tree for the node with the piece of data to find.
     * @param data The data to find.
     * @return The node with the data or null if it's not in the tree.
     */
    public Node<T> find(T data) {
        Node<T> current = this.root;
        Node<T> toFind = new Node<>(data);

        while (current != null && current.getData() != data) {
            if (toFind.compareTo(current) < 1) {
                current = current.getLeft();
            }
            else {
                current = current.getRight();
            }
        }
        return current;
    }
//
//    public void delete(T data) {
//        BinarySearchTree<T> toDelete;
//
//        if ((toDelete = find(data)) == null) {
//            return;
//        }
//
//
//        BinarySearchTree<T> parent;
//
//        if (!toDelete.hasChildren()) {
//            parent = toDelete.parent;
//
//            if (parent.left == toDelete) {
//                parent.left = null;
//                return;
//            }
//            else {
//                parent.right = null;
//                return;
//            }
//        }
//
//        /********* need to implement other cases and setting size *************/
//    }
//
//

    public String inOrderTraversal() {
        StringBuilder sb = new StringBuilder();
        root.inOrderTraversal(sb);
        return sb.toString();
    }

    public String preOrderTraversal() {
        StringBuilder sb = new StringBuilder();
        root.preOrderTraversal(sb);
        return sb.toString();
    }

    public String postOrderTraversal() {
        StringBuilder sb = new StringBuilder();
        root.postOrderTraversal(sb);
        return sb.toString();
    }

    /**
     * A more visually appealing implementation of printTree adapted from
     * code found on stackoverflow.
     * https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram
     *
     * @return A String representation of the tree
     */
    public String toString() {
        if (size == 0) {
            return "Empty tree";
        }


        StringBuilder sb = new StringBuilder();
        Node<T> right = root.getRight();
        Node<T> left = root.getLeft();

        if (right != null) {
            right.buildBranch(true, "", sb);
        }

        sb.append(root.getData() + "\n");

        if (left != null)
            left.buildBranch(false, "", sb);

        return sb.toString();
    }





    private class Node<T extends Comparable> implements Comparable<Node<T>> {
        T data;
        Node<T> parent;
        Node<T> left;
        Node<T> right;

        /**
         * Constructs a node with some data and pointers to its parent
         * and children.
         *
         * @param data The data stored in the node.
         * @param parent The parent of the node.
         * @param left The left child.
         * @param right The right child.
         */
        public Node(T data, Node<T> parent, Node<T> left, Node<T> right) {
            this.data = data;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        /**
         * Constructs a Node with just some data.
         * @param data The data to store.
         */
        public Node(T data) {
            this(data, null, null, null);
        }

        /**
         * @return The nodes data.
         */
        public T getData() {
            return data;
        }

        /**
         * @return The nodes parent.
         */
        public Node<T> getParent() {
            return parent;
        }

        /**
         * Sets the parent of the current node.
         * @param parent The new parent node.
         */
        private void setParent(Node<T> parent) {
            this.parent = parent;
        }

        /**
         * @return The nodes left child.
         */
        public Node<T> getLeft() {
            return left;
        }

        /**
         * Sets the nodes left child.
         * @param left
         */
        public void setLeft(Node<T> left) {
            this.left = left;
        }

        /**
         * @return The nodes right child.
         */
        public Node<T> getRight() {
            return right;
        }

        /**
         * Sets the nodes right child.
         * @param right
         */
        public void setRight(Node<T> right) {
            this.right = right;
        }

        /**
         * @return Whether or not the node has a left child.
         */
        public boolean hasLeft() {
            return left != null;
        }

        /**
         * @return Whether or not the node has a right child.
         */
        public boolean hasRight() {
            return right != null;
        }

        /**
         * @return Whether or not the node is a leaf ie has no children
         */
        public boolean isLeaf() {
            return !hasLeft() && !hasRight();
        }

        /**
         * Helper function for the Nodes outclass inOrderTraversal method.
         * @param sb The StringBuilder needed to create the traversal.
         */
        private void inOrderTraversal(StringBuilder sb) {
            if (left != null) {
                left.inOrderTraversal(sb);
            }

            sb.append(data + "  ");


            if (right != null) {
                right.inOrderTraversal(sb);
            }
        }

        /**
         * Helper function for the Nodes outclass preOrderTraversal method.
         * @param sb The StringBuilder needed to create the traversal.
         */
        private void preOrderTraversal(StringBuilder sb) {
            sb.append(data + "  ");

            if (left != null) {
                left.preOrderTraversal(sb);
            }

            if (right != null) {
                right.preOrderTraversal(sb);
            }
        }

        /**
         * Helper function for the Nodes outclass postOrderTraversal method.
         * @param sb The StringBuilder needed to create the traversal.
         */
        private void postOrderTraversal(StringBuilder sb) {
            if (left != null) {
                left.postOrderTraversal(sb);
            }

            if (right != null) {
                right.postOrderTraversal(sb);
            }

            sb.append(data + "  ");
        }

        /**
         * Helper function for the Nodes outclass toString method.
         * @param hasRight whether or not the node has a right child.
         * @param indent The format of the indentation.
         * @param sb The StringBuilder that compiles all the branches together.
         */
        private void buildBranch(boolean hasRight, String indent, StringBuilder sb) {
            if (right != null) {
                right.buildBranch(true, indent + (hasRight ? "        " : " |      "), sb);
            }

            sb.append(indent);
            if (hasRight)
                sb.append(" /");
            else
                sb.append(" \\");

            sb.append("----- ");
            sb.append(data + "\n");

            if (left != null) {
                left.buildBranch(false, indent + (hasRight ? " |      " : "        "), sb);
            }
        }

        @Override
        public String toString() {
            return this.data + "";
        }

        @Override
        public int compareTo(Node<T> other) {
            if (this == other) {
                return 0;
            }

            return this.data.compareTo(other.data);
        }



    }



    public static void main(String[] args) {
        BinarySearchTree<Character> tree = new BinarySearchTree<>();

        tree.insert('g');
        tree.insert('a');
        tree.insert('r');
        tree.insert('h');
        tree.insert('s');
        tree.insert('y');
        tree.insert('t');
        tree.insert('z');
        tree.insert('x');

        System.out.println();
        System.out.println(tree);

        System.out.println(tree.find('u'));

        System.out.println(tree.inOrderTraversal());
        System.out.println(tree.preOrderTraversal());
        System.out.println(tree.postOrderTraversal());

    }
}

