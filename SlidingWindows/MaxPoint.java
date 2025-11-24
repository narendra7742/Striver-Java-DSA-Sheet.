package SlidingWindows;

public class MaxPoint {
    public static int maxPointInCard(int[] nums, int k) {
        int l = 0, r = 0, rightIndex = nums.length - 1, maxSum = 0;
        for (int i = 0; i < k; i++) {
            l = l + nums[i];
        }
        for (int i = k - 1; i >= 0; i--) {
            l = l - nums[i];
            r = r + nums[rightIndex];
            rightIndex--;
            maxSum = Math.max(maxSum, l + r);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {6, 2, 3, 4, 7, 2, 1, 7, 1};
        int k = 4;
        int ans = maxPointInCard(arr, k);
        System.out.println(ans);
    }

}
