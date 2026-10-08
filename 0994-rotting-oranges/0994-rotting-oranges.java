import java.util.*;

class Solution {
    public int bfs(Queue<int[]> q, int[][] grid, int m, int n, int fresh) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int time = 0;

        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int[] top = q.remove();
                int r = top[0];
                int c = top[1];

                for (int[] d : dirs) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        q.add(new int[]{nr, nc});
                        fresh--;
                    }
                }
            }
            time++;
        }

        return fresh == 0 ? time : -1;
    }

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        return bfs(q, grid, m, n, fresh);
    }
}