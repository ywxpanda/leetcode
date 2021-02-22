import utils.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * create by yeweixiong
 *
 * @date 2020/9/28 13:39
 */
public class LetterCombinations {
    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        Map<Character, char[]> map = new HashMap<>();
        map.put('2', "abc".toCharArray());
        map.put('3', "def".toCharArray());
        map.put('4', "ghi".toCharArray());
        map.put('5', "jkl".toCharArray());
        map.put('6', "mno".toCharArray());
        map.put('7', "pqrs".toCharArray());
        map.put('8', "tuv".toCharArray());
        map.put('9', "wxyz".toCharArray());

        List<String> res = new ArrayList<>();
        char[] chars = digits.toCharArray();
        char[] tmp = new char[chars.length];
        process(map, chars, 0, res, tmp);
        return res;
    }

    private static void process(Map<Character, char[]> map, char[] chars, int index, List<String> set, char[] res) {
        if (index == chars.length) {
            set.add(new String(res));
            return;
        }
        for (char ch : map.get(chars[index])) {
            res[index] = ch;
            process(map, chars, index + 1, set, res);
        }
    }


    public static void main(String[] args) {

        String s = "234";
        System.out.println(letterCombinations(s));
    }
}
