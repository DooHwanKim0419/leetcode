package easy.validAnagram;

import java.util.HashMap;

public class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> left = new HashMap<>();
        HashMap<Character, Integer> right = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character curr = s.charAt(i);

            if (!left.containsKey(curr)) {
                left.put(curr, 0);
            } else {
                left.put(curr, left.get(curr) + 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            Character curr = t.charAt(i);

            if (!right.containsKey(curr)) {
                right.put(curr, 0);
            } else {
                right.put(curr, right.get(curr) + 1);
            }
        }

        for (var entry: left.entrySet()) {
            Character key = entry.getKey();
            int value = entry.getValue();

            if (!right.containsKey(key) || right.get(key) != value) {
                return false;
            }

            if (right.containsKey(key)) {
                right.remove(key);
            }
        }

        return right.size() <= 0;
    }
}
