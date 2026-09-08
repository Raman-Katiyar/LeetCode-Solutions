import java.util.Arrays;

class Solution {
    public int amount(int[] nums, int i, int end, int[] dp){
        if(i > end) return 0;
        if(dp[i] != -1) return dp[i];
        int take = nums[i] + amount(nums, i + 2, end, dp);
        int skip = amount(nums, i + 1, end, dp);
        return dp[i] = Math.max(take, skip);
    }
    
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int n = nums.length;
        
        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);
        int case1 = amount(nums, 0, n - 2, dp1);
        
        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1);
        int case2 = amount(nums, 1, n - 1, dp2);
        
        return Math.max(case1, case2);
    }
}