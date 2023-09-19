package dataStructures.doublyLinkedList;

public class Main {

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList(1);
        dll.append(2);
        dll.append(3);
        dll.append(4);
        dll.printAll();
        System.out.println("Remove Last: " +dll.removeLast().value);
        dll.printList();
        dll.prepend(8);
        System.out.println("After prepend:");
        dll.printList();
        System.out.println("Remove First: "+dll.removeFirst().value);
        dll.append(4);
        dll.append(5);
        dll.printList();
        System.out.println("Get: "+dll.get(3).value);
        System.out.println("Set: "+dll.set(1,6));
        dll.printList();
        System.out.println("Insert: "+dll.insert(2,7));
        dll.printList();
        System.out.println("Remove: "+dll.remove(2).value);
        dll.removeLast();
        dll.removeLast();
        dll.printList();
        dll.reverse();
        System.out.println("Reverse");
        dll.printList();
    }

}
