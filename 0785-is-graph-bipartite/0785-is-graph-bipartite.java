class Solution {
    static boolean ans;

    public void dfs(int i, int[][] adj, int[] visited) {
        if (!ans) return;

        if (visited[i] == -1) {
            visited[i] = 0;
        }

        for (int neighbor : adj[i]) {
            if (visited[neighbor] == -1) {
                visited[neighbor] = 1 - visited[i];
                dfs(neighbor, adj, visited);
            } else if (visited[neighbor] == visited[i]) {
                ans = false;
                return;
            }
        }
    }

    public boolean isBipartite(int[][] adj) {
        ans = true;
        int n = adj.length;
        int[] visited = new int[n];
        Arrays.fill(visited, -1);

        for (int i = 0; i < n; i++) {
            if (!ans) return ans;
            if (visited[i] == -1) {
                dfs(i, adj, visited);
            }
        }
        return ans;
    }
}