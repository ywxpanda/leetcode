package linkedlist;

/**
 * K 个一组翻转链表
 */
public class ReverseKG {

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummyHead = new ListNode();
        dummyHead.next = head;

        ListNode pre = dummyHead;
        ListNode end = dummyHead;


        while (end.next != null) {
            //end向后移动
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }

            ListNode curStart = pre.next;
            ListNode nextStart = end.next;

            //断开
            end.next = null;

            //curStart 变为当前个的最后一个
            pre.next = doReverse(curStart);

            //接上上一个
            curStart.next = nextStart;

            //接回去
            pre = curStart;
            end = curStart;


        }


        return dummyHead.next;

    }

    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    private ListNode doReverse(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode next;
        ListNode cur = head;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;

        }
        return pre;
    }
}
