public class Solution {
    public int solve(int left, int right, int[] arr, int[][] dp) {
        if (left == right) return 0;

        if(dp[left][right] != -1) return dp[left][right];

        int maxScore = 0;
        int sum = 0;

        int tsum = 0;
        for (int i = left; i <= right; i++) {
            tsum += arr[i];
        }
        for (int i = left; i < right; i++) {
            sum += arr[i];
            int rightSum = tsum - sum;
            int currentScore = 0;
            if (sum < rightSum) {
                currentScore = sum + solve(left, i, arr, dp);
            } else if (rightSum < sum) {
                currentScore = rightSum + solve(i + 1, right, arr, dp);
            } else {
                currentScore = sum + Math.max(solve(left, i, arr, dp), solve(i + 1, right, arr, dp));
            }
            maxScore = Math.max(maxScore, currentScore);
        }
        return dp[left][right] = maxScore;
    }
    public int stoneGameV(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++){
                dp[i][j] = -1;
            }
        }
        return solve(0, arr.length - 1, arr, dp);
    }
}