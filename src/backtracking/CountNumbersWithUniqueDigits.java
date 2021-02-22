package backtracking;

/**
 * @author yeweixiong
 * @date 2021/1/27 13:35
 * https://leetcode-cn.com/problems/count-numbers-with-unique-digits/
 */
public class CountNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if (n < 1 || n > 9) {
            return 1;
        }
        int res = 10;
        int[] tmp = {9};
        for (int i = 1; i < n; i++) {
            tmp[0] = (10 - i) * tmp[0];
            res += tmp[0];
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 3;
        int i = new CountNumbersWithUniqueDigits().countNumbersWithUniqueDigits(n);
        System.out.println(i);
    }
}
