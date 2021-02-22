
/**
 * create by yeweixiong
 *
 * @date 2020/9/27 10:05
 * 正则匹配
 */
public class RegexMatch {


    /**
     * 1.0 版本 递归
     *
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        char[] chars = s.toCharArray();
        char[] pattern = p.toCharArray();
        int patternIndex = 0;
        //先去除头部的*号
        for (int i = 0; i < pattern.length; i++) {
            //去除头部*
            if (pattern[i] != '*') {
                patternIndex = i;
                break;
            }
        }
        return process(chars, pattern, 0, patternIndex);

    }

    /**
     * @param chars        源
     * @param pattern      正则数组
     * @param index        匹配位置
     * @param patternIndex 正则数组匹配位置
     * @return 是否匹配成功
     */
    private static boolean process(char[] chars, char[] pattern, int index, int patternIndex) {
        //都到头了
        if (index == chars.length && patternIndex == pattern.length) {
            return true;
        }
        //一个到头了另一个没到头
        if (index == chars.length || patternIndex >= pattern.length) {
            if (patternIndex >= pattern.length) return false;
            if ((pattern.length - patternIndex) % 2 == 0) {
                for (int i = patternIndex + 1; i < pattern.length; i += 2) {
                    if (pattern[i] != '*') {
                        return false;
                    }
                }
                return true;
            } else return false;

        }

        /**
         *  ".*"处理
         *  匹配上之后继续使用
         *  匹配上，之后匹配下一个 patternIndex+2
         */
        if (patternIndex + 1 < pattern.length && pattern[patternIndex] == '.' && pattern[patternIndex + 1] == '*') {
            return process(chars, pattern, index + 1, patternIndex)
                    || process(chars, pattern, index + 1, patternIndex + 2)
                    || process(chars, pattern, index, patternIndex + 2); //一步不走
        }

        //处理*号
        if (patternIndex + 1 <= pattern.length - 1 && pattern[patternIndex + 1] == '*') {
            //找到之前的部位*的字符
            char ch = '-';
            for (int i = patternIndex; i >= 0; i--) {
                if (pattern[i] != '*') {
                    ch = pattern[i];
                    break;
                }
            }
            if (chars[index] == ch) {
                return process(chars, pattern, index + 1, patternIndex + 2) //匹配了之后不在匹配
                        || process(chars, pattern, index + 1, patternIndex)
                        || process(chars, pattern, index, patternIndex + 2); // 匹配了后面继续批匹配
            } else {
                return process(chars, pattern, index, patternIndex + 2);
            }
        }

        if (chars[index] == pattern[patternIndex] || pattern[patternIndex] == '.')
            return process(chars, pattern, index + 1, patternIndex + 1);

        return false;
    }


    /**
     * 改动态规划
     *
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch2(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        char[] chars = s.toCharArray();
        char[] pattern = p.toCharArray();
        int patternIndex = 0;
        //先去除头部的*号
        for (int i = 0; i < pattern.length; i++) {
            //去除头部*
            if (pattern[i] != '*') {
                patternIndex = i;
                break;
            }
        }

        return process2(chars, pattern, 0, patternIndex);

    }

    /**
     * 升级2.0版本
     *
     * @param chars
     * @param pattern
     * @param index
     * @param patternIndex
     * @return
     */
    private static boolean process2(char[] chars, char[] pattern, int index, int patternIndex) {

        char[] indexC = new char[index];

        System.arraycopy(chars, 0, indexC, 0, index);


        char[] indexP = new char[patternIndex];
        System.arraycopy(pattern, 0, indexP, 0, patternIndex);

        if ("bbbb".equals(new String(indexC)) && ".*".equals(new String(indexP))) {

            System.out.println();
        }


        //都到头了
        if (index == chars.length && patternIndex == pattern.length) {
            return true;
        }
        //一个到头了另一个没到头
        if (index == chars.length || patternIndex >= pattern.length) {
            if (patternIndex < pattern.length) {
                for (int i = patternIndex; i < pattern.length; i++) {
                    System.out.print(pattern[i]);
                }
                System.out.println();
            }
            if (patternIndex >= pattern.length) return false;
            if ((pattern.length - patternIndex) % 2 == 0) {
                for (int i = patternIndex + 1; i < pattern.length; i += 2) {
                    if (pattern[i] != '*') {
                        return false;
                    }
                }
                return true;
            } else return false;
        }

        if (chars[index] == pattern[patternIndex] || pattern[patternIndex] == '.') {
            boolean b = process2(chars, pattern, index + 1, patternIndex + 1);
            boolean flag = false;

            if (patternIndex < pattern.length - 1 && pattern[patternIndex + 1] == '*') {
                flag = process(chars, pattern, index, patternIndex + 2)
                        || process2(chars, pattern, index + 1, patternIndex + 2)
                        || process2(chars, pattern, index, patternIndex + 2);
            }

            return b || flag;


        }

        if (pattern[patternIndex] == '*') {
            if (chars[index] == pattern[patternIndex - 1] || pattern[patternIndex - 1] == '.') {
                //和前一个字符匹配
                boolean a = process2(chars, pattern, index, patternIndex + 1);
                boolean b = process2(chars, pattern, index + 1, patternIndex);
                boolean c = process2(chars, pattern, index + 1, patternIndex + 1);
                return a || b || c;
            } else return false;
        }


        return false;

    }


    public static boolean isMatch3(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;//dp[i][j] 表示 s 的前 i 个是否能被 p 的前 j 个匹配
        for (int i = 0; i < p.length(); i++) { // here's the p's length, not s's
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true; // here's y axis should be i+1
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {//如果是任意元素 或者是对于元素匹配
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {//如果前一个元素不匹配 且不为任意元素
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                            /*
                            dp[i][j] = dp[i-1][j] // 多个字符匹配的情况
                            or dp[i][j] = dp[i][j-1] // 单个字符匹配的情况
                            or dp[i][j] = dp[i][j-2] // 没有匹配的情况
                             */

                    }
                }
            }
        }
        return dp[s.length()][p.length()];

    }


    public static void main(String[] args) {

//        String s = "ab";
//        String p = ".*c";

//        String s = "aa", p = "a";

        String s = "bbbba", p = ".*a*a";
//        String s = "ab", p = ".*c";
        System.out.println(isMatch(s, p));
        System.out.println(isMatch2(s, p));
        System.out.println(isMatch3(s, p));
    }


}
