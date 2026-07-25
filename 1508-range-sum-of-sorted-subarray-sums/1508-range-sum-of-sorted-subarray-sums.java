class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> ls = new ArrayList<>();
        long ans = 0; 
        int mod = 1_000_000_007;

        for(int i=0; i<nums.length; i++){
            ls.add(nums[i]);
            int sum = nums[i];
            for(int j=i+1; j<nums.length; j++){
                sum += nums[j];
                ls.add(sum);
            }
            sum = 0;
        }

        Collections.sort(ls);

        for(int i = left - 1; i < right; i++){
            ans = (ans + ls.get(i)) % mod; 
        }

        return (int) ans;
    }
}