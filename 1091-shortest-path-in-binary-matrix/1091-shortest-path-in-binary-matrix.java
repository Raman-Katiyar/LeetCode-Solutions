class Solution {
    class Pair {
        int row;
        int col;
        int dist;
        
        Pair(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        
        boolean[][] vis = new boolean[n][n];
        
        return bfs(grid, vis, n);
    }
    
    private int bfs(int[][] grid, boolean[][] vis, int n) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0, 1));
        vis[0][0] = true;
        
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int r = curr.row;
            int c = curr.col;
            int d = curr.dist;
            
            if (r == n - 1 && c == n - 1) {
                return d;
            }
            
            for (int[] dir : dirs) {
                int newRow = r + dir[0];
                int newCol = c + dir[1];
                
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n 
                    && grid[newRow][newCol] == 0 && !vis[newRow][newCol]) {
                    
                    q.add(new Pair(newRow, newCol, d + 1));
                    vis[newRow][newCol] = true; 
                }
            }
        }
        
        return -1;
    }
}