// 3727. Maximum Alternating Sum of Squares

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
      
        long[] subtractState = new long[n + 1];
        long[] addState = new long[n + 1];
      
        for (int i = 1; i <= n; i++) {
            subtractState[i] = Math.max(addState[i - 1] - nums[i - 1], subtractState[i - 1]);
            addState[i] = Math.max(subtractState[i - 1] + nums[i - 1], addState[i - 1]);
        }
      
        return Math.max(subtractState[n], addState[n]);
    }
}
