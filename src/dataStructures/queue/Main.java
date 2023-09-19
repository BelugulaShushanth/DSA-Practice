package dataStructures.queue;

public class Main {

    public static void main(String[] args) {
        Queue queue = new Queue(4);
        queue.printAll();
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(1);
        System.out.println("Enqueue");
        queue.printAll();
        System.out.println("Dequeue: "+queue.dequeue().value);
        queue.printAll();
        char c = 's';
        if(c == 's'){

        }
    }
}
