class Solution {
    public boolean canFinish(int n, int[][] pre) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=1; i<=n; i++) adj.add(new ArrayList<>());
        int[] indegree = new int[n];
        boolean[] visited = new boolean[n];
        for(int i=0; i<pre.length; i++){
            int a = pre[i][0], b = pre[i][1];
            adj.get(b).add(a);
            indegree[a]++;
        }


        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(indegree[i]==0){
                q.add(i);
                visited[i] = true;
            }    
        }
        while(q.size() > 0){
            int front = q.remove();
            ans.add(front);
            for(int ele : adj.get(front)){
                indegree[ele]--;
                if(indegree[ele]==0){
                    q.add(ele);
                    visited[ele] = true;
                }
            }
        }
        if(ans.size()==n) return true;
        else return false;

    }
}