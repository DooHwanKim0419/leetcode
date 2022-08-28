package medium.maximumTwinSumOfALinkedList;

public class Solution {
    public int pairSum(ListNode head) {
        int n = 0;
        ListNode temp = head;

        while (temp != null) {
            n += 1;
            temp = temp.next;
        }

        int[] sums = new int[n / 2];
        int current = 0;
        int rightHand = (n / 2) - 1;

        while (head != null) {
            if (current < n / 2) {
                sums[current] = head.val;
                current += 1;
            } else {
                sums[rightHand] += head.val;
                rightHand -= 1;
            }

            head = head.next;
        }

        return getMax(sums);
    }

    public int getMax(int[] array) {
        int max = Integer.MIN_VALUE;

        for (int num : array) {
            if (max <= num) {
                max = num;
            }
        }

        return max;
    }
}