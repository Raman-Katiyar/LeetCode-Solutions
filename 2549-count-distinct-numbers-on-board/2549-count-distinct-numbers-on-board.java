class Solution {
    public int distinctIntegers(int n) {
        if (n == 1) return 1;

        List<Integer> list = new ArrayList<>();
        list.add(n);
        int cnt = 1;
        int index = 0; 

        while (index < list.size()) {
            int x = list.get(index);
            index++;

            for (int i = 1; i < n; i++) {
                if (x % i == 1) { 
                    if (!list.contains(i)) {
                        cnt++;
                        list.add(i); 
                    }
                }
            }
        }
        return cnt;
    }
}