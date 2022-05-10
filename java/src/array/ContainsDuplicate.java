package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every
 * element is distinct.
 * <p>
 * 解题思路总结： 熟悉数组、Hash相关的特性是解决数组问题的关键
 *
 * @Author yuanlw
 **/
public class ContainsDuplicate {

    /**
     * 暴利破解
     *
     * @param nums
     * @return
     */
    boolean solution1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= nums.length - 1; j++) {
                if (nums[i] == nums[j]) {
                    return Boolean.TRUE;
                }
            }
        }
        return Boolean.FALSE;
    }

    /**
     * 排序后，相邻数值对比
     *
     * @param nums
     * @return
     */
    boolean solution2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    /**
     * 利用哈希的不可重复性，来处理，
     *
     * @param nums
     * @return
     */
    boolean solution3(int[] nums) {
        Set<Integer> hash = new HashSet<>();
        for (int i : nums) {
            if (!hash.add(i)) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }
}
