/**
 * @author CD
 * @since 2023/2/5 19:16
 * package: PACKAGE_NAME
 * class: Code23_MergeKSortedLists
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 * Example 1:
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 */

import java.util.PriorityQueue;

public class Code23_MergeKSortedLists {

    // 单链表
    public static class ListNode {
        public int val;
        public ListNode next;

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

    // 方法一：分治法
    // 主函数，使用分治法合并 k 个排序链表
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    // 分治递归函数，合并 lists[left...right] 范围内的链表
    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left]; // 递归终止条件：只有一个链表
        }
        int mid = left + (right - left) / 2;
        // 分别合并左右两部分
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        // 合并两部分
        return mergeTwoLists(l1, l2);
    }

    // 合并两个排序链表
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // 哑节点，简化操作
        ListNode current = dummy;

        // 双指针遍历两个链表并合并
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

        // 如果 l1 或 l2 中有剩余节点，直接连接
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }

        return dummy.next; // 返回合并后的链表
    }

    // 方法二：小根堆
    public ListNode mergeKLists2(ListNode[] lists) {
        // 使用优先队列来管理 k 个链表的最小节点
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // 将每个链表的头节点放入堆中
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }

        // 创建一个哑节点来简化操作
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // 逐步从堆中取出最小节点，并将该节点的下一个节点（如果有）加入堆中
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll(); // 取出最小的节点
            current.next = node; // 将该节点加入结果链表
            current = current.next; // 移动 current 指针

            if (node.next != null) {
                minHeap.offer(node.next); // 将下一个节点加入堆中
            }
        }

        // 返回合并后的链表（哑节点后的第一个节点）
        return dummy.next;
    }


}
