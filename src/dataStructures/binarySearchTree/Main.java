package dataStructures.binarySearchTree;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(47);
        bst.insert(21);
        bst.insert(76);
        bst.insert(18);
        bst.insert(52);
        bst.insert(82);

        bst.insert(27);

        System.out.println("Contains: "+bst.contains(21));

    }
}
