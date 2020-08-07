package algorithm;

import structure.TreeNode;

/**
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * <p>
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * @Author: Hr_Ending
 * @Date: 2020/8/7 20:28
 */
public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 都为空的话，显然相同
        if (p == null && q == null) {
            return true;
            // 一个为空，一个非空，显然不同
        } else if (p == null || q == null) {
            return false;
            // 两个都非空，但 val 不一样也不行
        } else if (p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
