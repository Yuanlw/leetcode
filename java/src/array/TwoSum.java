package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to
 * target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * You can return the answer in any order.
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/two-sum 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 题的意思是：给出一个int数组和目标值，计算出数组两数相加等于目标值，返回出数组数值的索引值。
 *
 * @Author yuanlw
 **/
public class TwoSum {

    /**
     * 第一种解法，依旧简单粗暴
     * <p>
     * 效率最低，大脑直出。
     *
     * @return
     */
    int[] solution1(int[] nums, int target) {
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    /**
     * 需要些技巧，借助hash
     * <p>
     * 利用 target 减某个值，等于数组中的值。
     * <p>
     * 关键是下标怎么处理：利用map,把值和下标对应起来。
     * <p>
     *
     * @param nums
     * @param target
     * @return
     */
    int[] solution2(int[] nums, int target) {
        Map<Integer, Integer> table = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (table.containsKey(target - nums[i])) {
                return new int[]{table.get(target - nums[i]), i};
            }
            table.put(nums[i], i);
        }
        return new int[]{};
    }
}
