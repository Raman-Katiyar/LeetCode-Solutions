class Solution {
    public int solve(int i, int a, int[] coins, Integer[][] dp){
        if(a == 0) return 1;
        if(i == coins.length || a < 0) return 0;

        if(dp[i][a] != null) return dp[i][a];

        int t1 = 0;
        if(coins[i] <= a){
            t1 = solve(i, a-coins[i], coins, dp);
        }
        int t2 = solve(i+1, a, coins, dp);

        return dp[i][a] = t1+t2;
    }
    public int change(int a, int[] coins) {
        Integer[][] dp = new Integer[coins.length][a+1];
        return solve(0, a, coins, dp);
    }
}