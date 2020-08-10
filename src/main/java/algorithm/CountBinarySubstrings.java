package algorithm;

/**
 * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
 * <p>
 * 重复出现的子串要计算它们出现的次数。
 *
 * @Author: Hr_Ending
 * @Date: 2020/8/10 20:11
 */
public class CountBinarySubstrings {
    /**
     * 连续0与连续1构成的串中其符合条件的子串的数目等于Min(n,m)，n、m分别为连续0和1的个数。
     *
     * @param s
     * @return
     */
    public int countBinarySubstrings(String s) {
        int ptr = 0, n = s.length(), last = 0, ans = 0;
        while (ptr < n) {
            char c = s.charAt(ptr);
            int count = 0;
            //计算连续0或1的个数
            while (ptr < n && s.charAt(ptr) == c) {
                ++ptr;
                ++count;
            }
            //与上次连续个数进行比较，取最小值
            ans += Math.min(count, last);
            //上一次连续个数
            last = count;
        }
        return ans;
    }
}
