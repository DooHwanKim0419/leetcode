package medium.wallsAndGates;

import util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public void wallsAndGates(int[][] rooms) {
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        int INF = 2147483647;

        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == 0) {
                    q.offer(new Pair<>(i, j));
                }
            }
        }

        int distance = 1;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Pair<Integer, Integer> curr = q.poll();
                int x = curr.getKey();
                int y = curr.getValue();

                if (x + 1 < rooms.length && rooms[x+1][y] == INF) {
                    rooms[x+1][y] = distance;
                    q.offer(new Pair<>(x+1, y));
                }

                if (x - 1 >= 0 && rooms[x-1][y] == INF) {
                    rooms[x-1][y] = distance;
                    q.offer(new Pair<>(x-1, y));
                }

                if (y + 1 < rooms[x].length && rooms[x][y+1] == INF) {
                    rooms[x][y+1] = distance;
                    q.offer(new Pair<>(x, y+1));
                }

                if (y - 1 >= 0 && rooms[x][y-1] == INF) {
                    rooms[x][y-1] = distance;
                    q.offer(new Pair<>(x, y-1));
                }
            }
            distance++;
        }
    }
}
