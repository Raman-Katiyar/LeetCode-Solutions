class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<Integer> present = new HashSet<>();

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            present.add(num);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = min + 1; i < max; i++) {
            if (!present.contains(i)) {
                result.add(i);
            }
        }

        return result;
    }
}