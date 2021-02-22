package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yeweixiong
 * @since 2021/2/1 16:18
 * https://leetcode-cn.com/problems/palindrome-partitioning/
 */
public class Partition2 {

    public List<List<String>> partition(String s) {
        List<String> tmp = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();

        //使用动态规划预处理数据,记录那两个之间是回文
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int right = 0; right < s.length(); right++) {
            for (int left = 0; left <= right; left++) {
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2/*中间只有一个*/ || dp[left + 1][right - 1]) /*中间的已经是回文了*/) {
                    dp[left][right] = true;
                }

            }
        }

        process(s, 0, tmp, res, dp);


        return res;
    }

    private void process(String s, int index, List<String> tmp, List<List<String>> res, boolean[][] dp) {

        if (index == s.length()) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (dp[index][i]) {
                tmp.add(s.substring(index, i + 1));
                process(s, i + 1, tmp, res, dp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }


    /*private boolean valid(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }*/

    public static void main(String[] args) {
        String s = "abbab";

        Partition2 partition = new Partition2();


        System.out.println(partition.partition(s));

    }
}
