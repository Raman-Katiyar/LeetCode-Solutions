import java.util.Arrays;

class Solution {
    static class Job {
        int start;
        int end;
        int profit;

        Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] jobs = new Job[n];

        Integer[] dp = new Integer[n];

        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }

        Arrays.sort(jobs, (a, b) -> Integer.compare(a.start, b.start));

        return solve(jobs, 0, n, dp);
    }

    private int solve(Job[] jobs, int i, int n, Integer[] dp) {
        if (i >= n) {
            return 0;
        }

        if (dp[i] != null) return dp[i];

        int skip = solve(jobs, i + 1, n, dp);

        int nextIndex = findNextJob(jobs, i + 1, n, jobs[i].end);
        int take = jobs[i].profit + solve(jobs, nextIndex, n, dp);

        return dp[i] = Math.max(skip, take);
    }

    private int findNextJob(Job[] jobs, int low, int high, int currentEndTime) {
        int result = high;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (jobs[mid].start >= currentEndTime) {
                result = mid;
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }
}