class Solution {
    public int solve(int i, String s, int[] dp){
        if(i == s.length()) return 1;
        if(s.charAt(i) == '0') return 0;

        if(dp[i] != -1) return dp[i];

        int ways = solve(i+1, s, dp);

        if(i+1 < s.length()){
            char f = s.charAt(i);
            char sc = s.charAt(i+1);

            if(f=='1' || (f=='2' && sc < '7')){
                ways += solve(i+2, s, dp);
            }
        }
        return dp[i] = ways;
    }
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return solve(0, s, dp);
    }
}