class Solution {
    public int solve(int i, int j, int[][] arr, int[][] dp){
        int m = arr.length;
        int n = arr[0].length;

        if(i >= m || j >= n) return Integer.MAX_VALUE;
        if(i == m-1 && j == n-1) return Math.max(1, 1-arr[i][j]);

        if(dp[i][j] != -1) return dp[i][j];

        int down = solve(i, j+1, arr, dp);
        int right = solve(i+1, j, arr, dp);

        int min = Math.min(down, right);

        return dp[i][j] = Math.max(1, min - arr[i][j]);
    }
    public int calculateMinimumHP(int[][] arr) {
        int[][] dp = new int[arr.length][arr[0].length];
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                dp[i][j] = -1;
            }
        }
        return solve(0, 0, arr, dp);
    }
}