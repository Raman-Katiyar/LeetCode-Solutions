class Solution {
    public String modifyString(String s) {
        String ans = "";
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '?') {
                ans += s.charAt(i);
            }

            if (s.charAt(i) == '?') {
                for (char j = 'a'; j <= 'z'; j++) {
                    boolean leftMatch = (i > 0 && ans.charAt(i - 1) == j);
                    boolean rightMatch = (i < s.length() - 1 && s.charAt(i + 1) == j);

                    if (!leftMatch && !rightMatch) {
                        ans += j;
                        break;
                    }
                }
            }
        }
        
        return ans;
    }
}