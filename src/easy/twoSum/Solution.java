package easy.twoSum;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        boolean terminate = false;

        for (int i = 0; i < nums.length; i++) {
            int left = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int right = nums[j];

                if (left + right == target) {
                    answer[0] = i;
                    answer[1] = j;
                    terminate = true;
                    break;
                }
            }

            if (terminate) {
                break;
            }
        }

        return answer;
    }
}
