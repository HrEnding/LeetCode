package algorithm;

import structure.TreeNode;

import java.util.Objects;

/**
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * @Author: Hr_Ending
 * @Date: 2020/7/28 20:50
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        } else {
            //递归左子树深度
            int leftHeight = maxDepth(root.left);
            //递归右子树深度
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
