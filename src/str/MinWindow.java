package str;

/**
 * @author yeweixiong
 * @date 2020/12/30 11:37
 * <p>
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 */
public class MinWindow {
    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();

        int start = 0;
        int end = 0;


        int pre;
        int suffix;

        for (int i = 0; i < sLen - tLen; i++) {
            for (int j = 0; j < tLen; j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    pre = i;
                }
            }
        }

        return s.substring(start, end);
    }
}
