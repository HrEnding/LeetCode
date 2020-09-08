package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * @Author: Hr_Ending
 * @Date: 2020/9/8 21:38
 */
public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, n, k, 1, new ArrayList<>());
        return list;
    }

    private void backtrack(List<List<Integer>> list, int n, int k, int start, List<Integer> tempList) {
        //终止条件，找到一对组合
        if (k == 0) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        if (start <= n - k) {
            //不选当前值，k不变
            backtrack(list, n, k, start + 1, tempList);
        }
        //选择当前值，k要减1
        tempList.add(start);
        backtrack(list, n, k - 1, start + 1, tempList);
        //因为是递归调用，跳到下一个分支的时候，要把这个分支选的值给移除
        tempList.remove(tempList.size() - 1);
    }
}
