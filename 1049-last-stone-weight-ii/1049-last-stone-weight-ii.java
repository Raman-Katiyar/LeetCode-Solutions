class Solution {
    public int lastStoneWeightII(int[] stones) {
        int totalSum = 0;
        for (int stone : stones) {
            totalSum += stone;
        }

        int target = totalSum / 2;
        int[][] dp = new int[stones.length + 1][target + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        int s1 = helper(0, target, stones, dp);

        return totalSum - 2 * s1;
    }

    private int helper(int index, int remaining, int[] stones, int[][] dp) {
        if (index == stones.length || remaining == 0) {
            return 0;
        }

        if (dp[index][remaining] != -1) {
            return dp[index][remaining];
        }

        int notPick = helper(index + 1, remaining, stones, dp);

        int pick = 0;
        if (stones[index] <= remaining) {
            pick = stones[index] + helper(index + 1, remaining - stones[index], stones, dp);
        }

        return dp[index][remaining] = Math.max(pick, notPick);
    }
}