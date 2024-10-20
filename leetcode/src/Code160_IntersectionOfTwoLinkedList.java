/**
 * @author CD
 * @date 10/14/2024
 * @description
 */
public class Code160_IntersectionOfTwoLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    // 法一
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 如果其中一个链表为空，直接返回 null
        if (headA == null || headB == null) {
            return null;
        }

        // 计算两个链表的长度
        int lenA = getLength(headA);
        int lenB = getLength(headB);

        // 对齐两个链表的长度
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        while (lenB > lenA) {
            headB = headB.next;
            lenB--;
        }

        // 同时遍历两个链表，寻找交点
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA; // 找到交点
            }
            headA = headA.next;
            headB = headB.next;
        }

        return null; // 没有交点
    }

    // 计算链表的长度
    private int getLength(ListNode node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }


    // 法二
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pa = headA;
        ListNode pB = headB;
        ListNode pb = headB;
        ListNode pShort = null;
        ListNode pLong = null;

        while(pA != null && pB != null) {
            pA = pA.next;
            pB = pB.next;
        }

        // pA 指向较长的链表
        while(pA != null){
            pA = pA.next;
            pa = pa.next;
        }
        // pB 指向较长的链表
        while(pB != null){
            pB = pB.next;
            pb = pb.next;
        }

        // 找到较短的链表
        while(pa != pb) {
            pa = pa.next;
            pb = pb.next;
        }

        return pa;

    }

}
