package easy.longestCommonPrefix;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        String answer = "";
        String first = strs[0];
        String[] allPrefixes = new String[first.length()];

        String temp = "";
        for (int i = 0; i < first.length(); i++) {
            temp += first.charAt(i);
            allPrefixes[i] = temp;
        }

        for (String s : allPrefixes) {
            boolean allContains = true;

            for (String curr : strs) {
                if (!curr.startsWith(s)) {
                    allContains = false;
                    break;
                }
            }

            if (allContains) {
                answer = s;
            }
        }

        return answer;

    }
}