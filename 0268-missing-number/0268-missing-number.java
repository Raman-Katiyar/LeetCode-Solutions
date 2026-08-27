class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            hs.add(nums[i]);
        }
        int n = nums.length-1;

        for(int i=0; i<=n; i++){
            if(!hs.contains(i)) return i;
        }
        return n+1;
    }
}