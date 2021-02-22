package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yeweixiong
 * @date 2021/1/5 17:56
 */
public class CountPairs {
    int res = 0;

    public int countPairs(TreeNode root, int distance) {
        if (root == null) {
            return 0;
        }
        int[] arr = new int[distance];
        process(root, distance);
        return res;
    }

    /**
     * size
     *
     * @param node
     * @param distance
     * @return 该节点到每个叶子节点的深度
     */
    private List<Integer> process(TreeNode node, int distance) {

        if (node == null) {
            return new ArrayList<>();
        }

        if (node.left == null && node.right == null) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            return list;
        }

        List<Integer> leftList = process(node.left, distance);
        List<Integer> rightList = process(node.right, distance);
        //计算组合
        for (Integer leftRes : leftList) {
            for (Integer rightRes : rightList) {
                if (leftRes + rightRes <= distance) {
                    res++;
                } else break;
            }
        }

//        System.out.println(res);
        leftList.addAll(rightList);
        for (int i = 0; i < leftList.size(); i++) {
            leftList.set(i, leftList.get(i) + 1);
        }

        return leftList;

    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(new CountPairs().countPairs(root, 3));
    }
}
