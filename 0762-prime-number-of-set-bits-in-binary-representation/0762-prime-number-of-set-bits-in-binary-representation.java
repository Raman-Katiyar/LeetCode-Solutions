class Solution {
    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        
        for (int i = left; i <= right; i++) {
            int setBits = Integer.bitCount(i);
            
            if (isPrime(setBits)) {
                ans++;
            }
        }
        
        return ans;
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }
}