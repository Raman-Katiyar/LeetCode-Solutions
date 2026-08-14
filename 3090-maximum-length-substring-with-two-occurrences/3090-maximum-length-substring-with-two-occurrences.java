class Solution {
    public int maximumLengthSubstring(String s) {
        int maxLength = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int[] charCounts = new int[26];
            for (int j = i; j < n; j++) {
                char currentChar = s.charAt(j);
                charCounts[currentChar - 'a']++;
                if (charCounts[currentChar - 'a'] > 2) {
                    break;
                }
                maxLength = Math.max(maxLength, j - i + 1);
            }
        }

        return maxLength;
    }
}