// Longest Strictly Increasing or Strictly Decreasing Subarray

class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int maxLength = 1;
      
        int currentLength = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                currentLength++;
                maxLength = Math.max(maxLength, currentLength);
            } else {
                currentLength = 1;
            }
        }
      
        currentLength = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                currentLength++;
                maxLength = Math.max(maxLength, currentLength);
            } else {
                currentLength = 1;
            }
        }
        return maxLength;
    }
}
