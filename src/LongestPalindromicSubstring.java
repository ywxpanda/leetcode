import utils.StringUtils;

/**
 * create by yeweixiong
 *
 * @date 2020/9/25 10:40
 * <p>
 * 最长回文子串
 */
public class LongestPalindromicSubstring {


    /**
     * Log(n * n)
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.trim().length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        String res = "";

        //枚举中间位置,最后一个不用处理
        for (int i = 0; i < chars.length - 1; i++) {
            String tmp = getPalindromeString(chars, String.valueOf(chars[i]), i - 1, i + 1);
            if (tmp.length() > res.length()) {
                res = tmp;
            }

            if (chars[i] == chars[i + 1]) {
                tmp = getPalindromeString(chars, "" + chars[i] + chars[i + 1], i - 1, i + 2);
                if (tmp.length() > res.length()) {
                    res = tmp;
                }
            }
        }

        return res;
    }

    private static String getPalindromeString(char[] chars, String cur, int before, int after) {
        StringBuilder tmp = new StringBuilder(cur);
        while (before >= 0 && after <= chars.length - 1) {
            if (chars[before] != chars[after]) {
                break;
            }
            tmp.insert(0, chars[before--]);
            tmp.append(chars[after++]);
        }
        return tmp.toString();
    }


    public static void main(String[] args) {
        System.out.println(longestPalindrome("a"));
    }

}
