package str;

import java.lang.reflect.Field;

public class Test {

    private final char[] chs = new char[1];
    public String reverse(String str) throws NoSuchFieldException, IllegalAccessException {

        Field value = String.class.getDeclaredField("value");
        value.setAccessible(true);
        char[] chars = (char[]) value.get(str);

        int i = 0;

        int j = chars.length - 1;

        boolean startEmpty = true;
        boolean endEmpty = true;

        while (i < j) {
            if (chars[i] == ' ' && startEmpty) {
                i++;
            } else {
                startEmpty = false;
            }

            if (chars[j] == '_' && endEmpty) {
                j--;
            } else {
                endEmpty = false;
            }

            if (!startEmpty && !endEmpty) {
                swap(chars, i, j);
                i++;
                j--;
            }
        }

        return str;
    }

    private void swap(char[] chars, int i, int j) {
        chs[0] = chars[i];
        chars[i] = chars[j];
        chars[j] = chs[0];
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String s = "test";


        System.out.println(new Test().reverse(s));
    }
}
