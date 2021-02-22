package tree;

/**
 * @author yeweixiong
 * @date 2020/12/14 9:39
 */
public class TreeToDoublyList {

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }

        Record record = inOrder(root);

        record.right.right = record.left;
        record.left.left = record.right;
        return record.left;
    }

    static class Record {
        private Node left;
        private Node right;

        Record(Node left, Node right) {
            this.left = left;
            this.right = right;
        }
    }

    private Record inOrder(Node node) {

        if (node == null) {
            return null;
        }

        Record leftRecord = inOrder(node.left);
        //todo something

        if (leftRecord == null) {
            leftRecord = new Record(node, node);
        } else {
            //接上当前节点
            leftRecord.right.right = node;
            //往回指
            node.left = leftRecord.right;
            //更新right节点为当前节点
            leftRecord.right = node;
        }


        Record rightRecord = inOrder(node.right);

        if (rightRecord != null) {
            //接上right
            leftRecord.right.right = rightRecord.left;
            rightRecord.left.left = leftRecord.right;
            leftRecord.right = rightRecord.right;
        }
        return leftRecord;
    }


    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        TreeToDoublyList test = new TreeToDoublyList();
        Node node = test.treeToDoublyList(root);

        test.print(node);

    }

    private void print(Node root) {
        Node node = root;
        while (node.right != root) {
            System.out.println(node.val);
            node = node.right;
        }
    }
}
