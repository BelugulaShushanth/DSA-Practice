package algorithms.sorts.insertionSort;

import java.util.Arrays;

public class InsertionSort {

    //Big O is o(n*2) but if the list is almost sorted(best case) then it might be O(n)
    public static void insertionSort(int array[]){
        for(int i=1; i<array.length; i++){
            int temp = array[i];
            int j = i - 1;
            while (j>=0 && temp < array[j]){
                array[j+1] = array[j];
                array[j] = temp;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {4,2,6,5,1,3};
        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }
}
