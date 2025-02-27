/**
 * 1. Two Sum
 * 
 * Finds the indices of two numbers in an array that add up to a target value.
 * 
 * Given an array of integers nums and an integer target, this method returns
 * the indices
 * of the two numbers that sum up to the target. The solution assumes each input
 * has
 * exactly one valid answer, and the same element cannot be used twice. The
 * indices
 * can be returned in any order.
 *
 * Examples:
 * 1. Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: nums[0] + nums[1] = 2 + 7 = 9
 * 
 * 2. Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Explanation: nums[1] + nums[2] = 2 + 4 = 6
 * 
 * 3. Input: nums = [3,3], target = 6
 * Output: [0,1]
 * Explanation: nums[0] + nums[1] = 3 + 3 = 6
 *
 * Constraints:
 * - Array length: 2 <= nums.length <= 10^4
 * - Element range: -10^9 <= nums[i] <= 10^9
 * - Target range: -10^9 <= target <= 10^9
 * - Only one valid solution exists
 *
 * Follow-up: Consider optimizing for time complexity better than O(n^2)
 *
 * @param nums   array of integers to search through
 * @param target sum value to find
 * @return array containing two indices whose corresponding values sum to target
 */

public class TwoSum {
    public static int[] solution(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] {};
    }
}
