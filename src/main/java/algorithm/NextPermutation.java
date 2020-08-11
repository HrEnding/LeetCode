package algorithm;

import java.util.Arrays;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须原地修改，只允许使用额外常数空间。
 *
 * @Author: Hr_Ending
 * @Date: 2020/8/11 20:36
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        //i 指针在前，从后往前遍历
        for (int i = nums.length - 1; i >= 0; i--) {
            // j指针在后
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] < nums[j]) {
                    swap(nums, i, j);
                    Arrays.sort(nums, i + 1, nums.length);
                    return;
                }
            }
        }
        //如果没有找到
        Arrays.sort(nums);
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
