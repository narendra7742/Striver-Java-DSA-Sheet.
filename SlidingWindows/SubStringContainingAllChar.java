package SlidingWindows;

public class SubStringContainingAllChar {
    public static void main(String[] args) {
        String s = "bbacba";
        int ans = calculateSubstring(s);
        System.out.println(ans);
    }
    public static int calculateSubstring(String s){
        int[] lastSeen = {-1,-1,-1};
        int ans =0;
        for(int i=0;i<s.length();i++){
            lastSeen[s.charAt(i) - 'a'] = i;
            if(lastSeen[0]!=-1 || lastSeen[1]!=-1 || lastSeen[2]!=-1){
                ans += 1+ Math.min(lastSeen[0], Math.min(lastSeen[1],lastSeen[2]));
            }
        }
        return ans;
    }
}
