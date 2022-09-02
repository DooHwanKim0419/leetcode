package easy.uniqueMorseCodeWords;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morseCodes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        Set<String> ans = new HashSet<>();

        for (String word : words) {
            String temp = "";
            for (int i = 0; i < word.length(); i++) {
                char curr = word.charAt(i);
                int index = curr - 'a';
                temp += morseCodes[index];
            }

            ans.add(temp);
        }

        return ans.size();
    }
}