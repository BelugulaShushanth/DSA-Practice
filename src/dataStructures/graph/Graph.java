package dataStructures.graph;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

    private final HashMap<String, ArrayList<String>> adjList = new HashMap<>();

    public void printGraph(){
        System.out.println(adjList);
    }

    public boolean addVertex(String vertex){
        if(adjList.get(vertex) == null){
            adjList.put(vertex, new ArrayList<>());
            return true;
        }
        return false;
    }

    public boolean addEdge(String vertex1, String vertex2){
        ArrayList<String> vertex1List = adjList.get(vertex1);
        ArrayList<String> vertex2List = adjList.get(vertex2);
        if(vertex1List != null && vertex2List != null){
            if(!vertex1List.contains(vertex2) && !vertex2List.contains(vertex1)){
                vertex1List.add(vertex2);
                vertex2List.add(vertex1);
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean removeEdge(String vertex1, String vertex2){
        ArrayList<String> vertex1List = adjList.get(vertex1);
        ArrayList<String> vertex2List = adjList.get(vertex2);
        if(vertex1List != null && vertex2List != null){
            vertex1List.remove(vertex2);
            vertex2List.remove(vertex1);
            return true;
        }
        return false;
    }

    public boolean removeVertex(String vertex){
        ArrayList<String> vertexList = adjList.get(vertex);
        if(vertexList == null) return false;
        for (String eachVertex : vertexList){
            adjList.get(eachVertex).remove(vertex);
        }
        adjList.remove(vertex);
        return true;
    }
}
