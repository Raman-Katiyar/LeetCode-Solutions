class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] freq = new int[k];
        for (int num : arr) {
            int rem = ((num % k) + k) % k;
            freq[rem]++;
        }
    
        for (int r = 0; r < k; r++) {
            if (r == 0) {
                if (freq[0] % 2 != 0) {
                    return false;
                }
            } 
            else if (2 * r == k) {
                if (freq[r] % 2 != 0) {
                    return false;
                }
            } 
            else {
                if (freq[r] != freq[k - r]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}