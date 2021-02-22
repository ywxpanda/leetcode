package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yeweixiong
 * @since 2021/2/1 16:18
 * https://leetcode-cn.com/problems/palindrome-partitioning/
 */
public class Partition {

    public List<List<String>> partition(String s) {
        List<String> tmp = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();

        process(s, 0, tmp, res);


        return res;
    }

    private void process(String s, int index, List<String> tmp, List<List<String>> res) {

        if (index == s.length()) {
            res.add(new ArrayList<>(tmp));
            return;
        }


        for (int i = index; i < s.length(); i++) {
            if (valid(s,index,i)) {
                tmp.add(s.substring(index, i + 1));
                process(s, i + 1, tmp, res);
                tmp.remove(tmp.size() - 1);
            }
        }
    }


    /**
     * 判断是否回文
     *
     * @param s
     * @return
     */
    private boolean valid(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "asabasd";

        Partition partition = new Partition();


        System.out.println(partition.partition(s));

    }
}
