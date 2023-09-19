package dataStructures.stack;

public class Stack {

    private Node top;
    private int height;

    public Stack(int value){
        Node node = new Node(value);
        top = node;
        height = 1;
    }

    public void printStack(){
        Node temp = top;
        while (temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public int getTop(){
        return top.value;
    }

    public int getHeight(){
        return height;
    }

    public void printAll(){
        System.out.println("Top: "+getTop());
        System.out.println("Height: "+getHeight());
        printStack();
    }

    public void push(int value){
        Node newNode = new Node(value);
        if(height == 0){
            top = newNode;
        }
        else{
            newNode.next = top;
            top = newNode;
        }
        height++;
    }

    public Node pop(){
        if(height == 0) return null;
        Node temp = top;
        top = temp.next;
        temp.next = null;
        height--;
        return temp;
    }
}
