class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        int[][] litterId = new int[m][n];
        int startX = 0, startY = 0;
        int litterCount = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = classroom[i].charAt(j);

                if (ch == 'S') {
                    startX = i;
                    startY = j;
                } else if (ch == 'L') {
                    litterId[i][j] = litterCount++;
                }
            }
        }

        if (litterCount == 0) return 0;

        int fullMask = (1 << litterCount) - 1;

        boolean[][][][] visited =
            new boolean[m][n][energy + 1][1 << litterCount];

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{startX, startY, energy, fullMask});
        visited[startX][startY][energy][fullMask] = true;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int[] curr = queue.poll();

                int x = curr[0];
                int y = curr[1];
                int currEnergy = curr[2];
                int mask = curr[3];

                if (mask == 0) return moves;

                if (currEnergy == 0) continue;

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                        continue;
                    }

                    if (classroom[nx].charAt(ny) == 'X') {
                        continue;
                    }

                    int nextEnergy = currEnergy - 1;
                    int nextMask = mask;

                    if (classroom[nx].charAt(ny) == 'R') {
                        nextEnergy = energy;
                    }

                    if (classroom[nx].charAt(ny) == 'L') {
                        int id = litterId[nx][ny];
                        nextMask = mask & ~(1 << id);
                    }

                    if (!visited[nx][ny][nextEnergy][nextMask]) {
                        visited[nx][ny][nextEnergy][nextMask] = true;
                        queue.offer(new int[]{
                            nx, ny, nextEnergy, nextMask
                        });
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}