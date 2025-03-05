/**
 * Class containing a method to find the indices of two numbers in an array that sum to a target value.
 */
class TwoSum {
  /**
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
    for (const i = 0; i < nums.length; i++) {
      for (const j = i + 1; j < nums.length; j++) {
        if (nums[j] + nums[i] === target) {
          return [i, j];
        }
      }
    }
    throw new Error("No valid solution exists");
  }
}

export default TwoSum;
