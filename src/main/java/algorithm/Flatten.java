package algorithm;

import structure.TreeNode;

/**
 * 给定一个二叉树，原地将它展开为一个单链表。
 *
 * @Author: Hr_Ending
 * @Date: 2020/8/2 10:53
 */
public class Flatten {
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode next = curr.left;
                TreeNode predecessor = next;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                predecessor.right = curr.right;
                curr.left = null;
                curr.right = next;
            }
            curr = curr.right;
        }
    }
}
