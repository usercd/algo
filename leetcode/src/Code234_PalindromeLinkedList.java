/**
 * @author CD
 * @date 10/19/2024
 * @description
 */
public class Code234_PalindromeLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 判断链表是否为回文链表
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true; // 空链表或只有一个节点的链表，直接返回true
        }

        // 1. 使用快慢指针找到链表的中间节点
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. 反转链表的后半部分
        ListNode reversedSecondHalf = reverseList(slow);

        // 3. 比较前半部分和后半部分是否相同
        ListNode firstHalfPointer = head;
        ListNode secondHalfPointer = reversedSecondHalf;
        boolean result = true;
        while (secondHalfPointer != null) {
            if (firstHalfPointer.val != secondHalfPointer.val) {
                result = false;
                break;
            }
            firstHalfPointer = firstHalfPointer.next;
            secondHalfPointer = secondHalfPointer.next;
        }

        // 4. 可选步骤：将反转的链表恢复原状
        // reverseList(reversedSecondHalf);
        return result;
    }

    // 反转链表
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
