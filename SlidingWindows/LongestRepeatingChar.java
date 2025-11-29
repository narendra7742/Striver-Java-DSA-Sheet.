package SlidingWindows;

public class LongestRepeatingChar {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k =2;
        int ans = calculateString(s,k);
        System.out.println(ans);
    }
    public static int calculateString(String s, int k) {
        int l=0,r=0,maxLen=0,maxFreq=0;
        int[] hash = new int[26];
        while(r<s.length()){
            hash[s.charAt(r)-'A']++;
            maxFreq = Math.max(maxFreq, hash[s.charAt(r)-'A']);
            if((r-l+1)-maxFreq >k){
                hash[s.charAt(l)-'A']--;
                // maxFreq =0;
                // for(int i=0;i<26;i++){
                //     maxFreq = Math.max(maxFreq, hash[i]);
                // }
                l=l+1;
                //  System.out.println("Inside");
            }
            // System.out.println(maxFreq);
            if((r-l+1)-maxFreq <=k){
                maxLen = Math.max(maxLen, (r-l+1));
            }
            r++;
        }
        return maxLen;
    }
}
