package medium.searchA2DMatrixII;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int numRows = matrix.length;
        int numColumns = matrix[0].length;

        for (int i = 0; i < numRows; i++) {
            int rightMost = numColumns - 1;
            int[] row = matrix[i];

            while (rightMost >= 0) {
                if (rightMost < 0) {
                    return false;
                }

                int compareTo = row[rightMost];

                if (target > compareTo) {
                    break;
                }

                if (target == compareTo) {
                    return true;
                }

                rightMost--;
            }
        }

        return false;
    }
}
