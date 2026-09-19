class Solution {
    private int solve(int i, String s, Set<String> dict, int[]dp) {
        if (i >= s.length()) {
            return 0;
        }

        if(dp[i] != -1) return dp[i];

        int minExtra = 1 + solve(i + 1, s, dict, dp);

        StringBuilder curr = new StringBuilder();
        for (int j = i; j < s.length(); j++) {
            curr.append(s.charAt(j));
            if (dict.contains(curr.toString())) {
                minExtra = Math.min(minExtra, solve(j + 1, s, dict, dp));
            }
        }

        return dp[i] = minExtra;
    }

    public int minExtraChar(String s, String[] dictionary) {
        Set<String> dict = new HashSet<>();
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        for (String word : dictionary) {
            dict.add(word);
        }

        return solve(0, s, dict, dp);
    }
}