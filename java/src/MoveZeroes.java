import java.util.Arrays;

/**
 * 283. Move Zeroes
 * 
 * Rearranges an integer array by moving all zeroes to the end while preserving
 * the relative order
 * of non-zero elements.
 * 
 * Given an integer array nums, this method shifts all zeroes to the end of the
 * array in-place,
 * maintaining the original order of non-zero elements. The operation must
 * modify the input array
 * directly without creating a copy.
 *
 * Examples:
 * 1. Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Explanation: Non-zero elements (1,3,12) retain their order, zeroes moved to
 * the end.
 * 
 * 2. Input: nums = [0]
 * Output: [0]
 * Explanation: Single-element array remains unchanged as it’s already a zero.
 *
 * Constraints:
 * - Array length: 1 <= nums.length <= 10^4
 * - Element range: -2^31 <= nums[i] <= 2^31 - 1
 *
 * Follow-up: Consider optimizing the solution to minimize the total number of
 * operations.
 *
 * @param nums integer array to be modified in-place
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
