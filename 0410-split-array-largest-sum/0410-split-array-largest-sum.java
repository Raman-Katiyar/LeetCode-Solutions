class Solution {

    public int splitArray(int[] nums, int k) {

        int low = 0;
        int high = 0;

        // low = max element
        // high = total sum

        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }

        int ans = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // check karo ki mid maximum sum rakhkar
            // kitne subarrays ban rahe hain

            int count = 1;
            int sum = 0;

            for (int num : nums) {

                if (sum + num <= mid) {
                    sum += num;
                } else {
                    count++;
                    sum = num;
                }
            }

            if (count <= k) {
                // possible hai
                ans = mid;
                high = mid - 1;
            } else {
                // possible nahi hai
                low = mid + 1;
            }
        }

        return ans;
    }
}