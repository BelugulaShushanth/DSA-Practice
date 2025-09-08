package algorithms.sorts.strivers.arrays;

import java.util.*;

public class Main {

    static int longestSubarrayWithSumKOptimal(int[] nums, int k){
        Map<Integer, Integer> prefixSum = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            if(sum == k){
                maxLen = i+1;
            }
            int rem = sum - k;
            if(prefixSum.containsKey(rem)){
                maxLen = Math.max(maxLen, i - prefixSum.get(rem));
            }
            prefixSum.putIfAbsent(sum, i);
        }
        return maxLen;
    }

    static int longestSubarrayWithSumKBetter(int[] nums, int k) {
        //only for positives
        int maxLen = 0;
        int sum = nums[0];
        int left=0,right=0;
        while (right < nums.length){
            while (left<=right && sum > k){
                sum -= nums[left];
                left++;
            }
            if (sum == k){
                maxLen = Math.max(maxLen, right - left + 1);
            }
            right++;
            if(right < nums.length) sum += nums[right];
        }
        return maxLen;
    }

    static void sortAnArrayOf0s1s2s(int nums[]){
        /*
        Dutch national flag algorithm
         00000 111111 unsorted 2222222
         l l-1 l  m-1 m      h h+1 n-1
         m <= h
         nums[m] == 0 swap(nums[m], nums[l]) l++, m++
         nums[m] == 1 m++;
         nums[m] == 2 swap(nums[m], nums[h]) h--;
         TC: O(N)
         SC: 0(1)
        */
        int low=0, mid = 0, high = nums.length-1;
        while (mid<=high){
            if(nums[mid] == 0){
                swap(nums, mid, low);
                mid++;
                low++;
            } else if (nums[mid] == 1) {
                mid++;
            }else{
                swap(nums, mid, high);
                high--;
            }
        }
    }

    static void swap(int[] inp, int i, int j){
        int temp = inp[i];
        inp[i] = inp[j];
        inp[j] = temp;
    }

    public static void main(String[] args) {
        int maxLen = longestSubarrayWithSumKOptimal(new int[]{1,2,3,1,1,1,1,3,3}, 3);
        int maxLenOpt = longestSubarrayWithSumKBetter(new int[]{1,2,3,1,1,1,1,3,3}, 3);
        System.out.println("longestSubarrayWithSumK: "+maxLen);
        System.out.println("longestSubarrayWithSumKBetter: "+maxLenOpt);

        int[] nums = new int[]{2,2,1,0,1,2,1,0,0,1,2,1,0};
        sortAnArrayOf0s1s2s(nums);
        System.out.println("sortAnArrayOf0s1s2s: "+Arrays.toString(nums));
    }
}
