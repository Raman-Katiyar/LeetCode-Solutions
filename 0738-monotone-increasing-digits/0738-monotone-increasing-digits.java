class Solution {
    public int monotoneIncreasingDigits(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        int len = digits.length;
        int startFromNine = len; 
        for (int i = len - 1; i > 0; i--) {
            if (digits[i - 1] > digits[i]) {
                digits[i - 1]--;
                startFromNine = i;
            }
        }
    
        for (int i = startFromNine; i < len; i++) {
            digits[i] = '9';
        }
    
        return Integer.parseInt(new String(digits));
    }
}