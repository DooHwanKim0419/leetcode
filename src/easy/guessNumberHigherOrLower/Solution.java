package easy.guessNumberHigherOrLower;

/**
 * int guess(num)
 * returns -1 (higher), 0 (equal), 1 (lower)
 */

public class Solution {
    public int guessNumber(int n) {
        int left = 0;
        int right = n;
        int answer = 0;

        while (left <= right) {
            int mid = left + ((right - left) / 2);
            int result = guess(mid);

            if (result == 0) {
                answer = mid;
                break;
            } else if (result == 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }
}
