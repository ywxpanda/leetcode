package tree;

/**
 * @author yeweixiong
 * @date 2020/12/29 17:16
 */
public class MaxPathSum {

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        if (root == null) {
            return 0;
        }
        process(root);

        return max;

    }

    private int process(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftPath = process(node.left);
        int rightPath = process(node.right);
        int size = max(node.val, node.val + rightPath, node.val + leftPath);
        max = max(max, size, node.val + leftPath + rightPath);
        return size;
    }

    private int max(int... val) {
        int max = val[0];
        for (int i = 1; i < val.length; i++) {
            max = Math.max(max, val[i]);
        }
        return max;
    }
}
