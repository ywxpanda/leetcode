package tree;

import java.util.*;

public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        Map<TreeNode, List<Integer>> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();

        process(root, map, res, sum, new ArrayList<>());


        //System.out.println(res);

        return res;
    }


    private void process(TreeNode node, Map<TreeNode, List<Integer>> map, List<List<Integer>> res, int sum, List<Integer> father) {
        if (node == null) {
            return;
        }
        List<Integer> list;
        if (map.containsKey(node)) {
            list = map.get(node);
        } else {
            list = new ArrayList<>(father);
            map.put(node, list);
        }
        list.add(node.val);
        int curSum = sum(list);
        if (node.left == null && node.right == null && curSum == sum) {

            res.add(list);
        }
        if (node.left != null) {
            process(node.left, map, res, sum, list);
        }

        if (node.right != null) {
            process(node.right, map, res, sum, list);
        }
    }


    private int sum(List<Integer> list) {
        int sum = 0;
        for (Integer i : list) {
            sum += i;
        }

        return sum;
    }


    public List<List<Integer>> pathSum2(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        process2(root, sum, res, new ArrayList<>());
        return res;
    }

    private void process2(TreeNode node, int remain, List<List<Integer>> res, List<Integer> list) {
        if (remain - node.val == 0) {
            if (node.left == null && node.right == null) {
                list.add(node.val);
                res.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
            }
            return;
        }
        list.add(node.val);
        if (node.left != null) {
            process2(node.left, remain - node.val, res, list);
        }
        if (node.right != null) {
            process2(node.right, remain - node.val, res, list);
        }

        list.add(node.val);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        System.out.println(new PathSum().pathSum2(root, 22));
    }
}
