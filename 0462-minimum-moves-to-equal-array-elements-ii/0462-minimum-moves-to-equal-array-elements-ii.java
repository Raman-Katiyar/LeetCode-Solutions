import java.util.Arrays;

class Solution {
    public int minMoves2(int[] nums) {
        // Step 1: Array ko sort karein
        Arrays.sort(nums);
        
        int i = 0;
        int j = nums.length - 1;
        int moves = 0;
        
        // Step 2: Opposing pairs ka difference add karein
        while (i < j) {
            moves += nums[j] - nums[i];
            i++;
            j--;
        }
        
        return moves;
    }
}