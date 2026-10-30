class Solution {
    public boolean hasSpecialSubstring(String s, int k) {
        int stringLength = s.length();
      
        for (int left = 0; left < stringLength;) {
            int right = left + 1;
          
            while (right < stringLength && s.charAt(right) == s.charAt(left)) {
                right++;
            }
          
            if (right - left == k) {
                return true;
            }
          
            left = right;
        }
      
        return false;
    }
}
