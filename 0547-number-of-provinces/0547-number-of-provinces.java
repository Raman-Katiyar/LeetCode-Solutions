class Solution {
    public int findCircleNum(int[][] isConnected) {
        int cnt = 0;
        int n = isConnected.length;
        boolean[] vis = new boolean[n];

        for(int i=0; i<n; i++){
            if(!vis[i]){
                bfs(i, vis, isConnected);
                cnt++;
            }
        }
        return cnt;
    }

    private void bfs(int i, boolean[] vis, int[][] isConnected){
        int n = isConnected.length;
        vis[i] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(i);

        while(q.size() > 0){
            int top = q.remove();
            for(int j=0; j<n; j++){
                if(isConnected[top][j] == 1 && vis[j] == false){
                    q.add(j);
                    vis[j] = true;
                }
            }
        }
    }
}