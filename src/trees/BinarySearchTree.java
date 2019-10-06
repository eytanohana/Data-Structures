package trees;


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
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }


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

        public boolean isLeaf() {
            return right == null && left == null;
        }

        private void inOrderTraversal(StringBuilder sb) {
            if (left != null) {
                left.inOrderTraversal(sb);
            }

            sb.append(data + "  ");


            if (right != null) {
                right.inOrderTraversal(sb);
            }
        }

        private void preOrderTraversal(StringBuilder sb) {
            sb.append(data + "  ");

            if (left != null) {
                left.preOrderTraversal(sb);
            }

            if (right != null) {
                right.preOrderTraversal(sb);
            }
        }

        private void postOrderTraversal(StringBuilder sb) {
            if (left != null) {
                left.postOrderTraversal(sb);
            }

            if (right != null) {
                right.postOrderTraversal(sb);
            }

            sb.append(data + "  ");
        }


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

        System.out.println(tree.inOrderTraversal());
        System.out.println(tree.preOrderTraversal());
        System.out.println(tree.postOrderTraversal());

    }
}

