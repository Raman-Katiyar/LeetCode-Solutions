import java.util.*;

class Solution {
    public String smallestPalindrome(String s, long k) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        int[] halfCount = new int[26];
        char midChar = '\0';
        int halfLen = 0;

        for (int i = 0; i < 26; i++) {
            halfCount[i] = count[i] / 2;
            halfLen += halfCount[i];
            if (count[i] % 2 != 0) {
                midChar = (char) ('a' + i);
            }
        }

        long CAP = k + 1;

        // Total possible permutations check karo
        long totalWays = countPermutations(halfCount, halfLen, CAP);
        if (k > totalWays) {
            return "";
        }

        // Greedy construction of Left Half
        char[] leftHalf = new char[halfLen];

        for (int pos = 0; pos < halfLen; pos++) {
            for (int i = 0; i < 26; i++) {
                if (halfCount[i] > 0) {
                    halfCount[i]--;
                    long ways = countPermutations(halfCount, halfLen - 1 - pos, CAP);

                    if (ways >= k) {
                        leftHalf[pos] = (char) ('a' + i);
                        break;
                    } else {
                        k -= ways;
                        halfCount[i]++; // Backtrack
                    }
                }
            }
        }

        // Construct final string
        int totalLen = s.length();
        char[] res = new char[totalLen];
        for (int i = 0; i < halfLen; i++) {
            res[i] = leftHalf[i];
            res[totalLen - 1 - i] = leftHalf[i];
        }
        if (midChar != '\0') {
            res[halfLen] = midChar;
        }

        return new String(res);
    }

    // Fast & Safe Multinomial Calculation using Capped nCr
    private long countPermutations(int[] freq, int total, long CAP) {
        long ways = 1;
        int remaining = total;

        for (int f : freq) {
            if (f > 0) {
                long ncr = nCr(remaining, f, CAP);
                ways = safeMultiply(ways, ncr, CAP);
                if (ways >= CAP) return CAP;
                remaining -= f;
            }
        }
        return ways;
    }

    // nCr calculation capped at CAP to prevent overflow & speed up execution
    private long nCr(int n, int r, long CAP) {
        if (r < 0 || r > n) return 0;
        if (r == 0 || r == n) return 1;
        if (r > n - r) r = n - r;

        long ans = 1;
        for (int i = 1; i <= r; i++) {
            ans = ans * (n - i + 1) / i;
            if (ans >= CAP) return CAP;
        }
        return Math.min(ans, CAP);
    }

    // Safe Multiplication
    private long safeMultiply(long a, long b, long CAP) {
        if (a == 0 || b == 0) return 0;
        if (a > CAP / b) return CAP;
        return Math.min(CAP, a * b);
    }
}