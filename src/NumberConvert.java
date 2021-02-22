/**
 * create by yeweixiong
 *
 * @date 2020/9/25 14:05
 */
public class NumberConvert {
    public static int reverse(int x) {
        boolean isMinus = x < 0;
        x = Math.abs(x);
        StringBuilder s = new StringBuilder();
        while (x != 0) {
            s.append(x % 10);
            x = x / 10;
        }
        try {
            return isMinus ? -Integer.parseInt(s.toString()) : Integer.parseInt(s.toString());
        } catch (Exception e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        int a = -123;

        System.out.println(reverse(a));
    }
}
