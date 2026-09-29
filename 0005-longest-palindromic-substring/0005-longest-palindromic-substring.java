class Solution {
    Boolean[][] dp;

    public String longestPalindrome(String s) {
        int n = s.length(), len = 0, st = 0;
        dp = new Boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (check(s, i, j) && (j - i + 1) > len) {
                    len = j - i + 1;
                    st = i;
                }
            }
        }

        return s.substring(st, st + len);
    }

    private boolean check(String s, int i, int j) {
        if (i >= j) return true;
        if (dp[i][j] != null) return dp[i][j];
        if (s.charAt(i) != s.charAt(j)) return dp[i][j] = false;
        return dp[i][j] = check(s, i + 1, j - 1);
    }
}