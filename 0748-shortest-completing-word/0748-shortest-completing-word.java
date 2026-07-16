class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] targetCounts = getCharCounts(licensePlate);
        
        String result = "";
        int minLength = Integer.MAX_VALUE;
        
        for (String word : words) {
            if (word.length() < minLength) {
                if (isMatch(word, targetCounts)) {
                    result = word;
                    minLength = word.length();
                }
            }
        }
        
        return result;
    }
    
    private int[] getCharCounts(String s) {
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                counts[Character.toLowerCase(c) - 'a']++;
            }
        }
        return counts;
    }
    
    private boolean isMatch(String word, int[] targetCounts) {
        int[] wordCounts = getCharCounts(word);
        for (int i = 0; i < 26; i++) {
            if (wordCounts[i] < targetCounts[i]) {
                return false;
            }
        }
        return true;
    }
}