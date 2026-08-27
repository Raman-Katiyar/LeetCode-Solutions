class Solution {
    public void moveZeroes(int[] nums) {
        int nonzeroind = 0;
        for(int i=0; i<nums.length; i++){
          if(nums[i]!=0){
            nums[nonzeroind]=nums[i];
            nonzeroind++;
    
          }  
        }
        while(nonzeroind < nums.length){
        nums[nonzeroind]=0;
        nonzeroind++;
    }
    
    }
}