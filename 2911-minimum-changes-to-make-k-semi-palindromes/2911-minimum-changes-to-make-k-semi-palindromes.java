class Solution {
    int[][] dp;
    int[][] costMemo;
    int n;

    public int minimumChanges(String s, int k) {
        n = s.length();
        dp = new int[n][k + 1];
        costMemo = new int[n][n];

        for (int[] row : dp) Arrays.fill(row, -1);
        for (int[] row : costMemo) Arrays.fill(row, -1);

        return solve(s, 0, k);
    }

    private int solve(String s, int i, int k) {
        if (k == 1) {
            if (n - i < 2) return 1000000; 
            return getCost(s, i, n - 1);
        }

        if (dp[i][k] != -1) return dp[i][k];

        int minCost = 1000000;
        for (int j = i + 1; j <= n - 2 * (k - 1) - 1; j++) {
            int currentCost = getCost(s, i, j);
            int remainingCost = solve(s, j + 1, k - 1);
            minCost = Math.min(minCost, currentCost + remainingCost);
        }

        return dp[i][k] = minCost;
    }

    private int getCost(String s, int i, int j) {
        if (costMemo[i][j] != -1) return costMemo[i][j];

        int L = j - i + 1;
        int minChanges = 1000000;

        for (int d = 1; d < L; d++) {
            if (L % d != 0) continue;

            int changes = 0;
            for (int g = 0; g < d; g++) {
                int left = i + g;
                int right = left + (L / d - 1) * d;

                while (left < right) {
                    if (s.charAt(left) != s.charAt(right)) {
                        changes++;
                    }
                    left += d;
                    right -= d;
                }
            }
            minChanges = Math.min(minChanges, changes);
        }
        return costMemo[i][j] = minChanges;
    }
}