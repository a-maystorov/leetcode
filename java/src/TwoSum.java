import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 * 
 * Finds the indices of two numbers in an array that add up to a target value.
 * 
 * Given an array of integers nums and an integer target, this method returns
 * the indices of the two numbers that sum up to the target. The solution
 * assumes each input
 * has exactly one valid answer, and the same element cannot be used twice. The
 * indices can be returned in any order.
 *
 * Examples:
 * 1. Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: nums[0] + nums[1] = 2 + 7 = 9
 * 2. Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Explanation: nums[1] + nums[2] = 2 + 4 = 6
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
 * Follow-up: Optimized for O(n) time complexity using a HashMap.
 *
 * @param nums   array of integers to search through
 * @param target sum value to find
 * @return array containing two indices whose corresponding values sum to target
 * @throws IllegalArgumentException if constraints are violated or no solution
 *                                  exists
 */
public class TwoSum {
    public static int[] solution(int[] nums, int target) {
        if (nums == null || nums.length < 2 || nums.length > 10_000) {
            throw new IllegalArgumentException("Invalid array length: must be between 2 and 10^4");
        }

        if (target < -1_000_000_000 || target > 1_000_000_000) {
            throw new IllegalArgumentException("Target value out of bounds: must be between -10^9 and 10^9");
        }

        Map<Integer, Integer> hash = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < -1_000_000_000 || nums[i] > 1_000_000_000) {
                throw new IllegalArgumentException("Array value out of bounds: must be between -10^9 and 10^9");
            }

            int complement = target - nums[i];

            if (hash.containsKey(complement)) {
                return new int[] { hash.get(complement), i };
            }

            hash.put(nums[i], i);
        }

        throw new IllegalArgumentException("No valid solution exists");
    }

    public static void main(String[] args) {
        int[] nums1 = { 2, 7, 11, 15 };
        int[] result1 = solution(nums1, 9);
        System.out.println(Arrays.toString(result1)); // Expected: [0, 1]

        int[] nums2 = { 3, 2, 4 };
        int[] result2 = solution(nums2, 6);
        System.out.println(Arrays.toString(result2)); // Expected: [1, 2]

        int[] nums3 = { 3, 3 };
        int[] result3 = solution(nums3, 6);
        System.out.println(Arrays.toString(result3)); // Expected: [0, 1]
    }
}