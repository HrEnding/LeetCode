package algorithm;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * @Author: Hr_Ending
 * @Date: 2020/9/14 21:21
 */
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        helper(list, root);
        return list;
    }

    public void helper(List<Integer> list, TreeNode root) {
        //终止条件
        if (root == null) {
            return;
        }
        //遍历当前节点的左子树
        helper(list, root.left);
        //把当前节点加入到集合中
        list.add(root.val);
        //遍历当前节点的右子树
        helper(list, root.right);
    }
}
