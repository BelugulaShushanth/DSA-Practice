package dataStructures.hashTable;

import java.util.ArrayList;
import java.util.List;

public class HashTable {

    private int size = 7;
    private Node[] dataMap;

    public HashTable(){
        dataMap = new Node[size];
    }

    public void printHashTable(){
        for(int i=0; i<size; i++){
            System.out.println(i + ":");
            Node temp = dataMap[i];
            while (temp != null){
                System.out.println("{ "+temp.key+"="+temp.value+" }");
                temp = temp.next;
            }
        }
    }

    private int hash(String key){
        int hash = 0;
        char[] charArray = key.toCharArray();
        for(int i=0; i<charArray.length; i++){
            int asciiValue = charArray[i];
            hash = (hash + asciiValue * 23) % dataMap.length ;
        }
        return hash;
    }

    public void set(String key, int value){
        int index = hash(key);
        Node newNode = new Node(key, value);
        if(dataMap[index] == null){
            dataMap[index] = newNode;
        }
        else{
            Node temp = dataMap[index];
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public int get(String key){
        int index = hash(key);
        Node temp = dataMap[index];
        while (temp !=null){
            if(temp.key.equals(key)) return temp.value;
            temp = temp.next;
        }
        return 0;
    }

    public List<String> keys(){
        List<String> allKeys = new ArrayList<>();
        for(int i=0; i<size; i++){
            Node temp = dataMap[i];
            while (temp != null){
                allKeys.add(temp.key);
                temp = temp.next;
            }
        }
        return allKeys;
    }

}
