class Solution {
    public int minDistance(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        for(int i=0; i<s1.length(); i++){
            for(int j=0; j<s2.length(); j++){
                dp[i][j] = -1;
            }
        }
        return solve(0, 0, s1, s2, dp);
    }

    private int solve(int i, int j, String s1, String s2, int[][] dp) {
        int m = s1.length();
        int n = s2.length();

        if (i == m) return n - j;
        if (j == n) return m - i;

        if(dp[i][j] != -1) return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = solve(i + 1, j + 1, s1, s2, dp);
        }

        int ins = solve(i, j + 1, s1, s2, dp);
        int del = solve(i + 1, j, s1, s2, dp);
        int rep = solve(i + 1, j + 1, s1, s2, dp);

        return dp[i][j] = 1 + Math.min(ins, Math.min(del, rep));
    }
}