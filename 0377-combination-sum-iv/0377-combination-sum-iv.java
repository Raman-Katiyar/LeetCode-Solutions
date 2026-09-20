class Solution {
    private int solve(int[] nums, int target, int[] dp) {
        if (target == 0) {
            return 1;
        }

        if (dp[target] != -1) {
            return dp[target];
        }

        int totalWays = 0;
        for (int num : nums) {
            if (target >= num) {
                totalWays += solve(nums, target - num, dp);
            }
        }

        return dp[target] = totalWays;
    }

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        return solve(nums, target, dp);
    }
}