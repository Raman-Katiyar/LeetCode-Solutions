class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        
        solve(0, 0, n, current, result);
        return result;
    }

    private void solve(int open, int close, int n, StringBuilder current, List<String> result) {

        if (current.length() == 2 * n) {
            result.add(current.toString());
            return;
        }

        if (open < n) {
            current.append('('); 
            solve(open + 1, close, n, current, result);
            current.deleteCharAt(current.length() - 1); 
        }


        if (close < open) {
            current.append(')');
            solve(open, close + 1, n, current, result);
            current.deleteCharAt(current.length() - 1); 
        }
    }
}