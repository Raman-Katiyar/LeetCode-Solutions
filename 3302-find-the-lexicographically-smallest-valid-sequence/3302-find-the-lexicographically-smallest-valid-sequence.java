class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        int[] maxIndex = new int[m];
        int w1Idx = n - 1;
        
        for (int j = m - 1; j >= 0; j--) {
            while (w1Idx >= 0 && word1.charAt(w1Idx) != word2.charAt(j)) {
                w1Idx--;
            }
            if (w1Idx >= 0) {
                maxIndex[j] = w1Idx;
                w1Idx--;
            } else {
                maxIndex[j] = -1;
            }
        }

        int[] result = new int[m];
        boolean skipped = false; 
        int j = 0;

        for (int i = 0; i < n && j < m; i++) {
            boolean isMatch = (word1.charAt(i) == word2.charAt(j));

            if (isMatch) {
                result[j++] = i;
            } else if (!skipped) {
                if (j == m - 1 || (maxIndex[j + 1] != -1 && maxIndex[j + 1] > i)) {
                    result[j++] = i;
                    skipped = true;
                }
            }
        }

        return j == m ? result : new int[0];
    }
}