package dataStructures.heap.maxHeap;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Heap heap = new Heap();
//        heap.insert(99);
//        heap.insert(72);
//        heap.insert(61);
//        heap.insert(58);
//
//        System.out.println(heap.getHeap());
//
//        heap.insert(100);
//        System.out.println(heap.getHeap());
//
//        heap.insert(75);


        heap.insert(95);
        heap.insert(75);
        heap.insert(80);
        heap.insert(55);
        heap.insert(60);
        heap.insert(50);
        heap.insert(65);

        System.out.println(heap.getHeap());

        heap.remove();

        System.out.println(heap.getHeap());

        heap.remove();

        System.out.println(heap.getHeap());

        Arrays.asList(10);
    }
}
