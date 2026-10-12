import java.util.*;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>();
        for (String word : banned) {
            bannedSet.add(word);
        }

        String[] words = paragraph.toLowerCase().split("[^a-z]+");
        Map<String, Integer> counts = new HashMap<>();
        
        String result = "";
        int maxCount = 0;

        for (String word : words) {
            if (word.isEmpty() || bannedSet.contains(word)) {
                continue;
            }
            int currentCount = counts.getOrDefault(word, 0) + 1;
            counts.put(word, currentCount);
            
            if (currentCount > maxCount) {
                maxCount = currentCount;
                result = word;
            }
        }

        return result;
    }
}
