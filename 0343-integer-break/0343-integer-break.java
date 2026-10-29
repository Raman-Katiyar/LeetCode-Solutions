class Solution {
    public int solve(int n, int[] dp) {
    if (n == 2) return 1;

    if(dp[n] != 0) return dp[n];

    int max = 0;

    for (int i = 1; i < n; i++) {
        int t1 = i * (n - i);
        int t2 = i * solve(n - i, dp);

        int b = Math.max(t1, t2);
        max = Math.max(max, b);
    }

    return dp[n] = max;
}
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        return solve(n, dp);
    }
}