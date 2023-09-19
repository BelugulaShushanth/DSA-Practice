package dataStructures.doublyLinkedList;

public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int length;

    public DoublyLinkedList(int value){
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public Node getHead(){
        return this.head;
    }

    public Node getTail(){
        return this.tail;
    }

    public int getLength(){
        return this.length;
    }

    public void printAll(){
        if(length != 0) {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length: "+length);
        printList();
    }

    public void printList(){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void append(int value){
        Node newNode = new Node(value);
        if(length == 0){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast(){
        Node temp = tail;
        if (length == 1){
            head = null;
            tail = null;
            length--;
        }
        else if(length > 1){
            tail.prev.next = null;
            tail = tail.prev;
            temp.prev = null;
            length--;
        }
        return temp;
    }

    public void prepend(int value){
        Node newNode = new Node(value);
        if (length == 0){
            head = newNode;
            tail = newNode;
        }
        else{
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst(){
        Node temp = head;
        if(length == 1){
            head = null;
            tail = null;
            length--;
        }
        else if(length > 1){
            head = head.next;
            head.prev = null;
            temp.next = null;
            length --;
        }
        return temp;
    }

    public Node get(int index){
        if(index < 0 || index >= length) return null;
        Node temp = head;
        if(index < length/2) {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        }
        else{
            temp = tail;
            for (int i = length-1; i >index; i--){
                temp = temp.prev;
            }
        }
        return temp;
    }

    public boolean set(int index, int value){
        if (index < 0 || index >=length) return false;
        get(index).value = value;
        return true;
    }

    public boolean insert(int index, int value){
        if(index < 0 || index > length) {
            return false;
        }
        else if(index == 0){
            prepend(value);
            return true;
        }
        else if (index == length){
            append(value);
            return true;
        }
        else {
            Node newNode = new Node(value);
            Node temp = get(index-1);
            newNode.next = temp.next;
            newNode.prev = temp;
            temp.next.prev = newNode;
            temp.next = newNode;
            length++;
            return true;
        }
    }

    public Node remove(int index){
        if(index < 0 || index >= length){
            return null;
        }
        else if(index == 0){
            return removeFirst();
        }
        else if(index == length-1){
            return removeLast();
        }
        else{
            Node temp = get(index - 1);
            Node temp1 = temp.next;
            temp.next = temp.next.next;
            temp.next.prev = temp;
            temp1.next = null;
            temp1.prev = null;
            length--;
            return temp1;
        }
    }

    public void swapFirstLast(){
        if(length == 2){
            Node temp = head;
            head = tail;
            tail = temp;
            head.next = tail;
            head.prev.next = null;
            head.prev = null;
            head.next.prev = head;
        }
        else if(length>2){
            Node temp = head.next;
            head.prev = tail.prev;
            head.next.prev = null;
            head.next = null;
            tail.prev.next = null;
            tail.prev = null;
            tail.next = temp;
            head.prev.next = head;
            tail.next.prev = tail;
            temp = head;
            head = tail;
            tail = temp;
        }
    }

    public void reverse(){
        if(length != 0){
            Node temp = head;
            head = tail;
            tail = temp;
            temp = tail;
            Node before = null;
            Node after;

            while(temp != null){
                after = temp.next;
                temp.next = before;
                if(before != null){
                    before.prev = temp;
                }
                before = temp;
                temp.prev = null;
                temp = after;
            }
        }
    }
}
