package tree;

import java.util.*;

/**
 * create by yeweixiong
 *
 * @date 2020/11/11 17:24
 * 给定一个二叉树，检查它是否是镜像对称的。
 */
public class Symmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return process(root, root);
    }

    private boolean process(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null || node2 == null) {
            //只有一个为空直接 false
            return false;
        } else if (node1.val != node2.val) {
            //值不相等 false
            return false;
        } else {
            return process(node1.left, node2.right)  // node1.left vs node2.right
                    && process(node1.right, node2.left); //node1.right vs node2.left
        }
    }


    /**
     * 非递归版本
     * 二叉树层次遍历
     *
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        int depth = 0;
        TreeNode poll;
        //上一层的最后一个
        TreeNode preLast = root;
        //当前层的最后一个
        TreeNode curLast = null;
        List<Integer> list = new ArrayList<>();

        while (!queue.isEmpty()) {
            poll = queue.poll();
            if (poll == null) {
                list.add(null);
                continue;
            }
            if (poll != root) {
                list.add(poll.val);
            }
            if (poll.left != null) {
                queue.offer(poll.left);
                curLast = poll.left;
            } else {
                queue.offer(null);
            }

            if (poll.right != null) {
                queue.offer(poll.right);
                curLast = poll.right;
            } else {
                queue.offer(null);
            }

            if (poll == preLast) {
                System.out.println(list);
                if (!isListSymmetric(list, depth)) {
                    return false;
                }

                list.clear();
                //进入下一层
                preLast = curLast;
                depth++;

            }
        }
        return true;

    }

    private boolean isListSymmetric(List<Integer> list, int depth) {
        if (depth == 0) {
            return true;
        }

        int realLayerSize = (int) Math.pow(2, depth);
        int size = list.size();

        if (size < realLayerSize) {
            for (int i = 0; i < realLayerSize - size; i++) {
                if (list.get(i) != null) {
                    return false;
                }
            }
        }


        int i = realLayerSize - size;
        int j = list.size() - 1;

        while (i < j) {
            if (!equals(list.get(i), list.get(j))) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    private boolean equals(Integer a, Integer b) {
        if (a == null && b == null) {
            return true;
        }
        return a != null && a.equals(b);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(5);
        root.left.left.left = new TreeNode(6);
        root.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.right.right = new TreeNode(6);

        System.out.println(new Symmetric().isSymmetric2(root));

//        System.out.println((int) Math.pow(3, 2));
    }

}
