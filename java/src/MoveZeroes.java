import java.util.Arrays;

/**
 * 283. Move Zeroes
 * Given an integer array nums, move all zeroes to the end of the array
 * while maintaining the relative order of the non-zero elements.
 *
 * Note: This must be done in-place without making a copy of the array.
 *
 * Example 1:
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 *
 * Example 2:
 * Input: nums = [0]
 * Output: [0]
 *
 * Constraints:
 * - 1 <= nums.length <= 10^4
 * - -2^31 <= nums[i] <= 2^31 - 1
 *
 * Follow-up:
 * Can you minimize the total number of operations performed?
 */

public class MoveZeroes {
    static void solution(int[] nums) {
        int lastNonZeroIndex = 0;

        // Move non-zero elements to the front
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroIndex] = nums[i];
                if (lastNonZeroIndex != i) {
                    nums[i] = 0; // Set the current index to 0
                }
                lastNonZeroIndex++;
            }
        }

        System.out.println(Arrays.toString(nums));
    }
}
