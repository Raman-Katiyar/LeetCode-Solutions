class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
        int i = series1.length - 1;
        int j = series2.length - 1;

        int val1 = 0, val2 = 0;
        List<List<Integer>> resultList = new ArrayList<>();

        while(i >= 0 || j >= 0){
            int t1 = (i >= 0) ? series1[i][0] : -1;
            int t2 = (j >= 0) ? series2[j][0] : -1;

            int cts;

            if(t1 > t2){
                cts = t1;
                val1 = series1[i][1];
                i--;
            } else if(t2 > t1) {
                cts = t2;
                val2 = series2[j][1];
                j--;
            } else {
                cts = t1;
                val1 = series1[i][1];
                val2 = series2[j][1];
                i--;
                j--;
            }

            resultList.add(Arrays.asList(cts, val1 + val2));
        }
        Collections.reverse(resultList);
        return resultList;
    }
}