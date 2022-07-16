package easy.countCommonWordsWithOneOccurrence;

import java.util.HashMap;

public class Solution {
    public int countWords(String[] words1, String[] words2) {
        HashMap<String, Integer> base = new HashMap<>();
        HashMap<String, Integer> compare = new HashMap<>();

        for (String word : words1) {
            if (!base.containsKey(word)) {
                base.put(word, 1);
            } else {
                base.put(word, base.get(word) + 1);
            }
        }

        for (String word : words2) {
            if (!compare.containsKey(word)) {
                compare.put(word, 1);
            } else {
                compare.put(word, compare.get(word) + 1);
            }
        }

        int answer = 0;

        var entrySet = base.size() > compare.size() ? base.entrySet() : compare.entrySet();
        var compareTo = base.size() > compare.size() ? compare : base;

        for (var entry : entrySet) {
            String key = entry.getKey();
            int value = entry.getValue();

            if (value == 1 && compareTo.get(key) != null && compareTo.get(key) == 1) {
                answer++;
            }
        }

        return answer;
    }
}
