package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 *
 * @Author: Hr_Ending
 * @Date: 2020/8/17 20:18
 */
public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        getResult(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }


    private static void getResult(List<List<Integer>> result, List<Integer> cur, int[] candidates, int target, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[i]) {
                continue;
            }
            //选择当前节点，类似于从当前节点开始往下遍历
            cur.add(candidates[i]);
            getResult(result, cur, candidates, target - candidates[i], i);
            //回到当前节点的时候我们把当前节点给移除,
            // 然后通过循环走同一层的其他节点。
            cur.remove(cur.size() - 1);
        }
    }
}
