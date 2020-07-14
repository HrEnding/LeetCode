package algorithm;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母
 *
 * @author Hr_Ending
 */
public class LetterCombinations {
    private static final String[] LETTER_MAP = {
            //0
            " ",
            //1
            "",
            //2
            "abc",
            //3
            "def",
            //4
            "ghi",
            //5
            "jkl",
            //6
            "mno",
            //7
            "pqrs",
            //8
            "tuv",
            //9
            "wxyz"
    };

    private ArrayList<String> res;

    public List<String> letterCombinations(String digits) {

        res = new ArrayList<String>();
        if (StringUtils.isEmpty(digits)) {
            return res;
        }

        findCombination(digits, 0, "");
        return res;
    }

    private void findCombination(String digits, int index, String s) {

        if (index == digits.length()) {
            res.add(s);
            return;
        }

        char c = digits.charAt(index);
        String letters = LETTER_MAP[c - '0'];
        for (int i = 0; i < letters.length(); i++) {
            findCombination(digits, index + 1, s + letters.charAt(i));
        }
    }

}
