/**
 * @author CD
 * @since 7/31/2024 3:44 PM
 * package: hot100
 * class: Code02_AddTwoNumbers
 */

/**
 * You are given two **non-empty** linked lists representing two non-negative integers.
 * The digits are stored in **reverse order**, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.You may assume the two numbers do
 * not contain any leading zero, except the number 0 itself.
 */


public class Code02_AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        int carry = 0;
        int sum;
        while (l1 != null || l2 != null) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            sum = val1 + val2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry != 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }
}
