package medium.searchA2DMatrix;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int current = matrix[i][j];

                if (current == target) {
                    return true;
                }

                if (target < current) {
                    return false;
                }
            }
        }

        return false;
    }
}
