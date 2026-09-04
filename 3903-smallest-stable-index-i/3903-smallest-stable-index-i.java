class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<=i; j++){
                if(max < nums[j]){
                    max = nums[j];
                }
            }

            for(int q=i; q<nums.length; q++){
                if(min > nums[q]){
                    min = nums[q];
                }
            }

            if(max - min <= k){
                return i;
            }
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
        }
        return -1;
    }
}