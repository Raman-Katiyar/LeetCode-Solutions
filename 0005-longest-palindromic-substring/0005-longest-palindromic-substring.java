class Solution {
    public String longestPalindrome(String s) {
        int n = s.length(), len = 0, st = 0;

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
        if (s.charAt(i) != s.charAt(j)) return false;
        return check(s, i + 1, j - 1);
    }
}