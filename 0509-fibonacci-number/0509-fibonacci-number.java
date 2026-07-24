class Solution {
    public int fibo(int[] dp, int n){
        if(n<=1) return n;
        if(dp[n] != 0) return dp[n];
        return dp[n] = fibo(dp, n-1) + fibo(dp, n-2);
    }
    public int fib(int n) {
        int[] dp = new int[n+1];
        return fibo(dp, n);
    }
}