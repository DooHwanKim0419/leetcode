package medium.maxAreaOfIsland;

public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, bfs(grid, i, j));
                }
            }
        }

        return maxArea;
    }

    public int bfs(int[][] grid, int i, int j) {
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[i].length - 1 || grid[i][j] == 0) {
            return 0;
        }

        grid[i][j] = 0;
        int area = 1;
        area += bfs(grid, i+1, j);
        area += bfs(grid, i-1, j);
        area += bfs(grid, i, j+1);
        area += bfs(grid, i, j-1);

        return area;
    }
}
