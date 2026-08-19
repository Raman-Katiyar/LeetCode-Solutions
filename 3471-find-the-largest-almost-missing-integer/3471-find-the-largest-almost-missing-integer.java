class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        
        Map<Integer, Integer> subarrayCount = new HashMap<>();
        for (int i = 0; i <= n - k; i++) {
            Set<Integer> uniqueInSubarray = new HashSet<>();
            
            for (int j = i; j < i + k; j++) {
                uniqueInSubarray.add(nums[j]);
            }

            for (int num : uniqueInSubarray) {
                subarrayCount.put(num, subarrayCount.getOrDefault(num, 0) + 1);
            }
        }
        int maxVal = -1;

        for (Map.Entry<Integer, Integer> entry : subarrayCount.entrySet()) {
            int element = entry.getKey();
            int count = entry.getValue();
            if (count == 1) {
                maxVal = Math.max(maxVal, element);
            }
        }
        return maxVal;
    }
}