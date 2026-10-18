// 387. First Unique Character in a String

class Solution {
    public int firstUniqChar(String s) {
        int[] frequencyCount = new int[26];
        int stringLength = s.length();
      
        for (int i = 0; i < stringLength; i++) {
            int charIndex = s.charAt(i) - 'a';
            frequencyCount[charIndex]++;
        }
      
        for (int i = 0; i < stringLength; i++) {
            int charIndex = s.charAt(i) - 'a';
            if (frequencyCount[charIndex] == 1) {
                return i;
            }
        }
      
        return -1;
    }
}
