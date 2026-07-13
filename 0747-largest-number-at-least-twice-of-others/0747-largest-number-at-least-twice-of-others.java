class Solution {
    public int dominantIndex(int[] nums) {
        int fl = -1;
        int sl = -1;

        for(int i=0; i<nums.length; i++){
            if(fl < nums[i]){
                fl = nums[i];
            }
        }

        for(int i=0; i<nums.length; i++){
            if(sl < nums[i] && nums[i] != fl){
                sl = nums[i];
            }
        }

        if((sl*2) <= fl){
            for(int i=0; i<nums.length; i++){
                if(fl == nums[i]){
                    return i;
                }
            }
        }
        return -1;
    }
}