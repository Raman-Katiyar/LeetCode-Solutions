class Solution {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length][m + 1][n + 1];

        for (int[][] mat : dp) {
            for (int[] row : mat) {
                Arrays.fill(row, -1);
            }
        }
        return solve(strs, 0, m, n, dp);
    }

    public int solve(String[] strs, int index, int m, int n, int[][][] dp) {

        if (index == strs.length) {
            return 0;
        }

        if (dp[index][m][n] != -1) {
            return dp[index][m][n];
        }

        int zero = 0;
        int one = 0;

        for (int j = 0; j < strs[index].length(); j++) {
            if (strs[index].charAt(j) == '0') {
                zero++;
            } else {
                one++;
            }
        }

        int notTake = solve(strs, index + 1, m, n, dp);

        int take = 0;
        if (zero <= m && one <= n) {
            take = 1 + solve(strs, index + 1, m - zero, n - one, dp);
        }

        return dp[index][m][n] = Math.max(take, notTake);
    }
}