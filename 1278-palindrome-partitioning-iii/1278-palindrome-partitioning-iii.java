class Solution {
    int[][] dp;
    int n;

    public int palindromePartition(String s, int k) {
        n = s.length();
        dp = new int[n][k + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(s, 0, k);
    }
    private int solve(String s, int i, int k) {
        if (k == 1) {
            return getCost(s, i, n - 1);
        }
        if (dp[i][k] != -1) {
            return dp[i][k];
        }

        int minCost = 1000000;
        for (int j = i; j <= n - k; j++) {
            int currentCost = getCost(s, i, j);
            int remainingCost = solve(s, j + 1, k - 1);
            minCost = Math.min(minCost, currentCost + remainingCost);
        }

        return dp[i][k] = minCost;
    }
    private int getCost(String s, int i, int j) {
        int changes = 0;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                changes++;
            }
            i++;
            j--;
        }
        return changes;
    }
}