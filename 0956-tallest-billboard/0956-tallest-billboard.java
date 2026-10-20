class Solution {
    public int tallestBillboard(int[] a) {
        int s = 0;
        for (int x : a) s += x;
        Integer[][] dp = new Integer[a.length][s + 1];
        return solve(a, 0, 0, dp);
    }

    private int solve(int[] a, int i, int d, Integer[][] dp) {
        if (i == a.length) {
            return d == 0 ? 0 : Integer.MIN_VALUE / 2;
        }

        if (dp[i][d] != null) return dp[i][d];

        int r = a[i];

        int o1 = solve(a, i + 1, d, dp);
        int o2 = r + solve(a, i + 1, d + r, dp);
        int o3 = (r <= d) ? solve(a, i + 1, d - r, dp) : (r - d) + solve(a, i + 1, r - d, dp);

        return dp[i][d] = Math.max(o1, Math.max(o2, o3));
    }
}