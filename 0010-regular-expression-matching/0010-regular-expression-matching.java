class Solution {
    public boolean solve(int i, int j, String s, String p) {
        if (j == p.length()) return i == s.length();

        boolean match = (i < s.length()) && 
                        (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            return solve(i, j + 2, s, p) || (match && solve(i + 1, j, s, p));
        }

        if (match) {
            return solve(i + 1, j + 1, s, p);
        }

        return false;
    }

    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        return solve(0, 0, s, p);
    }
}