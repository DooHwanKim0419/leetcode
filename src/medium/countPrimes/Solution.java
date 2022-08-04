package medium.countPrimes;

public class Solution {
    public int countPrimes(int n) {
        int answer = 0;
        boolean[] isPrime = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (i <= 1) {
                isPrime[i] = false;
            } else {
                isPrime[i] = true;
            }
        }

        for (int i = 2; i * i < n; i++) {
            if (!isPrime[i]) {
                continue;
            }

            for (int j = i * i; j < n; j = j + i) {
                isPrime[j] = false;
            }
        }

        for (int i = 0; i < isPrime.length; i++) {
            if (isPrime[i]) {
                answer += 1;
            }
        }

        return answer;
    }
}
