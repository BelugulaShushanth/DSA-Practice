package dataStructures.stack;

public class Main {

    public static void main(String[] args) {
        Stack stack = new Stack(2);
        stack.printAll();
        stack.push(5);
        stack.push(3);
        stack.push(1);
        System.out.println("Push");
        stack.printAll();
        System.out.println("Pop: "+stack.pop().value);
        stack.printAll();
    }


}
