import java.util.*;

class Solution {
    public class Pair {
        int node;
        int cost;
        Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
    
    public class Triplet {
        int node;
        int cost;
        int stops;

        Triplet(int node, int cost, int stops) {
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }
    }
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        for(int i=0; i<flights.length; i++){
            int from = flights[i][0], to = flights[i][1], price = flights[i][2];
            adj.get(from).add(new Pair(to, price));
        }

        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[src] = 0;
        
        Queue<Triplet> pq = new LinkedList<>();
        pq.add(new Triplet(src, 0, 0));
        
        while(pq.size() > 0) {
            Triplet top = pq.remove();
            int node = top.node, cost = top.cost, stops = top.stops;
            
            if(stops > k) continue; 
            
            for(Pair p : adj.get(node)) {
                int totalCost = cost + p.cost;
                
                if(totalCost < ans[p.node]) {
                    ans[p.node] = totalCost;
                    pq.add(new Triplet(p.node, totalCost, stops + 1));
                }
            }
        }
        
        if(ans[dst] == Integer.MAX_VALUE) return -1;
        return ans[dst];
    }
}