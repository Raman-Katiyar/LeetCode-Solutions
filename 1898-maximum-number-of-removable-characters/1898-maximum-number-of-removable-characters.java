class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        int low = 0;
        int high = removable.length;
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(s, p, removable, mid)) {
                ans = mid;    
                low = mid + 1;   
            } else {
                high = mid - 1;  
            }
        }

        return ans;
    }
    private boolean isPossible(String s, String p, int[] removable, int k) {
        boolean[] removed = new boolean[s.length()];
        for (int i = 0; i < k; i++) {
            removed[removable[i]] = true;
        }

        int i = 0; 
        int j = 0; 

        while (i < s.length() && j < p.length()) {
            if (!removed[i] && s.charAt(i) == p.charAt(j)) {
                j++; 
            }
            i++; 
        }
        return j == p.length();
    }
}