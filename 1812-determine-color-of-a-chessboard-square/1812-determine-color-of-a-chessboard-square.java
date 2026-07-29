class Solution {
    public boolean squareIsWhite(String st) {
        int n = st.charAt(0);
        int p = st.charAt(1) - 'a' + 1;

        if(n % 2 != 0 && p % 2 != 0){
            return false;
        }

        if(n % 2 != 0 && p % 2 == 0){
            return true;
        }

        if(n % 2 == 0 && p % 2 != 0){
            return true;
        }

        if(n % 2 == 0 && p % 2 == 0){
            return false;
        }

        return false;
    }
}