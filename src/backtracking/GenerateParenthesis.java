package backtracking;


import java.util.ArrayList;
import java.util.List;

/**
 * @author yeweixiong
 * @date 2021/1/4 11:24
 */
public class GenerateParenthesis {
    int size = 0;

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        char[] chars = new char[2 * n];
        size = 2 * n;
        process(n, n, "", res);
        return res;
    }


    private void process(int leftRemain, int rightRemain, String s, List<String> res) {

        if (rightRemain < leftRemain) {
            return;
        }

        if (leftRemain == 0 && rightRemain == 0) {
            res.add(s);
            return;
        }

        //左边剩下的要比右边少，先(,在)
        if (leftRemain >= 0) {
            process(leftRemain - 1, rightRemain, s + "(", res);
            process(leftRemain, rightRemain - 1, s + ")", res);
        }
    }


    public List<String> generateParenthesis2(int n) {
        List<String> res = new ArrayList<>();
        char[] chars = new char[2 * n];
        process2(n, n, chars, res);
        return res;
    }


    private void process2(int leftRemain, int rightRemain, char[] chars, List<String> res) {
        //左边剩下的要比右边少
        if (rightRemain < leftRemain) {
            return;
        }

        if (leftRemain == 0 && rightRemain == 0) {
            res.add(new String(chars));
            return;
        }

        //先(,在)
        if (leftRemain >= 0) {
            chars[chars.length - leftRemain - rightRemain] = '(';
            process2(leftRemain - 1, rightRemain, chars, res);
            chars[chars.length - leftRemain - rightRemain] = ')';
            process2(leftRemain, rightRemain - 1, chars, res);
        }
    }

    public static void main(String[] args) {
        List<String> list = new GenerateParenthesis().generateParenthesis2(3);
        System.out.println(list);
    }
}
