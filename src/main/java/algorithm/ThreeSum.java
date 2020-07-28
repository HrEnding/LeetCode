package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 *
 * @Author: Hr_Ending
 * @Date: 2020/7/28 20:53
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();

        if (Objects.isNull(nums) || nums.length < 3) {
            return ans;
        }
        int len = nums.length;
        //将数组排序为有序数组
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if (nums[i] > 0) {
                break;
            }
            //去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = len - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    //去重
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    //去重
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return ans;
    }
}
