package dataStructures.hashTable;

import java.util.HashMap;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();

        hashTable.set("nails", 100);
        hashTable.set("tile", 50);
        hashTable.set("lumber", 80);

        hashTable.set("bolts", 200);
        hashTable.set("screws", 140);

        hashTable.printHashTable();

        System.out.println(hashTable.get("tile"));

        System.out.println(hashTable.keys());


    }
}
