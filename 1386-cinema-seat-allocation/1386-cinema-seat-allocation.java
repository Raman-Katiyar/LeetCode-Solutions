class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int seatNum = seat[1];

            if (!map.containsKey(row)) {
                map.put(row, new HashSet<>());
            }
            map.get(row).add(seatNum);
        }

        int maxFamilies = 0;

        for (Set<Integer> seats : map.values()) {
            boolean left = !seats.contains(2) && !seats.contains(3) && !seats.contains(4) && !seats.contains(5);
            boolean right = !seats.contains(6) && !seats.contains(7) && !seats.contains(8) && !seats.contains(9);
            boolean middle = !seats.contains(4) && !seats.contains(5) && !seats.contains(6) && !seats.contains(7);

            if (left && right) {
                maxFamilies += 2;
            } else if (left || right || middle) {
                maxFamilies += 1;
            }
        }

        int emptyRows = n - map.size();
        maxFamilies += emptyRows * 2;

        return maxFamilies;
    }
}