class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> n = new HashSet<>();

        for(int i=0; i<nums.length; i++){
            n.add(nums[i]);
        }

        for(int i=k; i<Integer.MAX_VALUE; i+=k){
            if(!n.contains(i)) return i;
        }
        return -1;
    }
}