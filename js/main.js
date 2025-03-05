import TwoSum from "./TwoSum.js";

// Basic test case
console.log(TwoSum.solution([2, 7, 11, 15], 9));
// Expected output: [0, 1] (nums[0] + nums[1] = 2 + 7 = 9)

// Test case with numbers appearing later in the array
console.log(TwoSum.solution([3, 2, 4], 6));
// Expected output: [1, 2] (nums[1] + nums[2] = 2 + 4 = 6)

// Test case with duplicate numbers
console.log(TwoSum.solution([3, 3], 6));
// Expected output: [0, 1] (nums[0] + nums[1] = 3 + 3 = 6)

// Test case with negative numbers
console.log(TwoSum.solution([-1, -2, -3, -4, -5], -8));
// Expected output: [2, 4] (nums[2] + nums[4] = -3 + -5 = -8)

// Test case with larger numbers
console.log(TwoSum.solution([1000000000, 3, 5, -1000000000], 0));
// Expected output: [0, 3] (nums[0] + nums[3] = 1000000000 + (-1000000000) = 0)

// Edge case with minimum valid input size
console.log(TwoSum.solution([1, 2], 3));
// Expected output: [0, 1] (nums[0] + nums[1] = 1 + 2 = 3)
