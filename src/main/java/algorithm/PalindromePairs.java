package algorithm;

import java.util.*;

/**
 * 给定一组 互不相同 的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
 *
 * @Author: Hr_Ending
 * @Date: 2020/8/6 21:57
 */
public class PalindromePairs {
    /**
     * 存储反转后的字符
     */
    Map<String, Integer> indices = new HashMap<String, Integer>();

    public List<List<Integer>> palindromePairs(String[] words) {
        //将字符进行反转
        for (int i = 0; i < words.length; ++i) {
            indices.put(new StringBuffer(words[i]).reverse().toString(), i);
        }

        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int m = words[i].length();
            if (m == 0) {
                continue;
            }
            for (int j = 0; j <= m; j++) {
                if (isPalindrome(word, j, m - 1)) {
                    int leftId = findWord(word, 0, j - 1);
                    if (leftId != -1 && leftId != i) {
                        ret.add(Arrays.asList(i, leftId));
                    }
                }
                if (j != 0 && isPalindrome(word, 0, j - 1)) {
                    int rightId = findWord(word, j, m - 1);
                    if (rightId != -1 && rightId != i) {
                        ret.add(Arrays.asList(rightId, i));
                    }
                }
            }
        }
        return ret;
    }

    /**
     * 判断当前字符是否是回文
     *
     * @param s
     * @param left
     * @param right
     * @return
     */
    public boolean isPalindrome(String s, int left, int right) {
        int len = right - left + 1;
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(left + i) != s.charAt(right - i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 获取反转字符中对应的回文
     *
     * @param s
     * @param left
     * @param right
     * @return
     */
    public int findWord(String s, int left, int right) {
        return indices.getOrDefault(s.substring(left, right + 1), -1);
    }
}
