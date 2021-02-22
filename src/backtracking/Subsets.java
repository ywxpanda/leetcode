package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yeweixiong
 * @date 2021/1/4 10:56
 * <p>
 * 幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
 * <p>
 * https://leetcode-cn.com/problems/power-set-lcci/
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        process(nums, 0, res, list);

        return res;
    }

    private void process(int[] nums, int index, List<List<Integer>> res, List<Integer> list) {
        res.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            //add
            list.add(nums[i]);
            process(nums, i + 1, res, list);
            //remove
            list.remove(list.size() - 1);
        }
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        List<List<Integer>> subsets = new Subsets().subsets(arr);

        System.out.println(subsets);
    }


}
