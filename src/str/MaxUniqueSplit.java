package str;


import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author yeweixiong
 * @date 2021/1/6 9:53
 * <p>
 * 给你一个字符串 s ，请你拆分该字符串，并返回拆分后唯一子字符串的最大数目。
 * <p>
 * 字符串 s 拆分后可以得到若干 非空子字符串 ，这些子字符串连接后应当能够还原为原字符串。但是拆分出来的每个子字符串都必须是 唯一的 。
 * <p>
 * 注意：子字符串 是字符串中的一个连续字符序列。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-a-string-into-the-max-number-of-unique-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * ababccc 5
 * <p>
 * aba 2
 * <p>
 * aa 1
 */
public class MaxUniqueSplit {
    int max = 0;

    public int maxUniqueSplit(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        process(s.toCharArray(), 0, new TreeSet<>());
        return max;
    }

    private void process(char[] chars, int index, Set<String> set) {
        if (index == chars.length) {
            System.out.println(set);
            max = Math.max(max, set.size());
            return;
        }
        for (int i = index; i < chars.length; i++) {
            String s = new String(chars, index, i - index + 1);

            if (set.contains(s)) {
                continue;
            }
            //?这个剪枝，为何效率提升如此之大
            if (max >= set.size() + chars.length - i) {
                return;
            }
            set.add(s);
            process(chars, i + 1, set);
            set.remove(s);


        }
    }

    public static void main(String[] args) {
        String s = "ababccc";
        int i = new MaxUniqueSplit().maxUniqueSplit(s);
        System.out.println(i);
    }
}
