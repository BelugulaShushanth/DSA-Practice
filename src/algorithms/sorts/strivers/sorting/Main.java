package algorithms.sorts.strivers.sorting;

import java.util.*;

public class Main {

    static void selectionSort(int[] inp) {
        /*
        select minimum and swap
        Best, worst, avg time complexity = O(n^2)
         */
        for(int i=0; i<inp.length - 1; i++){
            int min = i;
            for(int j=i+1; j<inp.length; j++){
                if(inp[j] < inp[min]){
                    min = j;
                }
            }
            if(i!=min) {
                swap(inp, i, min);
            }
        }
    }

    static void bubbleSort(int[] inp){
        /*
        swap adjacent so that the max will be at the end
        worst , avg time complexity = O(N^2)
        best = O(N)
         */
        for(int i=inp.length-1; i>=0; i--){
            boolean isNotSwapped = true;
            for(int j=0; j<i; j++){
                if(inp[j] > inp[j+1]){
                    swap(inp, j, j+1);
                    isNotSwapped = false;
                }
            }

            if(isNotSwapped){
                break;
            }
        }
    }

    static void insertionSort(int[] inp){
        /*
        Take every element and place it in the correct order
        worst , avg time complexity = O(N^2)
        best = O(N)
         */
        for(int i=1; i<inp.length; i++){
            int j = i;
            while (j>0 && inp[j-1] > inp[j]){
                swap(inp, j-1, j);
                j--;
            }
        }
    }

    static void mergeSort(int[] inp, int low, int high){
        /*
        divide and merge
        best,avg, worst complexity : O(N*logN)
        space complexity: 0(N)
         */
        if(low == high) return;
        int mid = (low + high)/2;
        mergeSort(inp, low, mid);
        mergeSort(inp, mid + 1, high);
        merge(inp, low, mid, high);
    }

    static void merge(int[] inp, int low, int mid, int high) {
        int left = low;
        int right = mid+1;
        int[] temp = new int[high+1];
        int index = 0;
        while (left <= mid && right <= high){
            if(inp[left] <= inp[right]){
                temp[index] = inp[left];
                left++;
            }else{
                temp[index] = inp[right];
                right++;
            }
            index++;
        }
        while (left<=mid){
            temp[index] = inp[left];
            left++;
            index++;
        }
        while (right<=high){
            temp[index] = inp[right];
            right++;
            index++;
        }

        for(int i=low; i<=high; i++){
            inp[i] = temp[i-low];
        }
    }

    static void quickSort(int[] inp, int left, int right){
        /*
        1.pick a pivot. pivot can be any element in the array
        2. keep the elements less than pivot on left and greater on right
         */
        if(left < right){
            int pIndex = findPartition(inp, left, right);
            quickSort(inp, left, pIndex-1);
            quickSort(inp, pIndex + 1, right);
        }
    }

    static int findPartition(int[] inp, int left, int right) {
        int pivot = inp[left];
        int i = left;
        int j = right;
        while (i < j){
            while (inp[i] <= pivot && i<=right-1){
                i++;
            }
            while (inp[j] > pivot && j>=left+1){
                j--;
            }
            if(i<j) swap(inp, i, j);
        }
        swap(inp, left, j);
        return j;
    }

    public static void main(String[] args) {
        int[] inp = new int[]{28, 32, 16, 9, 52, 45};
        //selectionSort(inp);
        // bubbleSort(inp);
        //insertionSort(inp);
       // mergeSort(inp, 0, inp.length-1);
        quickSort(inp, 0, inp.length-1);
        System.out.println(Arrays.toString(inp));

        List<Integer> list = new LinkedList<>(Arrays.asList(6,4,8,3));



    }

    static void swap(int[] inp, int i, int j){
        int temp = inp[i];
        inp[i] = inp[j];
        inp[j] = temp;
    }
}
