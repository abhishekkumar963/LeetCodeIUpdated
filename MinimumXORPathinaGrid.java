// 3882. Minimum XOR Path in a Grid

class Solution {
    public int minimumXORSum(int[] nums1, int[] nums2) {
        int n = nums1.length;
      
        int[][] dp = new int[n + 1][1 << n];
      
        for (int[] row : dp) {
            Arrays.fill(row, 1 << 30);
        }
      
        dp[0][0] = 0;
      
        for (int i = 1; i <= n; i++) {
            for (int mask = 0; mask < (1 << n); mask++) {
                for (int j = 0; j < n; j++) {
                    if ((mask >> j & 1) == 1) {
                        int previousMask = mask ^ (1 << j);
                        int xorValue = nums1[i - 1] ^ nums2[j];
                        dp[i][mask] = Math.min(dp[i][mask], 
                                              dp[i - 1][previousMask] + xorValue);
                    }
                }
            }
        }
      
        return dp[n][(1 << n) - 1];
    }
}
