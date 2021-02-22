/**
 * create by yeweixiong
 *
 * @date 2020/9/28 10:43
 * 最长公共前缀
 */
public class LongestCommonPrefix {


    /**
     * O (N * M)
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        int i = 0;

        a:
        while (true) {
            Character s = null;
            for (String str : strs) {
                if (str.length() > i) {
                    if (s == null) {
                        s = str.charAt(i);
                    } else if (s != str.charAt(i)) break a;
                } else break a;
            }
            res.append(s);
            i++;
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"dog", "racecar", "car"};

        System.out.println(longestCommonPrefix(strs));
    }
}
