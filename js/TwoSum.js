/**
 * Class containing a method to find the indices of two numbers in an array that sum to a target value.
 */
class TwoSum {
  /**
   * 1. Two Sum
   *
   * Finds the indices of two numbers in an array that add up to a target value.
   *
   * @param {number[]} nums - Array of integers to search through.
   * @param {number} target - Target sum value to find.
   * @returns {number[]} - Array containing two indices whose corresponding values sum to the target.
   * @throws {Error} If no valid solution exists.
   *
   * @example
   * TwoSum.solution([2, 7, 11, 15], 9); // Output: [0, 1]
   *
   * @example
   * TwoSum.solution([3, 2, 4], 6); // Output: [1, 2]
   *
   * @example
   * TwoSum.solution([3, 3], 6); // Output: [0, 1]
   *
   * @note Constraints:
   * - `2 <= nums.length <= 10^4`
   * - `-10^9 <= nums[i] <= 10^9`
   * - `-10^9 <= target <= 10^9`
   * - Only one valid solution exists.
   */
  static solution(nums, target) {
    if (!Array.isArray(nums) || nums.length < 2 || nums.length > 10e4) {
      throw new Error("Invalid array length");
    }

    if (target < -10e9 || target > 10e9) {
      throw new Error("Target value out of bounds");
    }

    const hash = new Map();

    for (let i = 0; i < nums.length; i++) {
      if (nums[i] < -10e9 || nums[i] > 10e9) {
        throw new Error("Array value out of bounds");
      }

      const complement = target - nums[i];

      if (hash.has(complement)) {
        return [hash.get(complement), i];
      }

      hash.set(nums[i], i);
    }

    throw new Error("No valid solution exists");
  }
}

// Test cases
console.log("Test 1:", TwoSum.solution([2, 7, 11, 15], 9)); // Expected: [0, 1]
console.log("Test 2:", TwoSum.solution([3, 2, 4], 6)); // Expected: [1, 2]
console.log("Test 3:", TwoSum.solution([3, 3], 6)); // Expected: [0, 1]
