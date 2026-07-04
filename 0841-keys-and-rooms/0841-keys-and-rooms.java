class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] vis = new boolean[n];
        vis[0] = true;
        bfs(0, rooms, vis);

        for(boolean ele:vis){
            if(ele == false) return false;
        }
        return true;
        
    }

    private void bfs(int i, List<List<Integer>> rooms, boolean[] vis){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);

        while(q.size() > 0){
            int front = q.remove();
            for(int ele : rooms.get(front)){
                if(!vis[ele]){
                    vis[ele] = true;
                    q.add(ele);
                }
            }
        }
    }
}