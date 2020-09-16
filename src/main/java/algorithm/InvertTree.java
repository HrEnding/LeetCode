package algorithm;

import structure.TreeNode;

/**
 * 翻转一棵二叉树。
 *
 * @Author: Hr_Ending
 * @Date: 2020/9/16 23:09
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = left;
        return root;
    }
}
