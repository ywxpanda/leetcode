package tree;

import java.util.HashMap;
import java.util.Map;

public class UniqueBinarySearchTrees {
    private final Map<Integer, Integer> map = new HashMap<>();

    public int numTrees(int n) {
        return process(1, n);
    }


    private int process(int start, int end) {
        int tmp = end - start;
        if (map.containsKey(tmp)) {
            return map.get(tmp);
        }
        if (end < start) {
            return 1;
        }
        int res = 0;
        //一i位置的数字为根节点
        for (int i = start; i <= end; i++) {
            //为左边数量和右边数量的乘积
            res += process(start, i - 1)  //左子树
                    * process(i + 1, end); //右子树
        }
        return res;
    }


    public int numTrees2(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 1;

        dp[1] = 1;


        // 1....4 == 2...5 ===3...6这三种数的形状和形成的数量是一样的

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {

                dp[i] += dp[j - 1]  //左子树
                        * dp[i - j]; //右子树
            }
        }

        return dp[n];
    }


    public static void main(String[] args) {
        UniqueBinarySearchTrees uniqueBinarySearchTrees = new UniqueBinarySearchTrees();
        int i = uniqueBinarySearchTrees.numTrees2(5);
        System.out.println(i);
    }
}
