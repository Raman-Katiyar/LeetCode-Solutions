class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){ 
                dp[i][j] = -1;
            }
        }
        return solve(s.length() - 1, t.length() - 1, s, t, dp);
    }

    private int solve(int i, int j, String s, String t, int[][] dp) { 
        if (j < 0) {
            return 1;
        }
        if (i < 0) {
            return 0;
        }

        if(dp[i][j] != -1) return dp[i][j];

        int count = 0;
        if (s.charAt(i) == t.charAt(j)) {
            count = solve(i - 1, j - 1, s, t, dp) + solve(i - 1, j, s, t, dp);
        } else {
            count = solve(i - 1, j, s, t, dp);
        }

        return dp[i][j] = count;
    }
}