package algorithm;

import java.util.*;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * @Author: Hr_Ending
 * @Date: 2020/8/24 21:24
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hash = new HashMap<>(16);
        for (String str : strs) {
            char[] sArr = str.toCharArray();
            //排序
            Arrays.sort(sArr);
            //映射到 key
            String key = String.valueOf(sArr);
            //添加到对应的类中
            if (hash.containsKey(key)) {
                hash.get(key).add(str);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(str);
                hash.put(key, temp);
            }

        }
        return new ArrayList<>(hash.values());
    }
}
