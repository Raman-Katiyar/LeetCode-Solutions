class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int n = temperatures.length;
        int arr[] = new int[n];
        int cnt = 0;

        for(int i=0; i<n; i++){
            while(!st.isEmpty() && temperatures[st.peek()] < temperatures[i]){
                int l = st.pop();
                arr[l] = i-l;
                
            }
            st.push(i);
        }
        return arr;
    }
}