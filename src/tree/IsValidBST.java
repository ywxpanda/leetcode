package tree;

import javax.smartcardio.ATR;
import java.util.*;

public class IsValidBST {

    static class Info {
        boolean isBST;
        int max;
        int min;

        Info(boolean isBST, int max, int min) {
            this.max = max;
            this.min = min;
            this.isBST = isBST;
        }
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }


        return valid(root).isBST;

    }


    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<Integer> list = new ArrayList<>();

        inOrder(root, list);
        System.out.println(list);
        int tmp;
        if (list.size() >= 1) {
            tmp = list.get(0);
        } else return true;

        for (int i = 1; i < list.size(); i++) {
            if (tmp >= list.get(i)) {
                return false;
            }
            tmp = list.get(i);
        }
        return true;

    }


    public boolean isValidBST3(TreeNode root) {
        long tmp = Long.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();

        TreeNode pNode = root;
        while (!stack.isEmpty() || pNode != null) {
//            System.out.println(tmp);
            if (pNode != null) {
                stack.push(pNode);
                pNode = pNode.left;
            } else {
                TreeNode pop = stack.pop();
//                System.out.println(pop.val);

                if (pop.val <= tmp) {
                    return false;
                }
                tmp = pop.val;

                pNode = pop.right;
            }

        }

        return true;
    }


    public boolean isValidBST4(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        boolean flag = false;
        int tmp = 0;
        TreeNode pNode = root;
        while (queue.peek() != null || pNode != null) {
            if (pNode != null) {
                queue.addLast(pNode);
                pNode = pNode.left;
            } else {
                TreeNode pop = queue.pollLast();
                if (!flag) {
                    tmp = pop.val;
                    flag = true;
                } else {
                    if (pop.val <= tmp) {
                        return false;
                    }
                    tmp = pop.val;
                }
                pNode = pop.right;
            }

        }

        return true;
    }


    private void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }


    private Info valid(TreeNode node) {
        if (node == null) {
            return null;
        }

        Info leftInfo = valid(node.left);
        Info rightInfo = valid(node.right);

        int max = node.val;
        int min = node.val;

        if (leftInfo != null) {
            min = Math.min(min, leftInfo.min);
            max = Math.max(max, leftInfo.max);
        }

        if (rightInfo != null) {
            min = Math.min(rightInfo.min, min);
            max = Math.min(rightInfo.max, max);
        }

        boolean isBST = false;
        //何时是bst
        if ((leftInfo == null || (leftInfo.isBST && node.val > leftInfo.max))
                && (rightInfo == null || (rightInfo.isBST && node.val < rightInfo.min))) {
            isBST = true;
        }
        return new Info(isBST, max, min);
    }


    public static void main(String[] args) {
        IsValidBST isValidBST = new IsValidBST();

        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(3);
//        treeNode.right.right = new TreeNode(3);
//        treeNode.right.right.left = new TreeNode(6);


        System.out.println(isValidBST.isValidBST3(treeNode));
        System.out.println(isValidBST.isValidBST4(treeNode));
    }

}
