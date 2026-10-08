class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            java.util.Arrays.fill(dp[i], -1);
        }

        // Step 1: Recursion + Memoization sirf numbers (LCS length) par
        lcs(0, 0, str1, str2, dp);

        // Step 2: DP table aur choices ko follow karke string build karo
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;

        while (i < m && j < n) {
            if (str1.charAt(i) == str2.charAt(j)) {
                sb.append(str1.charAt(i));
                i++;
                j++;
            } else {
                int takeS1 = (i + 1 < m) ? dp[i + 1][j] : 0;
                int takeS2 = (j + 1 < n) ? dp[i][j + 1] : 0;

                if (takeS1 >= takeS2) {
                    sb.append(str1.charAt(i));
                    i++;
                } else {
                    sb.append(str2.charAt(j));
                    j++;
                }
            }
        }

        while (i < m) {
            sb.append(str1.charAt(i++));
        }
        while (j < n) {
            sb.append(str2.charAt(j++));
        }

        return sb.toString();
    }

    private int lcs(int i, int j, String s1, String s2, int[][] dp) {
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = 1 + lcs(i + 1, j + 1, s1, s2, dp);
        }

        return dp[i][j] = Math.max(lcs(i + 1, j, s1, s2, dp), lcs(i, j + 1, s1, s2, dp));
    }
}