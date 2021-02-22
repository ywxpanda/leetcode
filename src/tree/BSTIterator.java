package tree;
import java.util.Stack;

/**
 * create by yeweixiong
 *
 * @date 2020/11/16 12:39
 * <p>
 * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 * <p>
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 */
public class BSTIterator {

    private final Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        pushLeft(root);
    }

    private void pushLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        if (stack.isEmpty()) {
            //return Integer.MIN_VALUE;
            throw new RuntimeException();
        }
        TreeNode node = stack.pop();
        int res = node.val;
        if (node.right != null) {
            pushLeft(node.right);
        }
        return res;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        BSTIterator bstIterator = new BSTIterator(root);

        while (bstIterator.hasNext()) {
            System.out.println(bstIterator.next());
        }
    }

}
