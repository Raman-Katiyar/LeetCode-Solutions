class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int cnt = 0;

        boolean[][] vis = new boolean[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!vis[i][j] && grid[i][j] == '1'){
                    bfs(vis, grid, i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private void bfs(boolean[][] vis, char[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j));
        vis[i][j] = true;

        while(q.size() > 0){
            Pair front = q.remove();
            int row = front.row, col = front.col;

            if(row>0){
                if(vis[row-1][col]==false && grid[row-1][col]=='1'){
                    q.add(new Pair(row-1,col));
                    vis[row-1][col] = true;
                }
            }

            if(row+1<m){
                if(vis[row+1][col]==false && grid[row+1][col]=='1'){
                    q.add(new Pair(row+1,col));
                    vis[row+1][col] = true;
                }
            }

            if(col>0){
                if(vis[row][col-1]==false && grid[row][col-1]=='1'){
                    q.add(new Pair(row,col-1));
                    vis[row][col-1] = true;
                }
            }

            if(col+1<n){
                if(vis[row][col+1]==false && grid[row][col+1]=='1'){
                    q.add(new Pair(row,col+1));
                    vis[row][col+1] = true;
                }
            }


        }
    }
}