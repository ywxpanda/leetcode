package dp;

/**
 * @author yeweixiong
 * @since 2021/2/22 9:59
 * <p>
 * 给你一个整数 n，请返回长度为 n 、仅由元音 (a, e, i, o, u) 组成且按 字典序排列 的字符串数量。
 * <p>
 * 字符串 s 按 字典序排列 需要满足：对于所有有效的 i，s[i] 在字母表中的位置总是与 s[i+1] 相同或在 s[i+1] 之前。
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-sorted-vowel-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountVowelStrings {
//    private static final char[] vowels = {'a', 'e', 'i', 'o', 'u'};

    public int countVowelStrings(int n) {

        int[] dp = {1, 1, 1, 1, 1};

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < dp.length; j++) {
                for (int k = j + 1; k < dp.length; k++) {
                    dp[j] += dp[k];
                }
            }
        }
        int sum = 0;
        for (int i : dp) {
            sum+=i;
        }

        return sum;
    }


    public static void main(String[] args) {
        int value = new CountVowelStrings().countVowelStrings(33);

        System.out.println(value);
    }
}
