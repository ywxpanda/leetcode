package tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author yeweixiong
 * @date 2020/12/28 10:29
 */
public class IsCompleteTree {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Set<TreeNode> res = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        int cur = 1;
        int next = 0;

        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();

            if (poll != null) {
                cur--;
                System.out.print(poll.val + ",");
                if (poll.left != null) {
                    queue.offer(poll.left);
                    next++;
                } else {
                    queue.offer(null);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                    next++;
                } else {
                    queue.offer(null);
                }


            } else {
                System.out.print(null + ",");
            }

            if (cur == 0) {
                System.out.println();
                cur = next;
                next = 0;
            }

        }

        return true;

    }

    public boolean isCompleteTree2(TreeNode root) {
        if (root == null) {
            return true;
        }
        //层次遍历上一个值
        TreeNode pre = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (pre == null && cur != null) {
                //上一个为空，但当前不为空,不是完全二叉树
                return false;
            } else {
                pre = cur;
            }
            if (cur != null) {
                //同时加入null
                queue.offer(cur.left == null ? null : pre.left);
                queue.offer(cur.right == null ? null : pre.right);
            }
        }
        return true;
    }

    public boolean isCompleteTree3(TreeNode root) {
        if (root == null) {
            return true;
        }
        //层次遍历上一个值
        //TreeNode pre = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //前面是否出现了null子节点
        boolean preNull = false;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (preNull) {
                return false;
            }
            if (cur.left != null) {
                queue.offer(cur.left);
            } else {
                preNull = true;
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            } else {
                preNull = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
//        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        boolean completeTree = new IsCompleteTree().isCompleteTree2(root);
        System.out.println(completeTree);
    }
}
