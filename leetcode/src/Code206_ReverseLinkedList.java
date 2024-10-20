/**
 * @author CD
 * @date 10/16/2024
 * @description
 */
public class Code206_ReverseLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    // 递归法反转链表
    public ListNode reverseList2(ListNode head) {
        // 基本情况：当链表为空或只有一个节点时，直接返回
        if (head == null || head.next == null) {
            return head;
        }

        // 递归反转后续链表
        ListNode reversedList = reverseList2(head.next);

        // 反转当前节点和下一个节点的指针关系
        head.next.next = head;  // 将head的下一个节点指向head
        head.next = null;       // 将head的next置为空

        // 返回反转后的链表头节点
        return reversedList;
    }

}
