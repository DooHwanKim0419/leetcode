package medium.rottingOranges;

import util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair<Integer, Integer>> pos = new LinkedList<>();
        int freshCount = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    freshCount++;
                    continue;
                }

                if (grid[i][j] == 2) {
                    pos.offer(new Pair<>(i, j));
                }
            }
        }

        if (pos.size() == 0 && freshCount == 0) {
            return 0;
        }

        int minutes = 0;
        while (!pos.isEmpty()) {
            int size = pos.size();

            for (int i = 0; i < size; i++) {
                Pair<Integer, Integer> curr = pos.poll();
                int x = curr.getKey();
                int y = curr.getValue();

                if (x + 1 < grid.length && grid[x+1][y] == 1) {
                    grid[x+1][y] = 2;
                    pos.offer(new Pair<>(x+1, y));
                    freshCount--;
                }

                if (x - 1 >= 0 && grid[x-1][y] == 1) {
                    grid[x-1][y] = 2;
                    pos.offer(new Pair<>(x-1, y));
                    freshCount--;
                }

                if (y + 1 < grid[0].length && grid[x][y+1] == 1) {
                    grid[x][y+1] = 2;
                    pos.offer(new Pair<>(x, y+1));
                    freshCount--;
                }

                if (y - 1 >= 0 && grid[x][y-1] == 1) {
                    grid[x][y-1] = 2;
                    pos.offer(new Pair<>(x, y-1));
                    freshCount--;
                }
            }
            minutes++;
        }

        return freshCount > 0 ? -1 : minutes - 1;
    }
}
