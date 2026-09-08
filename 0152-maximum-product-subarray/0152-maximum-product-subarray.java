import java.util.Arrays;

class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        long[] dpMax = new long[nums.length];
        long[] dpMin = new long[nums.length];
        Arrays.fill(dpMax, Long.MIN_VALUE);
        Arrays.fill(dpMin, Long.MIN_VALUE);
        
        int globalMax = nums[0];
        for (int i = 0; i < nums.length; i++) {
            globalMax = Math.max(globalMax, helperMax(nums, i, dpMax, dpMin));
        }
        return globalMax;
    }

    private int helperMax(int[] nums, int i, long[] dpMax, long[] dpMin) {
        if (i == 0) {
            return nums[0];
        }

        if (dpMax[i] != Long.MIN_VALUE) return (int) dpMax[i];
        
        int prevMax = helperMax(nums, i - 1, dpMax, dpMin);
        int prevMin = helperMin(nums, i - 1, dpMax, dpMin);
        int cur = nums[i];
        
        long res = Math.max(cur, Math.max((long)cur * prevMax, (long)cur * prevMin));
        dpMax[i] = res;
        return (int) res;
    }

    private int helperMin(int[] nums, int i, long[] dpMax, long[] dpMin) {
        if (i == 0) {
            return nums[0];
        }

        if (dpMin[i] != Long.MIN_VALUE) return (int) dpMin[i];
        
        int prevMax = helperMax(nums, i - 1, dpMax, dpMin);
        int prevMin = helperMin(nums, i - 1, dpMax, dpMin);
        int cur = nums[i];
        
        long res = Math.min(cur, Math.min((long)cur * prevMax, (long)cur * prevMin));
        dpMin[i] = res;
        return (int) res;
    }
}