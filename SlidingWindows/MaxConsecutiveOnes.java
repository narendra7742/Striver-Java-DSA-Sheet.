package SlidingWindows;

public class MaxConsecutiveOnes {
    public static int maxPossibleOnes(int[] nums, int k) {
        int l = 0, r = 0, maxLen = 0, zero = 0;
        while (r < nums.length) {
            if (nums[r] == 0) zero++;
            if (zero > k) {               // Can use while also here, But if statement set fixed number and use could not calculate previously number again
                if (nums[l] == 0) zero--;
                l++;
            }
            if (zero <= k) {
                int len = r - l + 1;
                maxLen = Math.max(len, maxLen);
            }
            r++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        int ans = maxPossibleOnes(arr, k);
        System.out.println(ans);
    }
}
