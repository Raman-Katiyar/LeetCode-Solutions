class Solution {
    public boolean makeEqual(String[] words) {
        int[] freq = new int[26];
        int n = words.length;

        for (String word : words) {
            for (char c : word.toCharArray()) {
                freq[c - 'a']++;
            }
        }

        for (int count : freq) {
            if (count % n != 0) {
                return false;
            }
        }
        return true;
    }
}