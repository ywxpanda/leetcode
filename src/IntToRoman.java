import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * create by yeweixiong
 *
 * @date 2020/9/28 10:12
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-to-roman
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IntToRoman {

    public static String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] chars = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        int tmp;
        for (int i = 0; i < nums.length; i++) {
            tmp = num / nums[i];
            if (tmp > 0) {
                for (int i1 = 0; i1 < tmp; i1++) {
                    num -= nums[i];
                    sb.append(chars[i]);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int i = 58;

        System.out.println(intToRoman(i));
    }
}
