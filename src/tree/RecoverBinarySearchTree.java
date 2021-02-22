package tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * 给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。
 */
public class RecoverBinarySearchTree {


    /**
     * 找到某个节点左边比它大的节点和右边比它小的节点
     *
     * @param root
     */
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        process(root);
    }

    /**
     * @param node
     * @return 当前节点的最大子节点
     */
    private TreeNode process(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode leftMax = process(node.left);
        TreeNode rightMax = process(node.right);
        if (leftMax == null) {
            if (rightMax == null) {
                return node;
            }
            if (node.val > rightMax.val) {
                swap(node, rightMax);
                //右边不对劲
                return node;
            } else {
                return rightMax;
            }
        }


        if (rightMax == null) {
            if (leftMax.val > node.val) {
                //左边不对劲
                swap(leftMax, node);
                return leftMax;
            } else {
                return node;
            }
        }

        //都不为空，判断是否需要交换,三个节点之间比较,最小值和最大值进行交换
//        int min = Math.min(node.val, Math.min(leftMax.val, rightMax.val));
//        int max = Math.max(node.val, Math.max(leftMax.val, rightMax.val));

        TreeNode minNode = node;
        TreeNode maxNode = node;

        if (leftMax.val < minNode.val) {
            minNode = leftMax;
        } else {
            maxNode = leftMax;
        }

        if (rightMax.val < minNode.val) {
            minNode = rightMax;
        }

        if (rightMax.val > maxNode.val) {
            maxNode = rightMax;
        }

        if (maxNode.val != rightMax.val || minNode.val != leftMax.val) {
            swap(maxNode, minNode);
        }


        return maxNode;

    }


    private void swap(TreeNode a, TreeNode b) {
        a.val = a.val ^ b.val;
        b.val = a.val ^ b.val;
        a.val = a.val ^ b.val;
    }

    public static void main(String[] args) {
        RecoverBinarySearchTree test = new RecoverBinarySearchTree();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);

        test.recoverTree(root);
        class Test {
            int i;
            String s;

            Test(int i, String s) {
                this.i = i;
                this.s = s;
            }
        }

        List<Test> list = new ArrayList<>();


        for (int i = 0; i < 100; i++) {
            list.add(new Test(new Random().nextInt(),String.valueOf(i)));
        }

        Test max = list.stream().max(Comparator.comparingInt(o -> o.i)).get();

    }
}
