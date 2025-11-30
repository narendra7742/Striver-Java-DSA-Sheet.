package SlidingWindows;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubString {
    public static void main(String[] args) {
        String s = "ddaaabbca";
        String t = "abc";
        String ans = findWindow(s, t);
        System.out.println(ans);

    }
    public static String findWindow(String s, String t){
        int l=0,r=0,minLen=Integer.MAX_VALUE,sIndex =-1;
        int cnt = 0, n=s.length(), m= t.length();
        Map<Character, Integer> hm = new HashMap<>();
        for(int i=0;i<m;i++){
            hm.put(t.charAt(i), hm.getOrDefault(t.charAt(i),0)+1);
        }
        while(r<s.length()){
            // System.out.println(hm);
            if(hm.get(s.charAt(r)) != null && hm.get(s.charAt(r)) >0){
                cnt++;
            }
            hm.put(s.charAt(r), hm.getOrDefault(s.charAt(r),0)-1);
            // System.out.println(hm.get(s.charAt(r))+"-"+cnt+"-"+s.substring(0,r+1));
            while(cnt ==m){
                if((r-l+1) < minLen){
                    minLen = Math.min(minLen, (r-l+1));
                    sIndex = l;
                }
                // System.out.println(l+"-"+s.charAt(l)+" "+cnt+"  "+hm.get(s.charAt(l)));
                hm.put(s.charAt(l), hm.getOrDefault(s.charAt(l),0)+1);
                // l++;
                if(hm.get(s.charAt(l)) != null && hm.get(s.charAt(l))>0) cnt = cnt-1;
                l++;
            }
            r++;

        }
        return sIndex ==-1 ? "" : s.substring(sIndex,sIndex + minLen);
    }
}
