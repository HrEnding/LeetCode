package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * @author 21489
 */
public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>((int) (nums1.length / 0.75F + 1.0F));
        Map<Integer, Integer> map2 = new HashMap<>((int) (nums1.length / 0.75F + 1.0F));
        for (int i : nums1) {
            map1.put(i, map1.getOrDefault(i, 0) + 1);
        }
        for (int i : nums2) {
            map2.put(i, map2.getOrDefault(i, 0) + 1);
        }
        List<Integer> temp = new ArrayList<>();
        for (int key : map1.keySet()) {
            if (map2.containsKey(key)) {
                for (int i = 0; i < Math.min(map1.get(key), map2.get(key)); i++) {
                    temp.add(key);
                }
            }
        }
        int[] res = new int[temp.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = temp.get(i);
        }
        return res;

    }
}
