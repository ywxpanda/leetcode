package tree;

import java.util.Stack;

/**
 * @author yeweixiong
 * @date 2020/12/21 9:41
 */
public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        int index = 1;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.add(node);
                node = node.left;
            } else {
                node = stack.pop();
                if (index++ == k) {
                    return node.val;
                }
                node = node.right;
            }
        }
        return -1;
    }


    

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(7);
        root.left.right = new TreeNode(4);

        KthSmallest kthSmallest = new KthSmallest();
        int i = kthSmallest.kthSmallest(root, 2);
        System.out.println(i);
    }
}
