class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;

        int zeroIdx = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zeroIdx = i;
                break;
            }
        }

        boolean isAscendingCyclic = true;
        for (int i = 0; i < n; i++) {
            if (nums[(zeroIdx + i) % n] != i) {
                isAscendingCyclic = false;
                break;
            }
        }

        boolean isDescendingCyclic = true;
        for (int i = 0; i < n; i++) {
            if (nums[(zeroIdx - i + n) % n] != i) {
                isDescendingCyclic = false;
                break;
            }
        }

        if (!isAscendingCyclic && !isDescendingCyclic) {
            return -1;
        }

        int ans = Integer.MAX_VALUE;

        if (isAscendingCyclic) {
            ans = Math.min(ans, zeroIdx);
            if (zeroIdx > 0) {
                ans = Math.min(ans, (n - zeroIdx) + 2);
            }
        }

        if (isDescendingCyclic) {
            int option1 = ((zeroIdx + 1) % n) + 1;
            int option2 = 1 + (n - 1 - zeroIdx);
            ans = Math.min(ans, Math.min(option1, option2));
        }

        return ans;
    }
}