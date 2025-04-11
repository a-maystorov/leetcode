import java.util.HashMap;

/**
 * 169. Majority Element
 *
 * Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 *
 * Examples:
 * 
 * 1. Input: nums = [3, 2, 3]
 * Output: 3
 * 
 * 2. Input: nums = [2, 2, 1, 1, 1, 2, 2]
 * Output: 2
 *
 * Constraints:
 * - n == nums.length
 * - 1 <= n <= 5 * 10^4
 * - -10^9 <= nums[i] <= 10^9
 *
 * Follow up: Could you solve the problem in linear time and in O(1) space?
 *
 * @param nums the array of integers
 * @return the majority element (the one that appears more than n / 2 times)
 */

class MajorityElement {
    public static int solution(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int majorityCount = nums.length / 2;

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        int majorityElement = 0;
        for (int key : map.keySet()) {
            if (map.get(key) > majorityCount) {
                majorityElement = key;
                break;
            }
        }

        return majorityElement;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 3, 4, 2, 4, 4, 2, 4, 4 };
        int majorityElement = solution(nums);
        System.out.println("The majority element is: " + majorityElement);
    }
}