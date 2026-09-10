import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        
        for (String word : words) {
            if (matches(word, pattern)) {
                result.add(word);
            }
        }
        
        return result;
    }
    
    private boolean matches(String word, String pattern) {
        if (word.length() != pattern.length()) {
            return false;
        }
        
        // Use arrays to store the last seen position of each character.
        // We use 256 to cover all ASCII characters, though 26 would suffice for lowercase English letters.
        int[] wordMap = new int[256];
        int[] patternMap = new int[256];
        
        for (int i = 0; i < word.length(); i++) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);
            
            // If the last seen positions of the characters do not match, the pattern is broken
            if (wordMap[w] != patternMap[p]) {
                return false;
            }
            
            // Store the position (i + 1 to distinguish from default 0 value)
            wordMap[w] = i + 1;
            patternMap[p] = i + 1;
        }
        
        return true;
    }
}