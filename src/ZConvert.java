/**
 * create by yeweixiong
 *
 * @date 2020/9/25 11:37
 * <p>
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 */
public class ZConvert {

    /**
     * logN
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        if (numRows <= 1) return s;
        StringBuilder res = new StringBuilder();
        int tmp = (numRows - 1) * 2;
        for (int i = 0; i < numRows; i++) {
            int left = tmp - i * 2;
            for (int index = i; index <= s.length() - 1; index += tmp) {
                res.append(s.charAt(index));
                if (left != tmp && left != 0 && index + left <= s.length() - 1) {
                    res.append(s.charAt(index + left));
                }
            }
        }
        return res.toString();
    }


    //"PAYPALISHIRING"
    //3

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }
}
