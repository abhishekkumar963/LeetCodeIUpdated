// 213. House Robber II

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
      
        if (n == 1) {
            return nums[0];
        }
      
        return Math.max(
            rob(nums, 0, n - 2),
            rob(nums, 1, n - 1) 
        );
    }
    private int rob(int[] nums, int start, int end) {
        int prevNotRobbed = 0;
      
        int prevRobbed = 0;
      
        for (int i = start; i <= end; i++) {
            int currentNotRobbed = Math.max(prevNotRobbed, prevRobbed);
          
            int currentRobbed = prevNotRobbed + nums[i];
            prevNotRobbed = currentNotRobbed;
            prevRobbed = currentRobbed;
        }
      
        return Math.max(prevNotRobbed, prevRobbed);
    }
}
