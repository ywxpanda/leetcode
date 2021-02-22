package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author yeweixiong
 * @date 2021/1/13 18:18
 */
public class CombinationSum {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return null;
        }
        Arrays.sort(candidates);
        process(candidates, target, 0, new ArrayList<>());
        return res;
    }

    private void process(int[] candidates, int last, int index, List<Integer> list) {
        if (last < 0) return;
        if (last == 0) {
            res.add(new ArrayList<>(list));
        }
        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            process(candidates, last - candidates[i], i, list);
            list.remove(list.size() - 1);
//            tmpArr[tmpArrIndex] = 0;
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(candidates);
        Set<List<Integer>> res = new HashSet<>();

        process2(candidates, 0, target, new ArrayList<>(), res);

        return new ArrayList<>(res);
    }

    private void process2(int[] candidates, int index, int last, List<Integer> list, Set<List<Integer>> res) {
        if (last < 0) return;
        if (last == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < candidates.length && last >= candidates[i]; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            process2(candidates, i + 1, last - candidates[i], list, res);
            list.remove(list.size() - 1);
        }
    }


    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> lists = combinationSum.combinationSum2(arr, 8);
        System.out.println(lists);
    }
}
