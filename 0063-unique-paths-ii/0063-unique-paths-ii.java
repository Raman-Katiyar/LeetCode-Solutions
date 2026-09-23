class Solution {
    public int solve(int r, int c, int m, int n, int[][] grid, int[][] dp){
        if(r >= m || c >= n) return 0;
        if(grid[r][c] == 1) return 0;
        if(r == m-1 && c == n-1) return 1;
        
        if(dp[r][c] != -1) return dp[r][c];

        int t1 = solve(r+1, c, m, n, grid, dp);
        int t2 = solve(r, c+1, m, n, grid, dp);

        return dp[r][c] = t1+t2;
    }
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                dp[i][j] = -1;
            }
        }

        return solve(0, 0, m, n, grid, dp);
    }
}