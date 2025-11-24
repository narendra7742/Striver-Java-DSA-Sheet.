package SlidingWindows;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBasket {
    public static void main(String[] args) {
        int[] arr = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        int k = 2;
        int ans = calculateMaxFruits(arr, k);
        System.out.println(ans);
    }

    public static int calculateMaxFruits(int[] arr, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        int l = 0, maxfruits = 0;
        for (int r = 0; r < arr.length; r++) {
            hm.put(arr[r], hm.getOrDefault(arr[r], 0) + 1);
            if (hm.size() > k) {
                while (hm.size() > k) {
                    hm.put(arr[l], hm.get(arr[l]) - 1);
                    if (hm.get(arr[l]) == 0) {
                        hm.remove(arr[l]);
                    }
                    l++;
                }
            }
            if (hm.size() <= k) {
                maxfruits = Math.max(maxfruits, r - l + 1);
            }
        }
        return maxfruits;
    }
}
