package medium.mergeNodesInBetweenZeros;

public class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode temp = new ListNode();
        ListNode answer = temp;
        int sum = 0;
        while (head != null) {
            if (head.val != 0) {
                sum += head.val;
            } else {
                if (sum != 0) {
                    answer.next = new ListNode(sum);
                    answer = answer.next;
                }
                sum = 0;
            }
            head = head.next;
        }

        return temp.next;
    }
}
