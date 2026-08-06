class Solution {
    public int smallestNumber(int n, int t) {
        int sum = 1;
        for(int i=n; i<n+100; i++){
            sum = 1;
            int temp = i;
            while(temp > 0){
                int k = temp % 10;
                sum *= k;
                temp /= 10;
            }

            if(sum % t == 0){
                return i;
            } 
        }
        return -1;
    }
}