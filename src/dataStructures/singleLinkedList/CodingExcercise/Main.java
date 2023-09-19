package dataStructures.singleLinkedList.CodingExcercise;

import dataStructures.singleLinkedList.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList ll = new LinkedList(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.append(5);
        //ll.append(6);
//        System.out.println("Before Partition");
//        ll.printList();
//        System.out.println("After Partition");
//        ll.partitionList(5);
//        ll.printList();
        ll.printList();
        ll.reverseBetween(2,3);
        System.out.println("Reverse: ");
        ll.printList();
    }

}
