package dataStructures.binarySearchTree;

import java.util.Collections;

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

        System.out.println("RContains: "+bst.rContains(231));

        System.out.println("BFS: "+bst.BFS());
        System.out.println("Pre Order DFS: "+bst.preOrderDFS());
        System.out.println("Post Order DFS: "+bst.postOrderDFS());
        System.out.println("In Order DFS: "+bst.inOrderDFS());
        System.out.println("In Order DFS Simple: "+bst.inOrderDFS());
    }
}
