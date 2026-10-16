//1408. String Matching in an Array
import java.util.*;

class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
      
        int wordCount = words.length;
      
        for (int currentIndex = 0; currentIndex < wordCount; ++currentIndex) {
            for (int compareIndex = 0; compareIndex < wordCount; ++compareIndex) {
                if (currentIndex != compareIndex && words[compareIndex].contains(words[currentIndex])) {
                    result.add(words[currentIndex]);
                    break;
                }
            }
        }
      
        return result;
    }
}
