package algorithm;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树中的两个节点被错误地交换。
 * <p>
 * 请在不改变其结构的情况下，恢复这棵树。
 *
 * @Author: Hr_Ending
 * @Date: 2020/8/8 16:34
 */
public class RecoverTree {

    public void recoverTree(TreeNode root) {
        List<Integer> nums = new ArrayList<Integer>();

        //将树中序排列
        inorder(root, nums);
        int[] swapped = findTwoSwapped(nums);
        recover(root, 2, swapped[0], swapped[1]);
    }

    /**
     * 将树中序遍历成集合
     *
     * @param root 树
     * @param nums 中序集合
     */
    public void inorder(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return;
        }
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }

    /**
     * 获取被交换的两个数
     *
     * @param nums
     * @return
     */
    public int[] findTwoSwapped(List<Integer> nums) {
        int n = nums.size();
        int x = -1, y = -1;
        for (int i = 0; i < n - 1; ++i) {
            //找到数组中的降序值
            if (nums.get(i + 1) < nums.get(i)) {
                y = nums.get(i + 1);
                if (x == -1) {
                    x = nums.get(i);
                } else {
                    break;
                }
            }
        }
        return new int[]{x, y};
    }

    /**
     * 将被交换的两个值恢复
     *
     * @param root
     * @param count
     * @param x
     * @param y
     */
    public void recover(TreeNode root, int count, int x, int y) {
        if (root != null) {
            //找到被交换数的位置进行恢复
            if (root.val == x || root.val == y) {
                root.val = root.val == x ? y : x;
                //count为0时说明恢复结束
                if (--count == 0) {
                    return;
                }
            }
            //递归继续往下找
            recover(root.right, count, x, y);
            recover(root.left, count, x, y);
        }
    }
}
