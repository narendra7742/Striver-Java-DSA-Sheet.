package SlidingWindows;

public class NiceSubstring
{
    public static void main(String[] args) {
        int[] arr = {1,1,2,1,1};
        int k = 3;
        int ans = findOdd(arr, k) - findOdd(arr,k-1);
        System.out.println(ans);
    }
    private static int findOdd(int[] arr, int k){
        int l=0,r=0,sum=0,cnt=0;
        while(r<arr.length){
            sum= sum+ (arr[r]%2);
            while(sum>k){
                sum = sum-(arr[l]%2);
                l=l+1;
            }
            cnt = cnt+(r-l+1);
            r++;
        }
        // System.out.println(cnt);
        return cnt;
    }
}
