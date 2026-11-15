class Solution {
    public int solve(int i, int[] nums, int[] dp) {
        if (i >= nums.length - 1) {
            return 0;
        }
        
        if (dp[i] != -1) {
            return dp[i];
        }

        int minJumps = (int) 1e9;
        
        for (int step = 1; step <= nums[i]; step++) {
            int jumps = 1 + solve(i + step, nums, dp);
            minJumps = Math.min(minJumps, jumps);
        }

        return dp[i] = minJumps;
    }

    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return solve(0, nums, dp);
    }
}