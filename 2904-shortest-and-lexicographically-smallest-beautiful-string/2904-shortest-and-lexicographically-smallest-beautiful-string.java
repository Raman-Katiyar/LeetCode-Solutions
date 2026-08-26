class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int left = 0;
        int count = 0;
        String ans = "";

        for (int right = 0; right < n; right++) {
            if (s.charAt(right) == '1') {
                count++;
            }

            while (count == k) {
                if (s.charAt(left) == '0') {
                    left++;
                    continue;
                }
                String current = s.substring(left, right + 1);

                if (ans.isEmpty() || current.length() < ans.length()) {
                    ans = current;
                } else if (current.length() == ans.length() && current.compareTo(ans) < 0) {
                    ans = current;
                }
                count--;
                left++;
            }
        }

        return ans;
    }
}