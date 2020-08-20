package algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * @Author: Hr_Ending
 * @Date: 2020/8/20 20:37
 */
public class PermuteUnique {
    public List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) {
            return result;
        }
        //首先给数组排序
        Arrays.sort(nums);
        findUnique(nums, new boolean[nums.length], new LinkedList<>());
        return result;
    }

    public void findUnique(int[] nums, boolean[] visited, LinkedList<Integer> trace) {
        //结束条件
        if (trace.size() == nums.length) {
            result.add(new LinkedList<>(trace));
            return;
        }
        //选择列表
        for (int i = 0; i < nums.length; i++) {
            //其次，我们已经选择过的不需要再放进去了
            if (visited[i]) {
                continue;
            }
            //接下来，如果当前节点与他的前一个节点一样，并其他的前一个节点已经被遍历过了，那我们也就不需要了。
            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1]) {
                break;
            }
            //做出选择
            trace.add(nums[i]);
            visited[i] = true;
            findUnique(nums, visited, trace);
            //撤销选择
            trace.removeLast();
            visited[i] = false;
        }
    }
}
