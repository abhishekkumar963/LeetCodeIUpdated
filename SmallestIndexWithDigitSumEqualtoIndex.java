// 3550. Smallest Index With Digit Sum Equal to Index

class Solution {
    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            int digitSum = 0;
            int currentNumber = nums[i];
          
            while (currentNumber != 0) {
                digitSum += currentNumber % 10;
                currentNumber /= 10;
            }
          
            if (digitSum % 10 == i % 10) {
                return i;
            }
        }
        return -1;
    }
}
