package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yeweixiong
 * @date 2020/12/23 10:09
 */
public class SubtreeWithAllDeepest {
    Map<TreeNode, Integer> depthMap = new HashMap<>();

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) {
            return null;
        } else {
            int leftDepth = getDepth(root.left);
            int rightDepth = getDepth(root.right);
            if (leftDepth == rightDepth) {
                return root;
            } else if (leftDepth > rightDepth) {
                return subtreeWithAllDeepest(root.left);
            } else {
                return subtreeWithAllDeepest(root.right);
            }
        }
    }


    private int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        } else {

            //depthMap.getOrDefault(node,Math.max(getDepth(node.left), getDepth(node.right)) + 1);
            if (depthMap.containsKey(node)) {
                return depthMap.get(node);
            } else {
                int depth = Math.max(getDepth(node.left), getDepth(node.right)) + 1;
                depthMap.put(node, depth);
                return depth;
            }
        }
    }
}
