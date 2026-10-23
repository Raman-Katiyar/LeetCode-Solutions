import java.util.List;

class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        Integer[][] dp = new Integer[piles.size()][k+1];
        return solve(0, k, piles, dp);
    }

    private int solve(int i, int k, List<List<Integer>> piles, Integer[][] dp) {
        if (i == piles.size() || k == 0) {
            return 0;
        }

        if(dp[i][k] != null) return dp[i][k];

        int maxVal = solve(i + 1, k, piles, dp);

        int currentPileSum = 0;
        int takeLimit = Math.min(k, piles.get(i).size());

        for (int c = 0; c < takeLimit; c++) {
            currentPileSum += piles.get(i).get(c);
            maxVal = Math.max(maxVal, currentPileSum + solve(i + 1, k - (c + 1), piles, dp));
        }

        return dp[i][k] = maxVal;
    }
}