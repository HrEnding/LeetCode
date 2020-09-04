package algorithm;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * @Author: Hr_Ending
 * @Date: 2020/9/4 22:10
 */
public class BinaryTreePaths {
    List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, new StringBuilder());
        return res;
    }

    public void dfs(TreeNode root, StringBuilder sb) {
        if (root != null && root.right == null && root.left == null) {
            int len = sb.length();
            sb.append("->").append(root.val);
            res.add(sb.toString().substring(2));
            sb.delete(len, sb.length());
            return;
        }
        if (root != null) {
            int len = sb.length();
            sb.append("->").append(root.val);
            if (root.left != null) {
                dfs(root.left, sb);
            }
            if (root.right != null) {
                dfs(root.right, sb);
            }
            sb.delete(len, sb.length());
        }
    }
}
