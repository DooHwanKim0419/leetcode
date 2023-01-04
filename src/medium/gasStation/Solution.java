package medium.gasStation;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0;
        int costSum = 0;

        for (int i = 0; i < gas.length; i++) {
            gasSum += gas[i];
            costSum += cost[i];
        }

        if (gasSum < costSum) {
            return -1;
        }

        int idx = 0;
        gasSum = 0;
        for (int i = 0; i < gas.length; i++) {
            gasSum += gas[i];
            gasSum -= cost[i];

            if (gasSum < 0) {
                idx = i + 1;
                gasSum = 0;
            }
        }

        return idx;
    }
}
