package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * <p>
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all
 * the original letters exactly once.
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/valid-anagram 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 意思就是给出两个字符串，判断两个字符串是否一样。
 * <p>
 * 此题的解题思路总结： 1.熟悉字符串相关 2.数组相关 3.hash相关
 *
 * @Author yuanlw
 **/
public class IsAnagram {

    /**
     * 1.先判断两个字符长度
     * <p>
     * 2.利用map 把字符，数量存储
     * <p>
     * 3.借助 map特性
     * <p>
     * 时间复杂度 相对于其他算法 比较差
     *
     * @param s
     * @param t
     * @return
     */
    boolean solution1(String s, String t) {
        if (s.length() != t.length()) {
            return Boolean.FALSE;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int j = 0; j < t.length(); j++) {
            char ch = t.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) - 1);
            if (map.get(ch) < 0) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    /**
     * 思路：字符排序，相比 性能最好
     *
     * @param s
     * @param t
     * @return
     */
    boolean solution2(String s, String t) {
        if (s.length() != t.length()) {
            return Boolean.FALSE;
        }
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(tt);

        return Arrays.equals(ss, tt);
    }

    /**
     * 思路：利用hash 26个字母 s加 t减 类似于第一种 这也是一种比较直观的算法 仅次于 最好的
     *
     * @param s
     * @param t
     * @return
     */
    boolean solution3(String s, String t) {
        if (s.length() != t.length()) {
            return Boolean.FALSE;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return Boolean.FALSE;
            }
        }

        return Boolean.TRUE;
    }
}
