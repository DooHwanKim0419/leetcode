package easy.detectCapital;

public class Solution {
    public boolean detectCapitalUse(String word) {
        boolean isFirstCapital = false;
        int capitalCount = 0;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (i == 0 && Character.isUpperCase(c)) {
                isFirstCapital = true;
                capitalCount++;
                continue;
            }

            capitalCount += Character.isUpperCase(c) ? 1 : 0;
        }

        return capitalCount == 0 || word.length() == capitalCount || isFirstCapital && capitalCount == 1;
    }
}
