package medium.allPathsFromSourceToTarget;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < graph.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < graph[i].length; j++) {
                list.add(graph[i][j]);
            }

            map.put(i, list);
        }

        int target = graph.length-1;

        for (int n : map.get(0)) {
            List<Integer> temp = new ArrayList<>();
            temp.add(0);
            temp.add(n);
            dfs(map, temp, target, n);
        }

        return answer;
    }

    public void dfs(Map<Integer, List<Integer>> map, List<Integer> temp, int target, int key) {
        if (key == target) {
            answer.add(new ArrayList<>(temp));
            return;
        }

        for (int n : map.get(key)) {
            temp.add(n);
            dfs(map, temp, target, n);
            temp.remove(temp.size() - 1);
        }
    }
}