from typing import List

class TwoSum:
    def solution(self, nums: List[int], target: int) -> List[int]:
        """
        Finds the indices of two numbers in an array that add up to a target value.

        Given an array of integers nums and an integer target, this method returns
        the indices of the two numbers that sum up to the target. The solution assumes 
        each input has exactly one valid answer, and the same element cannot be used twice. 
        The indices can be returned in any order.

        Examples:
            1. Input: nums = [2,7,11,15], target = 9
               Output: [0,1]
               Explanation: nums[0] + nums[1] = 2 + 7 = 9
            
            2. Input: nums = [3,2,4], target = 6
               Output: [1,2]
               Explanation: nums[1] + nums[2] = 2 + 4 = 6
            
            3. Input: nums = [3,3], target = 6
               Output: [0,1]
               Explanation: nums[0] + nums[1] = 3 + 3 = 6

        Args:
            nums (List[int]): array of integers to search through
            target (int): sum value to find

        Returns:
            List[int]: array containing two indices whose corresponding values sum to target

        Constraints:
            - Array length: 2 <= nums.length <= 10^4
            - Element range: -10^9 <= nums[i] <= 10^9
            - Target range: -10^9 <= target <= 10^9
            - Only one valid solution exists

        Note:
            Follow-up: Consider optimizing for time complexity better than O(n^2)
        """
        for i in range(0, len(nums)):
            for j in range(i + 1, len(nums)):
                if nums[i] + nums[j] == target:
                    return [i, j]
        return []
    
    # Test cases
if __name__ == "__main__":
    ts = TwoSum()
    
    # Test case 1
    result1 = ts.solution([2, 7, 11, 15], 9)
    print(f"Test 1: {result1}")  # Expected: [0, 1]
    
    # Test case 2
    result2 = ts.solution([3, 2, 4], 6)
    print(f"Test 2: {result2}")  # Expected: [1, 2]
    
    # Test case 3
    result3 = ts.solution([3, 3], 6)
    print(f"Test 3: {result3}")  # Expected: [0, 1]