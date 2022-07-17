package medium.removeAllOccurrencesOfASubstring;

public class Solution {
    public String removeOccurrences(String s, String part) {
        int partLength = part.length();

        for (int i = 0; i < s.length() - partLength + 1; i++) {
            String tempPart = s.substring(i, i + partLength);

            if (tempPart.equals(part)) {
                s = s.substring(0, i) + s.substring(i + partLength);
                i = -1;
            }
        }

        return s;
    }
}
