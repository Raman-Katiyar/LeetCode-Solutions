class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int sum = 0;

        for(int i=0; i<nums.size(); i++){
            Set<Integer> hs = new HashSet<>();

            for(int j=i; j<n; j++){
                hs.add(nums.get(j));
                int cnt = hs.size();
                sum += cnt * cnt;
            }
        }
        return sum;
    }
}