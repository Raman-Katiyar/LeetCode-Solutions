class Solution {
    public boolean solve(int i, int j, String s){
        if(i >= j) return true;

        if(s.charAt(i) == s.charAt(j)){
            return solve(i+1, j-1, s);
        }

        return false;
    }
    public int countSubstrings(String s) {
        int cnt = 0;
        int n = s.length();

        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(solve(i, j, s)) cnt++;
            }
        }
        return cnt;
    }
}