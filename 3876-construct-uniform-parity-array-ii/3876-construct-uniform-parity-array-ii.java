class Solution {
    public boolean uniformArray(int[] nums1) {
        int min = Integer.MAX_VALUE;
        boolean hasOdd = false;

        for (int x : nums1) {
            if (x < min) {
                min = x;
            }
            if (x % 2 != 0) {
                hasOdd = true;
            }
        }

        if (!hasOdd) return true;
        return min % 2 != 0;
    }
}