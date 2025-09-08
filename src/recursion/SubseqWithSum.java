package recursion;

import java.util.*;

public class SubseqWithSum {

    static int find(int[] nums, int target, int i, int count, List<Integer> l){

        if(i == nums.length){
            System.out.println(l);
           // l.is
            int min = l.get(0);
            int max = l.get(0);
            for(int k=1; k<l.size(); k++ ){
                if(l.get(k) < min) min = l.get(k);
                if(l.get(k) > max ) max = l.get(k);
            }
            if(min + max <= target){
                return count + 1;
            }
            return 0;
        }

        l.add(nums[i]);
        int x = count + find(nums, target, i+1,count, l);

        l.remove(Integer.valueOf(nums[i]));
        int y = count + find(nums,target, i+1, count, l);
        return x+y;
    }

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        /*
          {"Delhi", "Mumbai"},
   {"Mumbai", "Bangalore"},
   {"Delhi", "Chennai"},
   {"Chennai", "Bangalore"},
   {"Delhi", "Kolkata"}
         */
        map.put("Delhi", "Mumbai");
        map.put("Mumbai", "Bangalore");
        map.put("Delhi", "Chennai");
        map.put("Chennai", "Bangalore");
        map.put("Delhi", "Kolkata");
        
    }
}
