package dataStructures.heap.minHeap;

import java.util.ArrayList;
import java.util.List;

public class Heap {

    private List<Integer> heap;

    public Heap(){
        this.heap = new ArrayList<>();
    }

    public List<Integer> getHeap(){
        return new ArrayList<>(heap);
    }

    public int leftChild(int index){
        return 2 * index + 1;
    }

    public int rightChild(int index){
        return 2 * index + 2;
    }

    public int parent(int index){
        return (index-1) / 2;
    }

    public void swap(int index1, int index2){
        Integer temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    public void insert(int value){
        heap.add(value);
        int currentIndex = heap.size() - 1;
        while (currentIndex > 0 && heap.get(currentIndex) < heap.get(parent(currentIndex))){
            swap(currentIndex, parent(currentIndex));
            currentIndex = parent(currentIndex);
        }
    }

    public Integer remove(){
        if(heap.size() == 0){
            return null;
        }
        else if (heap.size() == 1) {
            return heap.remove(0);
        }
        else{
            int minValue = heap.get(0);
            heap.set(0, heap.remove(heap.size() - 1));
            sink(0);
            return minValue;
        }
    }

    private void sink(int index) {
        int minIndex = index;
        while (true){
            int leftIndex = leftChild(index);
            int rightIndex = rightChild(index);
            if(leftIndex < heap.size() && heap.get(leftIndex) < heap.get(minIndex)){
                minIndex = leftIndex;
            }
            if(rightIndex < heap.size() && heap.get(rightIndex) < heap.get(minIndex)){
                minIndex = rightIndex;
            }

            if(minIndex != index){
                swap(minIndex,index);
                index = minIndex;
            }
            else{
                break;
            }
        }
    }
}
