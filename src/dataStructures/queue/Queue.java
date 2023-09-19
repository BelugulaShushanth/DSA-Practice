package dataStructures.queue;

public class Queue {

    private Node first;
    private Node last;
    private int length;

    public Queue(int value){
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length = 1;
    }

    public int getFirst(){
        return first.value;
    }

    public int getLast(){
        return last.value;
    }

    public int getLength(){
        return length;
    }

    public void printQueue(){
        Node temp = first;
        while (temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll(){
        System.out.println("First: "+getFirst());
        System.out.println("Last: "+getLast());
        System.out.println("Length: "+getLength());
        printQueue();
    }

    public void enqueue(int value){
        Node newNode = new Node(value);
        if(length == 0){
            first = newNode;
            last = newNode;
        }
        else{
            last.next = newNode;
            last = newNode;
        }
        length++;
    }

    public Node dequeue(){
        Node temp = first;
        if(length == 1){
            first = null;
            last = null;
            length--;
        }
        else if(length > 1){
            first = temp.next;
            temp.next = null;
            length--;
        }
        return temp;
    }
}
