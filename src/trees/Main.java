package trees;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(13);
        tree.insert(14);
        tree.insert(40);
        tree.insert(32);
        tree.insert(35);
        tree.insert(20);

        tree.insert(4);
        tree.insert(1);
        tree.insert(12);


        System.out.println();
        System.out.println(tree);

        tree.delete(15);

        System.out.println(tree);
    }
}
