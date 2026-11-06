// 1385. Find the Distance Value Between Two Arrays
import java.util.*;

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);

        int count = 0;

        for (int element : arr1) {
            int searchKey = element - d;
            int index = Arrays.binarySearch(arr2, searchKey);

            if (index < 0) {
                index = -index - 1;
            }
            if (index == arr2.length || arr2[index] > element + d) {
                count++;
            }
        }

        return count;
    }
}
