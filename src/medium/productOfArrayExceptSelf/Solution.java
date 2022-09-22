package medium.productOfArrayExceptSelf;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixProduct = new int[nums.length];
        int[] postfixProduct = new int[nums.length];

        int start = 1;
        int last = 1;
        int j = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            start *= nums[i];
            prefixProduct[i] = start;
            last *= nums[j];
            postfixProduct[j] = last;

            j--;
        }

        int[] answer = new int[nums.length];

        for (int i = 0; i < prefixProduct.length; i++) {
            if (i == 0) {
                answer[i] = postfixProduct[i + 1];
            } else if (i == prefixProduct.length - 1) {
                answer[i] = prefixProduct[i - 1];
            } else {
                answer[i] = prefixProduct[i - 1] * postfixProduct[i + 1];
            }
        }

        return answer;
    }
}
