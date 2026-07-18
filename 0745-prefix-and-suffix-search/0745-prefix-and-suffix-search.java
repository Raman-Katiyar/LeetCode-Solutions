import java.util.HashMap;

class WordFilter {
    private HashMap<String, Integer> map;

    public WordFilter(String[] words) {
        map = new HashMap<>();
        
        for (int index = 0; index < words.length; index++) {
            String word = words[index];
            int n = word.length();
            
            for (int i = 0; i <= n; i++) {
                String prefix = word.substring(0, i);
                
                for (int j = 0; j <= n; j++) {
                    String suffix = word.substring(j, n);
                    String key = suffix + "#" + prefix;
                    map.put(key, index);
                }
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        String query = suffix + "#" + prefix;
        
        return map.getOrDefault(query, -1);
    }
}