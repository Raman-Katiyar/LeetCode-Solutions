class Solution {
    public boolean solve(int i, int j, String s, boolean[][] dp){
        if(i >= j) return true;

        if(dp[i][j] != false) return dp[i][j];

        if(s.charAt(i) == s.charAt(j)){
            return dp[i][j] = solve(i+1, j-1, s, dp);
        }

        return dp[i][j] = false;
    }
    public int countSubstrings(String s) {
        int cnt = 0;
        int n = s.length();

        boolean[][] dp = new boolean[s.length()+1][s.length()+1];

        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(solve(i, j, s, dp)) cnt++;
            }
        }
        return cnt;
    }
}