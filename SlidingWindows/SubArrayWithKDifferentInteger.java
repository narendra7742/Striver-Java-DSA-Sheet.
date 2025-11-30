package SlidingWindows;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithKDifferentInteger {
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,3};
        int k =2;
        int ans = findArray(nums,k) - findArray(nums,k-1);
        System.out.println(ans);
    }
    public static int findArray(int[] nums, int k){
        int l=0,r=0,cnt=0;
        Map<Integer, Integer> map = new HashMap<>();
        while(r<nums.length){
            map.put(nums[r], map.getOrDefault(nums[r],0)+1);
            while(map.size()>k){
                map.put(nums[l], map.get(nums[l]) - 1);
                if(map.get(nums[l]) == 0){
                    map.remove(nums[l]);
                }
                l++;
            }
            cnt = cnt + (r-l+1);
            r++;
        }
        return cnt;
    }
}
