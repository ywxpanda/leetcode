package linkedlist;

/**
 * create by yeweixiong
 *
 * @date 2020/9/28 14:22
 */


public class RemoveNodeFromLinkedList {


    public ListNode swapPairs(ListNode head) {
        ListNode pre;
        ListNode cur;

        while (head != null) {

        }

        return head;
    }


    static int index;


    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        head.next = removeNthFromEnd(head.next, n);
        index++;
        if (n == index) {
            return head.next;
        }
        return head;
    }


    /**
     * [1,2,3,4,5]
     * 2
     *
     * @param args
     */
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        ListNode assembly = ListNode.generateListNode(arr);
        removeNthFromEnd(assembly, 2);

        ListNode.print(assembly);
    }


}
