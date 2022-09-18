package medium.coinChange;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        int rows = coins.length + 1;
        int columns = amount + 1;
        int[][] changes = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i == 0) {
                    changes[i][j] = Integer.MAX_VALUE - 1;
                } else if (j == 0) {
                    continue;
                } else if (coins[i - 1] == j) {
                    changes[i][j] = 1;
                } else if (coins[i - 1] < j) {
                    changes[i][j] = Math.min(changes[i - 1][j], changes[i][j - coins[i - 1]] + 1);
                } else {
                    changes[i][j] = changes[i - 1][j];
                }
            }
        }

        int possibleAnswer = changes[rows - 1][columns - 1];
        return possibleAnswer == Integer.MAX_VALUE - 1 ? -1 : possibleAnswer;
    }
}
