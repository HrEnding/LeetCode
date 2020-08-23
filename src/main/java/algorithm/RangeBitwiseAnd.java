package algorithm;

/**
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 *
 * @Author: Hr_Ending
 * @Date: 2020/8/23 17:09
 */
public class RangeBitwiseAnd {
    public int rangeBitwiseAnd(int m, int n) {
        int zeros = 0;
        while (n > m) {
            n = n & (n - 1);
        }
        return n;
    }
}
