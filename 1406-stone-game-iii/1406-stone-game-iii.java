class Solution {
    private int solve(int[] arr, int i,  int[] dp) {
        if (i >= arr.length) return 0;
        if(dp[i] != Integer.MIN_VALUE) return dp[i];
        int f = arr[i] - solve(arr, i + 1, dp);

        int s = Integer.MIN_VALUE;
        if (i + 1 < arr.length) {
            s = (arr[i] + arr[i + 1]) - solve(arr, i + 2, dp);
        }

        int t = Integer.MIN_VALUE;
        if (i + 2 < arr.length) {
            t = (arr[i] + arr[i + 1] + arr[i + 2]) - solve(arr, i + 3, dp);
        }

        return dp[i] = Math.max(f, Math.max(s, t));
    }

    public String stoneGameIII(int[] arr) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, Integer.MIN_VALUE);
        int result = solve(arr, 0, dp);

        if (result > 0) return "Alice";
        if (result < 0) return "Bob";
        return "Tie";
    }
}