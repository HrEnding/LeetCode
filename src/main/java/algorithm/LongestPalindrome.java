package algorithm;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * @Author: Hr_Ending
 * @Date: 2020/7/21 20:33
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s.length() < 2 || s.substring(0, 1).equals(s.substring(s.length() - 1))) {
            return s;
        }
        int maxLen = 0;
        String[] strings = new String[s.length()];
        char[] charArr = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            StringBuilder str = new StringBuilder().append(charArr[i]);
            int length = 1;
            for (int j = i + 1; j < s.length(); j++) {
                str.append(charArr[j]);
                length++;
                if (charArr[i] == charArr[j] && length > maxLen) {
                    maxLen = length;
                    strings[length] = str.toString();
                }
            }
        }
        return maxLen == 0 ? s.substring(0, 1) : strings[maxLen];
    }
}
