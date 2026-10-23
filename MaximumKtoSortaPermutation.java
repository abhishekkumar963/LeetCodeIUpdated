// 3644. Maximum K to Sort a Permutation

class Solution {
    public int sortPermutation(int[] nums) {
        int result = -1;

        for (int i = 0; i < nums.length; ++i) {
            if (i != nums[i]) {
                result &= nums[i];
            }
        }

        return Math.max(result, 0);
    }
}
