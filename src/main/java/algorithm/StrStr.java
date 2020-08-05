package algorithm;

/**
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
 * 如果不存在，则返回  -1。
 *
 * @Author: Hr_Ending
 * @Date: 2020/8/5 20:18
 */
public class StrStr {
    public int strStr(String haystack, String needle) {
        int sourceLen = haystack.length();
        int targetLen = needle.length();

        // 注意特判
        if (targetLen == 0) {
            return 0;
        }

        // 若 target 长度大于 source，则不可能匹配
        if (targetLen > sourceLen) {
            return -1;
        }

        for (int i = 0; i < sourceLen - targetLen + 1; i++) {
            // 定义 k 来与 target 进行挨个比对
            int k = i;
            for (int j = 0; j < targetLen; j++) {
                if (haystack.charAt(k) == needle.charAt(j)) {
                    // 最后一个字符匹配完成，输出答案
                    if (j == targetLen - 1) {
                        return i;
                    }
                    k++;
                }
                // 其中一个字符无法匹配，直接退出做下一次循环
                else {
                    break;
                }
            }
        }
        return -1;
    }
}
