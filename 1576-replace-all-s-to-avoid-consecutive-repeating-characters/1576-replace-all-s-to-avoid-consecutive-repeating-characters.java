class Solution {
    public String modifyString(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if (arr[i] == '?') {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    boolean matchesLeft = (i > 0 && arr[i - 1] == ch);
                    boolean matchesRight = (i < n - 1 && arr[i + 1] == ch);
                    if (!matchesLeft && !matchesRight) {
                        arr[i] = ch;
                        break;      
                    }
                }
            }
        }
        return new String(arr); 
    }
}