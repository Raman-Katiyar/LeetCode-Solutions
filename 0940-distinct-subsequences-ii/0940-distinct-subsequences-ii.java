class Solution {
    public int distinctSubseqII(String s) {
        long MOD = 1000000007;
        int n = s.length();
        long[] memo = new long[n + 1];
        java.util.Arrays.fill(memo, -1);
        java.util.Map<Character, Integer> last = new java.util.HashMap<>();

        return (int) solve(n, s, memo, last, MOD);
    }

    private long solve(int i, String s, long[] memo, java.util.Map<Character, Integer> last, long MOD) {
        if (i == 0) return 0;
        if (memo[i] != -1) return memo[i];

        long res = (2 * solve(i - 1, s, memo, last, MOD) + 1) % MOD;
        char ch = s.charAt(i - 1);

        if (last.containsKey(ch)) {
            int prevIdx = last.get(ch);
            res = (res - (solve(prevIdx, s, memo, last, MOD) + 1) % MOD + MOD) % MOD;
        }

        last.put(ch, i - 1);
        return memo[i] = (res + MOD) % MOD;
    }
}