class Solution {
    public boolean solve(int i, int j, String s, String p, Boolean[][] dp) {
        if (j == p.length()) return i == s.length();

        if(dp[i][j] != null) return dp[i][j];
        if (i == s.length()) {
            for (int k = j; k < p.length(); k++) {
                if (p.charAt(k) != '*') return dp[i][j] = false;
            }
            return dp[i][j] = true;
        }

        if (p.charAt(j) == '*') {
            return dp[i][j] = solve(i, j + 1, s, p, dp) || solve(i + 1, j, s, p, dp);
        }

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            return dp[i][j] = solve(i + 1, j + 1, s, p, dp);
        }

        return dp[i][j] = false;
    }

    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length()+1][p.length()+1];
        return solve(0, 0, s, p, dp);
    }
}