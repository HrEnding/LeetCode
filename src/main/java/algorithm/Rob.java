package algorithm;

import structure.TreeNode;

/**
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。
 * 这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。
 * 一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * <p>
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 *
 * @Author: Hr_Ending
 * @Date: 2020/8/5 20:15
 */
public class Rob {
    public int rob(TreeNode root) {
        //计算当前节点偷与不偷所能获得收益，结果存在数组result中
        int[] result = countSum(root);
        //根据题意可知需取其中最大的
        return Math.max(result[0], result[1]);
    }

    public int[] countSum(TreeNode root) {
        int[] result = new int[2];
        //如果当前节点为空节点，则其结果为0
        if (root == null) {
            return result;
        }
        //计算当前节点左儿子偷与不偷所能获得的收益
        int[] left = countSum(root.left);
        //计算当前节点右儿子偷与不偷所能获得的收益
        int[] right = countSum(root.right);
        //不偷当前节点所能获得的最大收益 = 左儿子所能获得的最大收益 + 右儿子所能获得的最大收益
        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        //偷当前节点所能获得的最大收益= 偷当前节点的钱 + 不偷左儿子所获得的钱 +不偷右儿子所获得的钱
        result[1] = root.val + left[0] + right[0];
        return result;
    }
}
