class Solution {
    public boolean stoneGame(int[] piles) {
        int[][] dp = new int[piles.length][piles.length];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ans = solve(0, piles.length-1, piles, dp);

        return ans>=0;
    }

    private int solve(int st, int en, int[] piles, int[][] dp){
        if(st==en) return piles[st];

        if(dp[st][en] != -1) return dp[st][en];

        int ft = piles[st] - solve(st+1, en, piles, dp);
        int lt = piles[en] - solve(st, en-1, piles, dp);

        return dp[st][en] = Math.max(ft, lt);
    }
}