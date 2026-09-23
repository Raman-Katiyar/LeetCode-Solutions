class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                dp[i][j] = -1;
            }
        }
        return helper(grid, 0, 0, dp);
    }

    private int helper(int[][] grid, int r, int c, int[][] dp) {
        int m = grid.length;
        int n = grid[0].length;

        if (r == m - 1 && c == n - 1) {
            return grid[r][c];
        }

        if (r >= m || c >= n) {
            return Integer.MAX_VALUE;
        }

        if(dp[r][c] != -1) return dp[r][c];

        int down = helper(grid, r + 1, c, dp);
        int right = helper(grid, r, c + 1, dp);

        return dp[r][c] = grid[r][c] + Math.min(down, right);
    }
}