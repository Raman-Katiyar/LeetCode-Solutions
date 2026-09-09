class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length + 1];
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<=nums.length; j++){
                dp[i][j] = -1;
            }
        }
        return solve(nums, 0, -1, dp);
    }
    
    private int solve(int[] nums, int curr, int prev, int[][] dp) {
        if (curr == nums.length) {
            return 0;
        }

        if(dp[curr][prev + 1] != -1) return dp[curr][prev + 1];
        
        int exclude = solve(nums, curr + 1, prev, dp);
        
        int include = 0;
        if (prev == -1 || nums[curr] > nums[prev]) {
            include = 1 + solve(nums, curr + 1, curr, dp);
        }
        
        return dp[curr][prev + 1] = Math.max(exclude, include);
    }
}