class Solution {
    public long countCommas(long n) {
        long ans = 0;

        for (long start = 1000, commas = 1;
            start <= n;
            start *= 1000, commas++) {

            long end = Math.min(n, start * 1000 - 1);

            long count = end - start + 1;

            ans += count * commas;
        }
        return ans;
    }
}