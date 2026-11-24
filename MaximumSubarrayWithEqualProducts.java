// 3411. Maximum Subarray With Equal Products

class Solution {
    public int maxLength(int[] nums) {
        int maxElement = 0;
        int overallLcm = 1;
      
        for (int num : nums) {
            maxElement = Math.max(maxElement, num);
            overallLcm = lcm(overallLcm, num);
        }
      
        int maxProduct = overallLcm * maxElement;
      
        int n = nums.length;
        int maxLength = 0;
      
        for (int i = 0; i < n; ++i) {
            int product = 1;
            int currentGcd = 0;
            int currentLcm = 1;
          
            for (int j = i; j < n; ++j) {
                product *= nums[j];
                currentGcd = gcd(currentGcd, nums[j]);
                currentLcm = lcm(currentLcm, nums[j]);
              
                if (product == currentGcd * currentLcm) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
                if (product > maxProduct) {
                    break;
                }
            }
        }
      
        return maxLength;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    private int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }
}
