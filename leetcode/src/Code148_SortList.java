/**
 * @author CD
 * @date 10/11/2024
 * @description
 */
public class Code148_SortList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // 主函数，归并排序链表
    public ListNode sortList(ListNode head) {
        // 如果链表为空或只有一个节点，直接返回
        if (head == null || head.next == null) {
            return head;
        }

        // 找到链表中点，拆分为两部分
        ListNode mid = getMiddle(head);
        ListNode rightHead = mid.next;
        mid.next = null; // 将链表断开

        // 递归排序左右两部分
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        // 合并排序后的左右两部分
        return merge(left, right);
    }

    // 快慢指针法找链表的中点
    private ListNode getMiddle(ListNode head) {
        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head.next;

        // 快慢指针找到中点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // 合并两个有序链表
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // 合并两个有序链表
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // 如果有剩余节点，直接接上
        if (l1 != null) {
            current.next = l1;
        } else if (l2 != null) {
            current.next = l2;
        }

        return dummy.next;
    }

    // 打印链表（用于调试）
    public void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }
}
