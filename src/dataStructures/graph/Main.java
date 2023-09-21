package dataStructures.graph;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");
        graph.addEdge("D", "A");
        graph.addEdge("D", "B");

        graph.printGraph();

        graph.removeEdge("A", "C");
        System.out.println("After removing Edge: ");
        graph.printGraph();

        System.out.println("After removing Vertex: ");
        graph.removeVertex("D");
        graph.printGraph();


    }
}
