package medium.containerWithMostWater;

public class Solution {
    public int maxArea(int[] height) {
        int j = height.length - 1;
        int i = 0;
        int max = 0;

        while (i < j) {
            int left = height[i];
            int right = height[j];
            int h = left > right ? right : left;
            int x = j - i;
            max = Math.max(max, h * x);

            if (left > right) {
                j--;
            } else {
                i++;
            }
        }

        return max;
    }
}
