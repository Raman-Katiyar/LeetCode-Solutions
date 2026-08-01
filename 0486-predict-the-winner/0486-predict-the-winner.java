class Solution {
    public boolean predictTheWinner(int[] nums) {
        int result = solve(nums, 0, nums.length - 1);

        return result >= 0;
    }

    public int solve(int[] nums, int left, int right) {

        // Base case
        if (left == right) {
            return nums[left];
        }

        // Take left number
        int takeLeft = nums[left] - solve(nums, left + 1, right);

        // Take right number
        int takeRight = nums[right] - solve(nums, left, right - 1);

        // Current player will choose the better option
        return Math.max(takeLeft, takeRight);
    }
}