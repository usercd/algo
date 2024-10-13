/**
 * @author CD
 * @date 10/10/2024
 * @description
 */

public class Code142_LinkedListCycleII {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null; // 空链表或只有一个节点的链表不可能有环
        }

        // 初始化快指针和慢指针
        ListNode slow = head;
        ListNode fast = head;

        // 寻找是否存在环
        while (fast != null && fast.next != null) {
            slow = slow.next;  // 慢指针走一步
            fast = fast.next.next;  // 快指针走两步

            if (slow == fast) {  // 快慢指针相遇，说明有环
                // 将 slow 指针重置到链表头部
                slow = head;

                // slow 和 fast 每次走一步，相遇点即为环的入口
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;  // 返回环的起始节点
            }
        }

        return null;  // 如果没有环，返回 null
    }
}
