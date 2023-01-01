package medium.longestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        int answer = 0;
        Map<Character, Boolean> map = new HashMap<>();

        while (r < s.length()) {
            char c = s.charAt(r);

            if (map.containsKey(c)) {
                map.remove(s.charAt(l));
                l++;
            } else {
                answer = Math.max(answer, r - l + 1);
                r++;
                map.put(c, true);
            }
        }

        return answer;
    }
}