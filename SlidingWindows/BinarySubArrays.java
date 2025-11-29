package SlidingWindows;

public class BinarySubArrays {
    public static void main(String[] args) {
        int[] arr ={1,0,1,0,1};
        int goal = 2;
        if(goal<0){
            System.out.println(0);
            return;
        }
       int  ans = calculateSum(arr, goal)- calculateSum(arr,goal-1);
        System.out.println(ans);
    }
    private static int calculateSum(int[] nums,int goal){
        int l=0,r=0,sum=0,cnt=0;
        if(goal<0) return 0;
        while(r<nums.length){
            sum+=nums[r];
            while(sum>goal){
                sum=sum-nums[l];
                l=l+1;

            }
            cnt = cnt + (r-l+1);
            r=r+1;
        }
        return cnt;
    }
}
