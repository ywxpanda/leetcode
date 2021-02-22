package str;


import java.sql.Struct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author yeweixiong
 * @date 2021/1/11 9:26
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * <p>
 * <p>
 * <p>
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 */
public class Permutation {

    public String[] permutation(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        char[] chars = s.toCharArray();
        List<String> list = new ArrayList<>();
        process(chars, 0, list);
        return list.toArray(new String[]{});
    }

    private void process(char[] chars, int index, List<String> list) {
        if (index == chars.length) {
            list.add(new String(chars));
            return;
        }
        a:
        for (int i = index; i < chars.length; i++) {
            for (int j = index; j < i; j++) {
                if (chars[i] == chars[j]) {
                    continue a;
                }
            }
            swap(chars, index, i);
            process(chars, index + 1, list);
            swap(chars, index, i);
        }


    }


    private void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    public static void main(String[] args) {
        Permutation permutation = new Permutation();

        String[] abcs = permutation.permutation("aab");

        for (String abc : abcs) {
            System.out.print(abc + ",");
        }
    }
}
