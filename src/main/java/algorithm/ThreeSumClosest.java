package algorithm;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * @Author: Hr_Ending
 * @Date: 2020/7/30 21:07
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        //先进行排序
        Arrays.sort(nums);
        //获取三数之和的最小值
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                //取接近target值
                if (Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                }
                //判断是否等于target
                if (sum > target) {
                    end--;
                } else if (sum < target) {
                    start++;
                } else {
                    return ans;
                }
            }
        }
        return ans;
    }
}
