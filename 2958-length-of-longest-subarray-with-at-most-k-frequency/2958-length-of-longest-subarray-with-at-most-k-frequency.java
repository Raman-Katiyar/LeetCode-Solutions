class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            int currentNum = nums[right];
            freq.put(currentNum, freq.getOrDefault(currentNum, 0) + 1);
            while (freq.get(currentNum) > k) {
                freq.put(nums[left], freq.get(nums[left]) - 1);
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}