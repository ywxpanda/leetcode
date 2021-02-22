package linkedlist;

/**
 * create by yeweixiong
 *
 * @date 2020/10/22 16:03
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int x) {
        val = x;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode generateListNode(int[] arr) {
        ListNode node = new ListNode(arr[0]);
        ListNode cur = node;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return node;
    }


    public static void print(ListNode root) {
        ListNode node = root;
        while (node != null) {
            System.out.print(node.val + ",");
            node = node.next;
        }

        System.out.println();
    }


    public static ListNode doReverse(ListNode head) {

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
}