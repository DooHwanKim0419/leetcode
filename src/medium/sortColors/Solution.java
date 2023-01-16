package medium.sortColors;

public class Solution {
    public void sortColors(int[] nums) {
        int leftMost = 0;
        int rightMost = nums.length - 1;

        int i = 0;

        while (i <= rightMost) {
            if (nums[i] == 0) {
                nums[i] = nums[leftMost];
                nums[leftMost] = 0;
                leftMost++;
            } else if (nums[i] == 2) {
                nums[i] = nums[rightMost];
                nums[rightMost] = 2;
                rightMost--;
                i--;
            }

            i++;
        }
    }
}