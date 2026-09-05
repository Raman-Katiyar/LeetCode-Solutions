class Solution {
    public boolean solve(int i, String s, List<String> w, Boolean[] dp) {
        if (i == s.length()) return true;

        if(dp[i] != null) return dp[i];

        for (int end = i + 1; end <= s.length(); end++) {
            String sub = s.substring(i, end);
            if (w.contains(sub) && solve(end, s, w, dp)) {
                return dp[i] = true;
            }
        }

        return dp[i] = false;
    }

    public boolean wordBreak(String s, List<String> w) {
        Boolean[] dp = new Boolean[s.length()];
        return solve(0, s, w, dp);
    }
}