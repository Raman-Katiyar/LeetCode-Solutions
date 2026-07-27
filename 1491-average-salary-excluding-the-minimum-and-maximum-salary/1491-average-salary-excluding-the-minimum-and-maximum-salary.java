class Solution {
    public double average(int[] salary) {
        int h = 0;
        int lh = Integer.MAX_VALUE;

        for(int i = 0; i < salary.length; i++){
            if(h < salary[i]){
                h = salary[i];
            }
        }
        for(int i = 0; i < salary.length; i++){
            if(salary[i] < lh){
                lh = salary[i];
            }
        }
        int sum = 0;
        for(int i = 0; i < salary.length; i++){
            if(salary[i] != h && salary[i] != lh){
                sum += salary[i];
            }
        }
        return (double) sum / (salary.length - 2);
    }
}