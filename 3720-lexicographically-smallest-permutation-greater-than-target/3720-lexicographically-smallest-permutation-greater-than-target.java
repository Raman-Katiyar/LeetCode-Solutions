import java.util.*;

class Solution {
    private String result = "";
    private int n;

    public String lexGreaterPermutation(String s, String target) {
        n = s.length();
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        result = "";
        if (solve(0, target, count, new StringBuilder())) {
            return result;
        }
        return "";
    }

    private boolean solve(int idx, String target, int[] count, StringBuilder current) {
        if (idx == n) {
            String candidate = current.toString();
            if (candidate.compareTo(target) > 0) {
                result = candidate;
                return true;
            }
            return false;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] == 0) continue;

            char ch = (char) ('a' + i);

            count[i]--;
            current.append(ch);

            String currentStr = current.toString();
            if (target.startsWith(currentStr)) {
                if (solve(idx + 1, target, count, current)) {
                    return true;
                }
            } else if (currentStr.compareTo(target.substring(0, idx + 1)) > 0) {
                StringBuilder remaining = new StringBuilder();
                for (int j = 0; j < 26; j++) {
                    for (int k = 0; k < count[j]; k++) {
                        remaining.append((char) ('a' + j));
                    }
                }
                String finalResult = currentStr + remaining.toString();
                if (finalResult.compareTo(target) > 0) {
                    result = finalResult;
                    return true;
                }
            }

            current.deleteCharAt(current.length() - 1);
            count[i]++;
        }

        return false;
    }
}