class Solution {
    int MOD = 1_000_000_007;

    public int solve(int i, int n, int min, int[] g, int[] p, Integer[][][] memo) {
        if (i == g.length) {
            return min <= 0 ? 1 : 0;
        }

        if (memo[i][n][min] != null) {
            return memo[i][n][min];
        }

        int notPick = solve(i + 1, n, min, g, p, memo);

        int pick = 0;
        if (g[i] <= n) {
            pick = solve(i + 1, n - g[i], Math.max(0, min - p[i]), g, p, memo);
        }

        return memo[i][n][min] = (notPick + pick) % MOD;
    }

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        Integer[][][] memo = new Integer[group.length][n + 1][minProfit + 1];
        return solve(0, n, minProfit, group, profit, memo);
    }
}