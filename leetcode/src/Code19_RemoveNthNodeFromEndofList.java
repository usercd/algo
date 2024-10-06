/**
 * @author CD
 * @since 9/10/2024 8:30 AM
 * package: PACKAGE_NAME
 * class: Code19_RemoveNthNodeFromEndofList
 * Given the head of a linked list,
 * remove the nth node from the end of the list and return its head.
 */
public class Code19_RemoveNthNodeFromEndofList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // 双指针
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 创建一个哑节点(dummy)，它的next指向链表头节点
        // dummy作用是使得即使删除头节点，也能返回正确的链表头节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 初始化两个指针 slow 和 fast，指向哑节点
        ListNode fast = dummy;
        ListNode slow = dummy;

        // 先让 fast 指针向前移动 n+1 步
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // 让 fast 和 slow 指针一起移动，直到 fast 到达链表末尾
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 此时 slow 的下一个节点就是需要删除的节点
        slow.next = slow.next.next;

        // 返回修改后的链表头节点
        return dummy.next;
    }
}
