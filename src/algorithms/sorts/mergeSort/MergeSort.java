package algorithms.sorts.mergeSort;

import java.util.Arrays;

public class MergeSort {

    // space complexity is O(n) time complexity is O(n log n)
    public static int[] merge(int[] array1, int[] array2){
        int[] combinedArray = new int[array1.length + array2.length];
        int index = 0, i = 0, j = 0;
        while (i < array1.length && j < array2.length){
            if(array1[i] < array2[j]){
                combinedArray[index] = array1[i];
                i++;
            }
            else{
                combinedArray[index] = array2[j];
                j++;
            }
            index++;
        }
        while (i < array1.length){
            combinedArray[index] = array1[i];
            index++;
            i++;
        }
        while (j < array2.length){
            combinedArray[index] = array2[j];
            index++;
            j++;
        }

        return combinedArray;
    }

    public static int[] mergeSort(int[] array){
        if(array.length == 1) return array;

        int midIndex = array.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(array, 0, midIndex));
        int[] right = mergeSort(Arrays.copyOfRange(array, midIndex, array.length));

        return merge(left, right);
    }

    public static void main(String[] args) {

        int array1[] = {1,3,7,8};
        int array2[] = {2,4,5,6};
        System.out.println(Arrays.toString(merge(array1,array2)));

        int[] array = {3,1,4,2};
        int[] sortedArray = mergeSort(array);
        System.out.println("Original Array: "+Arrays.toString(array));
        System.out.println("Sorted Array: "+Arrays.toString(sortedArray));
    }

}
