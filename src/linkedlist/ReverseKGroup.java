package linkedlist;

import java.util.List;

/**
 * create by yeweixiong
 *
 * @date 2020/10/22 16:03
 * <p>
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseKGroup {
    public  ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        //上一个循环最后一个节点
        ListNode pre = dummyHead;
        //最后一个节点
        ListNode end = dummyHead;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            ListNode cur = pre.next;
            ListNode next = end.next;

            //断开
            end.next = null;

            pre.next = doReverse(cur);


            //接回去
            cur.next = next;
            end = cur;
            pre = cur;

        }

        return dummyHead.next;
    }

    /**
     * 链表反转
     *
     * @param head
     * @return
     */
    private  ListNode doReverse(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;
        ListNode next;

        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }


        return pre;
    }

    public static void main(String[] args) {
        ListNode node = ListNode.generateListNode(new int[]{1, 2, 3, 4, 5, 45, 45, 6578, 98, 100});

//        ListNode node1 = doReverse(node);



        ListNode node1 = new ReverseKGroup().reverseKGroup(node, 3);

        ListNode.print(node1);
    }


}
