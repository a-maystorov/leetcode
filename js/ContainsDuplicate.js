/**
 * Class containing a method to check if an array contains duplicate values.
 * Solution for LeetCode problem #217: Contains Duplicate.
 */
class ContainsDuplicate {
  /**
   * Checks if any value appears at least twice in the array.
   *
   * @param {number[]} nums - Array of integers to check for duplicates.
   * @returns {boolean} - True if there are duplicates, false if all elements are unique.
   * @throws {TypeError} If input is not an array or contains non-integer values.
   * @throws {RangeError} If array length or values are outside constraints.
   *
   * @example
   * ContainsDuplicate.solution([1, 2, 3, 1]); // Output: true
   * ContainsDuplicate.solution([1, 2, 3, 4]); // Output: false
   * ContainsDuplicate.solution([1, 1, 1, 3, 3, 4, 3, 2, 4, 2]); // Output: true
   *
   * Time Complexity: O(n) where n is the length of the input array
   * Space Complexity: O(n) in the worst case where all elements are unique
   *
   * @see https://leetcode.com/problems/contains-duplicate/
   */
  static solution(nums) {
    // Input validation
    if (!Array.isArray(nums)) {
      throw new TypeError("Input must be an array");
    }

    if (nums.length < 1 || nums.length > 1e5) {
      throw new RangeError(
        `Array length must be between 1 and 10^5, got ${nums.length}`
      );
    }

    // Optional validation (can be skipped for performance in trusted environments)
    for (const num of nums) {
      if (!Number.isInteger(num)) {
        throw new TypeError(`All elements must be integers, found: ${num}`);
      }

      if (num < -1e9 || num > 1e9) {
        throw new RangeError(
          `Elements must be between -10^9 and 10^9, found: ${num}`
        );
      }
    }

    // Using Set for O(n) time complexity solution
    const seen = new Set();

    for (const num of nums) {
      // If we've seen this number before, we found a duplicate
      if (seen.has(num)) {
        return true;
      }
      seen.add(num);
    }

    // No duplicates found
    return false;
  }

  /**
   * Alternative solution using Set size comparison.
   * More concise but creates the entire Set at once.
   *
   * @param {number[]} nums - Array of integers to check for duplicates.
   * @returns {boolean} - True if there are duplicates, false if all elements are unique.
   */
  static solutionAlternative(nums) {
    // Same validation would be needed here (omitted for brevity)

    // If the Set size is less than the array length, there must be duplicates
    return new Set(nums).size < nums.length;
  }
}

/**
 * Runs comprehensive tests for the ContainsDuplicate class.
 * Tests include standard cases, edge cases, and error cases.
 *
 * @returns {object} Object containing test results summary
 */
function runTests() {
  // Test statistics
  const stats = {
    total: 0,
    passed: 0,
    failed: 0,
    errors: 0,
  };

  /**
   * Helper function to run a test and update statistics
   */
  function runTest(testFn, desc) {
    stats.total++;
    try {
      const passed = testFn();
      if (passed) {
        stats.passed++;
        console.log(`✅ ${desc}: PASSED`);
      } else {
        stats.failed++;
        console.log(`❌ ${desc}: FAILED`);
      }
      return passed;
    } catch (error) {
      stats.errors++;
      console.log(`⚠️ ${desc}: ERROR - ${error.message}`);
      return false;
    }
  }

  // Standard test cases
  const testCases = [
    {
      nums: [1, 2, 3, 1],
      expected: true,
      desc: "Standard case with duplicate",
    },
    {
      nums: [1, 2, 3, 4],
      expected: false,
      desc: "Standard case no duplicates",
    },
    {
      nums: [1, 1, 1, 3, 3, 4, 3, 2, 4, 2],
      expected: true,
      desc: "Multiple duplicates",
    },
    // Edge cases
    {
      nums: [1],
      expected: false,
      desc: "Minimum length array (1)",
    },
    {
      nums: [0, 0],
      expected: true,
      desc: "Small array with duplicate zeros",
    },
    {
      nums: [-1e9, 1e9],
      expected: false,
      desc: "Boundary values",
    },
    {
      nums: [-1e9, -1e9],
      expected: true,
      desc: "Boundary value duplicates",
    },
    // Additional test cases
    {
      nums: Array.from({ length: 1e5 }, (_, i) => i),
      expected: false,
      desc: "Maximum length array with no duplicates",
    },
    {
      nums: Array.from({ length: 1e5 }, (_, i) => i % 1000),
      expected: true,
      desc: "Maximum length array with duplicates",
    },
  ];

  // Error test cases
  const errorCases = [
    {
      nums: [],
      error: RangeError,
      desc: "Empty array (below minimum length)",
    },
    {
      nums: "not an array",
      error: TypeError,
      desc: "Invalid input type",
    },
    {
      nums: [1, 2, 1e9 + 1],
      error: RangeError,
      desc: "Value above maximum",
    },
    {
      nums: [1, 2, -1e9 - 1],
      error: RangeError,
      desc: "Value below minimum",
    },
    {
      nums: [1, 2.5, 3],
      error: TypeError,
      desc: "Non-integer value",
    },
    {
      nums: Array.from({ length: 1e5 + 1 }, (_, i) => i),
      error: RangeError,
      desc: "Array length exceeds maximum",
    },
  ];

  console.log("=== STANDARD TESTS ===");
  // Run standard test cases
  testCases.forEach((test) => {
    runTest(() => {
      const result = ContainsDuplicate.solution(test.nums);
      const passed = result === test.expected;
      if (!passed) {
        console.log(`  Expected: ${test.expected}, Got: ${result}`);
      }
      return passed;
    }, test.desc);

    // Also test the alternative solution
    runTest(() => {
      const result = ContainsDuplicate.solutionAlternative(test.nums);
      const passed = result === test.expected;
      if (!passed) {
        console.log(
          `  Alternative solution - Expected: ${test.expected}, Got: ${result}`
        );
      }
      return passed;
    }, `${test.desc} (alternative solution)`);
  });

  console.log("\n=== ERROR TESTS ===");
  // Run error test cases
  errorCases.forEach((test) => {
    runTest(() => {
      try {
        ContainsDuplicate.solution(test.nums);
        console.log(`  Should have thrown ${test.error.name}`);
        return false;
      } catch (error) {
        return error instanceof test.error;
      }
    }, test.desc);
  });

  console.log("\n=== PERFORMANCE TESTS ===");
  // Performance comparison
  const largeArray = Array.from({ length: 1e5 }, (_, i) => i);
  const largeArrayWithDuplicate = [...largeArray];
  largeArrayWithDuplicate[largeArrayWithDuplicate.length - 1] = 0; // Add duplicate at the end

  runTest(() => {
    console.time("Original implementation (no duplicates)");
    const result1 = ContainsDuplicate.solution(largeArray);
    console.timeEnd("Original implementation (no duplicates)");

    console.time("Alternative implementation (no duplicates)");
    const result2 = ContainsDuplicate.solutionAlternative(largeArray);
    console.timeEnd("Alternative implementation (no duplicates)");

    console.time("Original implementation (with duplicate)");
    const result3 = ContainsDuplicate.solution(largeArrayWithDuplicate);
    console.timeEnd("Original implementation (with duplicate)");

    console.time("Alternative implementation (with duplicate)");
    const result4 = ContainsDuplicate.solutionAlternative(
      largeArrayWithDuplicate
    );
    console.timeEnd("Alternative implementation (with duplicate)");

    return result1 === result2 && result3 === result4;
  }, "Performance tests");

  // Print test summary
  console.log("\n=== TEST SUMMARY ===");
  console.log(
    `Total: ${stats.total}, Passed: ${stats.passed}, Failed: ${stats.failed}, Errors: ${stats.errors}`
  );
  console.log(
    `Success rate: ${((stats.passed / stats.total) * 100).toFixed(2)}%`
  );

  return stats;
}

// Detect if this file is being executed in a browser or Node.js environment
const isRunningDirectly =
  typeof window === "undefined" ||
  (window.process && window.process.argv.length > 0);

// Only run tests if this file is executed directly
if (isRunningDirectly) {
  console.log("Running ContainsDuplicate tests...");
  runTests();
}

// Export the class for use in other modules
export default ContainsDuplicate;
