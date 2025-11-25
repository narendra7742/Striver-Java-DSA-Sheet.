package SlidingWindows;

import java.util.*;

public class LongestSubStringWithDistict {
    public static void main(String[] args) {
        String s = "aaabbccd";
        int k =2;
        int ans = findLongestSubString(s, k);
        System.out.println(ans);
    }
    public static int findLongestSubString(String s, int k) {
        int l = 0, r = 0, maxLen = 0;
       Map<Integer, Integer> hm = new HashMap<>();
       while(r<s.length()){
           hm.put((int)s.charAt(r), hm.getOrDefault((int)s.charAt(r), 0)+1);
              while(hm.size()>k){
                  hm.put((int)s.charAt(l),hm.get((int)s.charAt(l))-1);
                  if(hm.get((int)s.charAt(l))==0){
                      hm.remove((int)s.charAt(l));
                  }
                  l++;
              }
              if(hm.size()<=k){
                  maxLen = Math.max(maxLen, r-l+1);
              }
              r++;
//           System.out.println("here-"+maxLen);
       }
        return maxLen;
    }
}

