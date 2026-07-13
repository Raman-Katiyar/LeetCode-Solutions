import java.util.*;

class Solution {
    public class Pair {
        String lock;
        int moves;
        Pair(String lock, int moves) {
            this.lock = lock;
            this.moves = moves;
        }
    }
    
    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>();
        for(int i = 0; i < deadends.length; i++) {
            visited.add(deadends[i]);
        }

        if(visited.contains("0000")) {
            return -1;
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair("0000", 0));
        visited.add("0000");

        while(q.size() > 0) {
            Pair current = q.remove();
            String clock = current.lock;
            int cmoves = current.moves;

            if(clock.equals(target)) {
                return cmoves;
            }

            for(int i = 0; i < 4; i++) {
                String clockwise = rotate(clock, i, 1);
                if (!visited.contains(clockwise)) {
                    visited.add(clockwise);
                    q.add(new Pair(clockwise, cmoves + 1));
                }

                String counterClockwise = rotate(clock, i, -1);
                if (!visited.contains(counterClockwise)) {
                    visited.add(counterClockwise);
                    q.add(new Pair(counterClockwise, cmoves + 1));
                }
            }
        }
        return -1;
    }
    
    private String rotate(String s, int index, int direction) {
        char[] ch = s.toCharArray();
        int digit = ch[index] - '0';
        
        digit = (digit + direction + 10) % 10;
        
        ch[index] = (char) (digit + '0');
        return new String(ch);
    }
}