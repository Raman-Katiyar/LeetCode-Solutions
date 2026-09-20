class Solution {
    public int solve(int i, int[] days, int[] costs, int[] dp){
        if(i >= days.length) return 0;

        if(dp[i] != -1) return dp[i];

        int take1 = costs[0] + solve(i+1, days, costs, dp);
        int j = i;
        while(j < days.length && days[j] < days[i]+7){
            j++;
        }
        int take7 = costs[1] + solve(j, days, costs, dp);
        int k = i;
        while(k < days.length && days[k] < days[i]+30){
            k++;
        }
        int take30 = costs[2] + solve(k, days, costs, dp);

        return dp[i] = Math.min(take1, Math.min(take7, take30));
    }
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        Arrays.fill(dp, -1);
        return solve(0, days, costs, dp);
    }
}