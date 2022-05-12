package string;

import java.util.*;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * <p>
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all
 * the original letters exactly once.
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/group-anagrams 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 字符串 相同字符的升级版
 * <p>
 * 给出一个字符串数组，缩写分组，意思就是把含有相同字符的字符串放在一个数组中，返回一个大数组中套分组的小数组。
 *
 * @Author yuanlw
 **/
public class GroupAnagrams {

    /**
     * 排序法
     * <p>
     * 利用 map和list 处理巧妙
     *
     * @param strs
     * @return
     */
    List<List<String>> solution1(String[] strs) {
        Map<String, ArrayList<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] ss = str.toCharArray();
            Arrays.sort(ss);
            String key = new String(ss);
            ArrayList<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

    /**
     * 计算法
     * <p>
     * 太复杂，我写不出来
     *
     * @param strs
     * @return
     */
    List<List<String>> solution2(String[] strs) {
        Map<String, ArrayList<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] counts = new int[26];
            int size = strs.length;
            for (int i = 0; i < size; i++) {
                counts[str.charAt(i) - 'a']++;
            }
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    sb.append('a' + i);
                    sb.append(counts[i]);
                }
            }
            String key = sb.toString();
            ArrayList<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
