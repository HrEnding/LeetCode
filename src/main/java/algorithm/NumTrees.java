package algorithm;

/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * @Author: Hr_Ending
 * @Date: 2020/7/15 21:06
 */
public class NumTrees {
    public int numTrees(int n) {
        // 提示：我们在这里需要用 long 类型防止计算过程中的溢出
        long c = 1;
        for (int i = 0; i < n; ++i) {
            c = c * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) c;
    }
}
