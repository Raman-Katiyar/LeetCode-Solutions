import java.util.ArrayList;
import java.util.List;

class Solution {
    private static final int MOD = 1_000_000_007;
    private long[][] dp;

    public int numOfWays(int[] nums) {
        int n = nums.length;
        dp = new long[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % MOD;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int x : nums) {
            list.add(x);
        }

        return (int) ((solve(list) - 1 + MOD) % MOD);
    }

    private long solve(List<Integer> list) {
        if (list.size() <= 2) {
            return 1;
        }

        int root = list.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 1; i < list.size(); i++) {
            int val = list.get(i);
            if (val < root) {
                left.add(val);
            } else {
                right.add(val);
            }
        }

        long l = solve(left);
        long r = solve(right);
        long c = dp[left.size() + right.size()][left.size()];

        return (((l * r) % MOD) * c) % MOD;
    }
}