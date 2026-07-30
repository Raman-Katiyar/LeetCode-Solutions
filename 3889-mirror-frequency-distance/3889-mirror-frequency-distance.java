class Solution {
    public int mirrorFrequency(String s) {
        int[] freq = new int[256];

        for (char ch : s.toCharArray()) {
            freq[ch]++;
        }

        int totalDistance = 0;

        for (int i = 0; i < 256; i++) {
            if (freq[i] == 0) continue;

            char c = (char) i;
            char m;

            if (c >= 'a' && c <= 'z') {
                m = (char) ('a' + 'z' - c);
            } else {
                m = (char) ('0' + '9' - c);
            }

            if (c <= m || freq[m] == 0) {
                totalDistance += Math.abs(freq[c] - freq[m]);
            }
        }

        return totalDistance;
    }
}