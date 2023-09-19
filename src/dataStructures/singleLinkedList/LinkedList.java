package dataStructures.singleLinkedList;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    public LinkedList(int value){
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

    public void printList(){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void append(int value){
        if(head != null){
            Node newNode = new Node(value);
            tail.next = newNode;
            tail = newNode;
        }
        else{
            Node newNode = new Node(value);
            head = newNode;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast(){
        if(length == 0) return null;
        Node temp = head;
        Node pre = head;
        while (temp.next != null){
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if(length == 0){
            head = null;
            tail = null;
        }
        return temp;
    }

    public void prepend(int value){
        Node newNode = new Node(value);
        if(head != null){
            newNode.next = head;
            head = newNode;
        }
        else{
            head = newNode;
            tail = newNode;
        }
        length++;
    }

    public Node removeFirst(){
        if(length == 0) return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if(length == 0){
            tail = null;
        }
        return temp;
    }

    public Node get(int index){
        if(index < 0 || index>=length) return null;
        Node temp = head;
        int count = 0;
        while (temp != null){
            if(count == index) {
                break;
            }
            temp = temp.next;
            count++;
        }
       return temp;
    }

    public boolean set(int index, int value){
        Node temp = get(index);
        if(temp != null){
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value){
        if(index < 0 || index > length){
            return false;
        }
        else if (index == 0) {
            prepend(value);
            return true;
        }
        else if(index == length){
            append(value);
            return true;
        }
        else {
            Node temp = get(index - 1);
            Node node = new Node(value);
            node.next = temp.next;
            temp.next = node;
            length++;
            return true;
        }
    }

    public Node remove(int index, int value){
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
            Node prev = get(index-1);
            Node temp = prev.next;
            prev.next = temp.next;
            temp.next = null;
            length--;
            return temp;
        }
    }

    public void reverse(){
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;
        for (int i = 0 ; i < length; i++){
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    public void partitionList(int x){
        if(head != null) {
            Node dummy1 = new Node(0);
            Node dummy2 = new Node(0);
            Node prev1 = dummy1;
            Node prev2 = dummy2;
            Node current = head;
            while (current != null) {
                if (current.value < x) {
                    prev1.next = current;
                    prev1 = current;
                } else {
                    prev2.next = current;
                    prev2 = current;
                }
                current = current.next;
            }
            prev2.next = null;
            prev1.next = dummy2.next;
            head = dummy1.next;
        }
    }

    public void reverseBetween(int m, int n){
        if( length !=0 && m >=0 && n>=0 && m<length && n<length && m!=n){
            Node temp = head;
            Node start = null;
            Node end = null;
            Node prev = null;

            if(m !=0 && n!=length-1){
                for(int i=0; i<length; i++){
                    if(i==m){
                        start = temp;
                    }
                    if(i == n){
                        end = temp;
                    }
                    if(i == m-1){
                        prev = temp;
                    }
                    temp = temp.next;
                }
                temp = start;
            }
            Node before = null;
            Node after = temp.next;
            for(int i=0; i<length; i++){
                if(i >=m && i<=n){
                    after = temp.next;
                    temp.next = before;
                    before = temp;
                    if(m != 0 || n != length-1) {
                        if(i==m) {
                            before.next = end.next;
                        }
                        prev.next = before;
                    }
                    if(i != n) {
                        temp = after;
                    }
                }
            }
            if(m==0 && n==length-1) {
                head = temp;
            }

        }
    }

}
