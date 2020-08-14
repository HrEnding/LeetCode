package algorithm;

/**
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
 * <p>
 * 注意：整数序列中的每一项将表示为一个字符串。
 * <p>
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 第一项是数字 1
 * <p>
 * 描述前一项，这个数是 1 即 “一个 1 ”，记作 11
 * <p>
 * 描述前一项，这个数是 11 即 “两个 1 ” ，记作 21
 * <p>
 * 描述前一项，这个数是 21 即 “一个 2 一个 1 ” ，记作 1211
 * <p>
 * 描述前一项，这个数是 1211 即 “一个 1 一个 2 两个 1 ” ，记作 111221
 *
 * @Author: Hr_Ending
 * @Date: 2020/8/14 21:09
 */
public class CountAndSay {
    public String countAndSay(int n) {
        StringBuilder s = new StringBuilder();
        if (n == 1) {
            return "1";
        }
        int p1 = 0;
        int cur = 1;
        String str = countAndSay(n - 1);
        for (; cur < str.length(); cur++) {
            // 如果碰到当前字符与前面紧邻的字符不等则更新此次结果
            if (str.charAt(p1) != str.charAt(cur)) {
                int count = cur - p1;
                s.append(count).append(str.charAt(p1));
                p1 = cur;
            }
        }
        // 防止最后一段数相等，如果不等说明p1到cur-1这段字符串是相等的
        if (p1 != cur) {
            int count = cur - p1;
            s.append(count).append(str.charAt(p1));
        }
        return s.toString();
    }
}
