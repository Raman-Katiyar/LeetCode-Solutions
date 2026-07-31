import java.util.Arrays;

class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }
        Arrays.sort(freq);

        int totalPushes = 0;
        for (int i = 0; i < 26; i++) {
            int count = freq[25 - i]; 
            
            if (count == 0) break; 
            int pushCount = (i / 8) + 1;
            
            totalPushes += count * pushCount;
        }

        return totalPushes;
    }
}