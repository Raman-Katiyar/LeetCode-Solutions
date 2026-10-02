class Solution {
    public int solve(int i, int j, String w1, String w2, int[][] dp){
        if(j == w2.length()) return w1.length() - i;
        if(i == w1.length()) return w2.length() - j;

        if(dp[i][j] != -1) return dp[i][j];

        if(w1.charAt(i) == w2.charAt(j)){
            return dp[i][j] = solve(i+1, j+1, w1, w2, dp);
        } else {
            int d1 = solve(i+1, j, w1, w2, dp);
            int d2 = solve(i, j+1, w1, w2, dp);

            return dp[i][j] = 1+Math.min(d1, d2);
        }

    }
    public int minDistance(String w1, String w2) {
        int[][] dp = new int[w1.length()+1][w2.length()+1];

        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        return solve(0, 0, w1, w2, dp);
    }
}