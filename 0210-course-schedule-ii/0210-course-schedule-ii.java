class Solution {
    public int[] findOrder(int n, int[][] pre) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] incom = new int[n];
        List<Integer> ans = new ArrayList<>();
        for(int i=1; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<pre.length; i++){
            int a = pre[i][0], b = pre[i][1];
            adj.get(b).add(a);
            incom[a]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(incom[i]==0){
                q.add(i);
            }
        }

        while(q.size() > 0){
            int front = q.remove();
            ans.add(front);
            for(int ele : adj.get(front)){
                incom[ele]--;
                if(incom[ele]==0) q.add(ele);
            }
        }

        int[] ans2 = new int[ans.size()];
        for(int i=0; i<ans.size(); i++){
            ans2[i] = ans.get(i);
        }

        if(ans.size() != n) return new int[0];
        return ans2;
    }
}