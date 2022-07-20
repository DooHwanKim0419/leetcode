package easy.countTheNumberOfConsistentStrings;

public class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int answer = 0;

        for (String word : words) {
            boolean canAdd = true;

            for (int i = 0; i < word.length(); i++) {
                if (!allowed.contains(Character.toString(word.charAt(i)))) {
                    canAdd = false;
                    break;
                }
            }

            if (canAdd) {
                answer++;
            }
        }

        return answer;
    }
}
