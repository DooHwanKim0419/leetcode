package easy.binarySearch;

public class RecursiveSolution {
    public int search(int[] nums, int target) {
        return recursiveBinarySearch(nums, 0, nums.length - 1, target);
    }
    public int recursiveBinarySearch(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;

        if (nums[mid] == target) {
            return mid;
        } else if (target < nums[mid]) {
            return recursiveBinarySearch(nums, left, mid - 1, target);
        } else {
            return recursiveBinarySearch(nums, mid + 1, right, target);
        }
    }
}
