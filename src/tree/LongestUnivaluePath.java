package tree;

/**
 * @author yeweixiong
 * @date 2020/12/16 9:39
 */
public class LongestUnivaluePath {

    int max = 1;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        process(root, root.val);
        return max - 1;
    }


    private int process(TreeNode node, int val) {
        int leftHeight = 0;
        int rightHeight = 0;
        if (node.left != null) {
            leftHeight = process(node.left, node.val);
        }
        if (node.right != null) {
            rightHeight = process(node.right, node.val);
        }
        max = Math.max(max, leftHeight + rightHeight + 1);
        if (node.val == val) {
            return Math.max(leftHeight, rightHeight) + 1;
        }
        return 0;
    }

   /* private int process(TreeNode node, int val) {
        if (node == null) {
            return 0;
        }
        int leftHeight = process(node.left, node.val);
        int rightHeight = process(node.right, node.val);
        max = Math.max(max, leftHeight + rightHeight + 1);
        if (node.val == val) {
            return Math.max(leftHeight, rightHeight) + 1;
        }
        return 0;
    }*/

    /**
     * @return 有效的height
     *//*
    private int process(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int height = 1;
        int leftHeight = process(node.left);
        int rightHeight = process(node.right);
        int size = 1;
        //max = Math.max(max, leftHeight + rightHeight + 1);

        if (leftHeight != 0 && node.left.val == node.val) {
            height = height + leftHeight;
            size += leftHeight;
        }

        if (rightHeight != 0 && node.right.val == node.val) {
            height = Math.max(height, rightHeight + 1);
            size += rightHeight;
        }
        max = Math.max(max, size);
        return height;

    }*/


//    private Info process(TreeNode node) {
//        if (node == null) {
//            return null;
//        }
//
//        int val = node.val;
//        int height = 1;
//        int size = 1;
//        Info leftInfo = process(node.left);
//        Info rightInfo = process(node.right);
//
//        if (leftInfo != null && leftInfo.val == val) {
//            size += leftInfo.height;
//            height = Math.max(height, leftInfo.height + 1);
//        }
//
//        if (rightInfo != null && rightInfo.val == val) {
//            size += rightInfo.height;
//            height = Math.max(height, rightInfo.height + 1);
//        }
//
//        Info res = new Info(val, height);
//        max = Math.max(size, max);
//        return res;
//    }
//
//    static class Info {
//        int val;
//        int height;
//
//        Info(int val, int length) {
//            this.val = val;
//            this.height = length;
//        }
//    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(1);
        root.right.left.left = new TreeNode(1);
        root.right.left.right = new TreeNode(1);
        root.right.right.left = new TreeNode(1);
//        root.left = new TreeNode(4);
//        root.right = new TreeNode(5);
//        root.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(1);
//        root.right.left = new TreeNode(5);

        LongestUnivaluePath longestUnivaluePath = new LongestUnivaluePath();
        int i = longestUnivaluePath.longestUnivaluePath(root);
        System.out.println(i);

    }

}
