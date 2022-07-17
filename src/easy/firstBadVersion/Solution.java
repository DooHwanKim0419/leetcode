package easy.firstBadVersion;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int index = 0;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
                index = mid;
            } else {
                left = mid + 1;
                index = mid + 1;
            }
        }

        return index;
    }
}
