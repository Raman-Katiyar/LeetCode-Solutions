class Solution {
    static int[][] dp;
    public int lcs(int i, int j, StringBuilder a, StringBuilder b){
        if(i<0 || j<0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(a.charAt(i)==b.charAt(j))
            return dp[i][j] = 1+lcs(i-1, j-1, a,b);
        else
            return dp[i][j] = Math.max(lcs(i-1, j, a, b), lcs(i, j-1, a, b));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        StringBuilder a = new StringBuilder(text1);
        StringBuilder b = new StringBuilder(text2);
        int m = a.length(), n = b.length();

        dp = new int[m][n];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        return lcs(m-1, n-1, a, b);
    }
}