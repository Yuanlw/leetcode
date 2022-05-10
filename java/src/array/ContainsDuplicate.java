package array;

/**
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every
 * element is distinct.
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
}
