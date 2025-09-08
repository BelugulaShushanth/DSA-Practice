package dataStructures.singleLinkedList;

public class Main {

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList(18);
        linkedList.append(7);
        linkedList.append(25);
        linkedList.printList();
        System.out.println("Removed Last: "+linkedList.removeLast().value);
        linkedList.printList();
        linkedList.append(6);
        System.out.println("After appending");
        linkedList.printList();
        linkedList.prepend(10);
        System.out.println("After prepending");
        linkedList.printList();
        System.out.println("Removed First: "+linkedList.removeFirst().value);
        linkedList.printList();
        System.out.println("Length: "+linkedList.getLength());
        System.out.println("Get: "+linkedList.get(2).value);
        System.out.println("Set: "+linkedList.set(2,25));
        linkedList.printList();
        System.out.println("Insert: "+linkedList.insert(1,3));
        linkedList.printList();
        System.out.println("Remove : "+linkedList.remove(2,2).value);
        linkedList.printList();
        linkedList.reverseV2();
        System.out.println("Reverse");
        linkedList.printList();
    }
}