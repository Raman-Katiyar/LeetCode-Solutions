import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        
        for (int i = left; i <= right; i++) {
            if (isSelfDividing(i)) {
                list.add(i);
            }
        }
        
        return list;
    }
    
    private boolean isSelfDividing(int num) {
        int temp = num;
        
        while (temp > 0) {
            int digit = temp % 10;
            
            if (digit == 0 || num % digit != 0) {
                return false;
            }
            
            temp /= 10; 
        }    
        return true; 
    }
}