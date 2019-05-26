import trees.BinarySearchTree;

public class Main {

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

        tree.inOrderTraversal();
        System.out.println();
        tree.preOrderTraversal();
        System.out.println();
        tree.postOrderTraversal();
    }

}
