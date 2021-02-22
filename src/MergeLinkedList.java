import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * create by yeweixiong
 *
 * @date 2020/10/10 14:24
 */


public class MergeLinkedList {
    static class ListNode {
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


    public static ListNode mergeKLists(ListNode[] lists) {

        ListNode res = new ListNode();
        ListNode tmp = res;

        while (true) {
            int index = Integer.MAX_VALUE;
            int value = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    if (lists[i].val < value) {
                        index = i;
                        value = lists[i].val;
                    }
                }
            }
            if (value == Integer.MAX_VALUE) {
                break;
            }
            tmp.next = new ListNode(value);
            lists[index] = lists[index].next;
            tmp = tmp.next;
        }

        return res.next;
    }


    public static ListNode mergeKLists2(ListNode[] lists) {

        ListNode res = new ListNode();
        ListNode tmp = res;
        Queue<Integer> queue = new PriorityQueue<>();
        for (ListNode list : lists) {
            while (list != null) {
                queue.add(list.val);
                list = list.next;
            }
        }
        while (!queue.isEmpty()) {
            tmp.next = new ListNode(queue.poll());
            tmp = tmp.next;
        }
        return res.next;
    }

    private static ListNode assembly(int[] arr) {
        ListNode node = new ListNode(arr[0]);
        ListNode cur = node;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return node;


    }

    private static void print(ListNode head) {


        ListNode node = head;
        StringBuilder sb = new StringBuilder();

        while (node != null) {
            sb.append(node.val).append(",");
            node = node.next;
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        ListNode[] lists = {assembly(new int[]{1, 4, 5}), assembly(new int[]{1, 3, 4}), assembly(new int[]{2, 6})};
        ListNode node = mergeKLists(lists);

        print(node);

    }

}
