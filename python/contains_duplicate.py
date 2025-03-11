from typing import List, Set, Dict, Any, Tuple, Union
import time
import unittest


class ContainsDuplicate:
    """
    Class providing solutions for the 'Contains Duplicate' problem (LeetCode #217).
    
    This class implements methods to determine if an array contains any duplicate values.
    """
    
    @staticmethod
    def solution(nums: List[int]) -> bool:
        """
        Checks if an array contains any duplicate values.

        Given an integer array nums, this method returns true if any value appears
        at least twice in the array, and false if every element is distinct.

        Args:
            nums (List[int]): Array of integers to check for duplicates

        Returns:
            bool: True if there are duplicates, false if all elements are unique

        Raises:
            TypeError: If input is not a list or contains non-integer values
            ValueError: If array length or values are outside constraints

        Examples:
            >>> ContainsDuplicate.solution([1, 2, 3, 1])
            True
            >>> ContainsDuplicate.solution([1, 2, 3, 4])
            False
            >>> ContainsDuplicate.solution([1, 1, 1, 3, 3, 4, 3, 2, 4, 2])
            True

        Time Complexity: 
            O(n) where n is the length of the input array
            
        Space Complexity: 
            O(n) in the worst case where all elements are unique
            
        Constraints:
            - Array length: 1 <= nums.length <= 10^5
            - Element range: -10^9 <= nums[i] <= 10^9
        """
        # Input type validation
        if not isinstance(nums, list):
            raise TypeError(f"Input must be a list, got {type(nums).__name__}")
        
        # Length validation
        if not nums:
            raise ValueError("Array cannot be empty")
        if len(nums) > 10**5:
            raise ValueError(f"Array length must be at most 10^5, got {len(nums)}")
            
        # Element validation
        for num in nums:
            if not isinstance(num, int):
                raise TypeError(f"All elements must be integers, got {type(num).__name__}: {num}")
            if num < -(10**9) or num > 10**9:
                raise ValueError(f"Elements must be between -10^9 and 10^9, got {num}")
        
        # Main algorithm using a set for O(n) time complexity
        seen: Set[int] = set()
        
        for num in nums:
            # If we've seen this number before, we found a duplicate
            if num in seen:
                return True
            seen.add(num)
            
        # No duplicates found
        return False
    
    @staticmethod
    def solution_alternative(nums: List[int]) -> bool:
        """
        Alternative solution using set length comparison.
        
        This approach creates a set from the entire list at once and compares sizes.
        If the set size is smaller than the list size, duplicates exist.
        
        Args:
            nums (List[int]): Array of integers to check for duplicates
            
        Returns:
            bool: True if there are duplicates, false if all elements are unique
            
        Note:
            This method doesn't perform validation to show the algorithm clearly.
            In production, the same validation as the main solution should be applied.
        """
        # The same validation would be needed here (omitted for brevity)
        
        # If the set size is less than the list length, there must be duplicates
        return len(set(nums)) < len(nums)


def run_tests() -> Dict[str, int]:
    """
    Runs a comprehensive set of tests for the ContainsDuplicate class.
    
    Returns:
        Dict[str, int]: Dictionary containing test statistics
    """
    # Test statistics
    stats = {
        "total": 0,
        "passed": 0,
        "failed": 0,
        "errors": 0
    }
    
    # Helper function to run a test and update statistics
    def run_test(test_fn, desc: str) -> bool:
        stats["total"] += 1
        try:
            passed = test_fn()
            if passed:
                stats["passed"] += 1
                print(f"✅ {desc}: PASSED")
            else:
                stats["failed"] += 1
                print(f"❌ {desc}: FAILED")
            return passed
        except Exception as e:
            stats["errors"] += 1
            print(f"⚠️ {desc}: ERROR - {str(e)}")
            return False
    
    # Standard test cases
    test_cases = [
        {
            "nums": [1, 2, 3, 1],
            "expected": True,
            "desc": "Standard case with duplicate"
        },
        {
            "nums": [1, 2, 3, 4],
            "expected": False,
            "desc": "Standard case no duplicates"
        },
        {
            "nums": [1, 1, 1, 3, 3, 4, 3, 2, 4, 2],
            "expected": True,
            "desc": "Multiple duplicates"
        },
        # Edge cases
        {
            "nums": [1],
            "expected": False,
            "desc": "Minimum length array (1)"
        },
        {
            "nums": [0, 0],
            "expected": True,
            "desc": "Small array with duplicate zeros"
        },
        {
            "nums": [-(10**9), 10**9],
            "expected": False,
            "desc": "Boundary values"
        },
        {
            "nums": [-(10**9), -(10**9)],
            "expected": True,
            "desc": "Boundary value duplicates"
        },
        # Additional cases
        {
            "nums": list(range(10000)),  # Smaller than max for reasonable test time
            "expected": False,
            "desc": "Large array with no duplicates"
        },
        {
            "nums": [i % 100 for i in range(1000)],
            "expected": True,
            "desc": "Large array with many duplicates"
        }
    ]
    
    # Error test cases
    error_cases = [
        {
            "nums": [],
            "error": ValueError,
            "desc": "Empty array (below minimum length)"
        },
        {
            "nums": "not a list",
            "error": TypeError,
            "desc": "Invalid input type"
        },
        {
            "nums": [1, 2, 10**9 + 1],
            "error": ValueError,
            "desc": "Value above maximum"
        },
        {
            "nums": [1, 2, -(10**9) - 1],
            "error": ValueError,
            "desc": "Value below minimum"
        },
        {
            "nums": [1, 2.5, 3],
            "error": TypeError,
            "desc": "Non-integer value"
        },
        {
            "nums": [1] * (10**5 + 1),
            "error": ValueError,
            "desc": "Array length exceeds maximum"
        }
    ]
    
    cd = ContainsDuplicate()
    
    print("=== STANDARD TESTS ===")
    # Run standard test cases
    for test in test_cases:
        run_test(
            lambda: cd.solution(test["nums"]) == test["expected"],
            f"{test['desc']}"
        )
        
        # Also test the alternative solution
        run_test(
            lambda: cd.solution_alternative(test["nums"]) == test["expected"],
            f"{test['desc']} (alternative solution)"
        )
    
    print("\n=== ERROR TESTS ===")
    # Run error test cases
    for test in error_cases:
        def error_test_wrapper(test_case=test):
            try:
                cd.solution(test_case["nums"])
                print(f"  Should have thrown {test_case['error'].__name__}")
                return False
            except Exception as e:
                return isinstance(e, test_case["error"])
        
        run_test(
            error_test_wrapper,
            test["desc"]
        )
    
    print("\n=== PERFORMANCE TESTS ===")
    # Performance tests
    large_array = list(range(10**5))  # Maximum array size
    large_array_with_duplicate = large_array.copy()
    large_array_with_duplicate[-1] = 0  # Add duplicate at the end
    
    # Test with smaller arrays for benchmarking
    medium_array = list(range(10**4))
    medium_array_with_duplicate = medium_array.copy()
    medium_array_with_duplicate[-1] = 0
    
    def performance_test():
        # Test medium arrays first
        start = time.time()
        result1 = cd.solution(medium_array)
        end = time.time()
        print(f"Original implementation (medium, no duplicates): {(end - start)*1000:.2f}ms")
        
        start = time.time()
        result2 = cd.solution_alternative(medium_array)
        end = time.time()
        print(f"Alternative implementation (medium, no duplicates): {(end - start)*1000:.2f}ms")
        
        start = time.time()
        result3 = cd.solution(medium_array_with_duplicate)
        end = time.time()
        print(f"Original implementation (medium, with duplicate): {(end - start)*1000:.2f}ms")
        
        start = time.time()
        result4 = cd.solution_alternative(medium_array_with_duplicate)
        end = time.time()
        print(f"Alternative implementation (medium, with duplicate): {(end - start)*1000:.2f}ms")
        
        # Test large arrays
        print("\nLarge array tests:")
        start = time.time()
        result5 = cd.solution(large_array[:1000])  # Sample first 1000 elements
        end = time.time()
        print(f"Original implementation (large sample, no duplicates): {(end - start)*1000:.2f}ms")
        
        start = time.time()
        result6 = cd.solution_alternative(large_array[:1000])
        end = time.time()
        print(f"Alternative implementation (large sample, no duplicates): {(end - start)*1000:.2f}ms")
        
        # Verify all results match expectations
        return (
            result1 == result2 == False and
            result3 == result4 == True and
            result5 == result6 == False
        )
    
    run_test(performance_test, "Performance comparisons")
    
    # Print test summary
    print("\n=== TEST SUMMARY ===")
    print(f"Total: {stats['total']}, Passed: {stats['passed']}, Failed: {stats['failed']}, Errors: {stats['errors']}")
    print(f"Success rate: {((stats['passed'] / stats['total']) * 100):.2f}%")
    
    return stats


class ContainsDuplicateTests(unittest.TestCase):
    """Unit test class for ContainsDuplicate implementations."""
    
    def setUp(self):
        """Set up test cases."""
        self.cd = ContainsDuplicate()
        
    def test_standard_cases(self):
        """Test standard cases."""
        self.assertTrue(self.cd.solution([1, 2, 3, 1]))
        self.assertFalse(self.cd.solution([1, 2, 3, 4]))
        self.assertTrue(self.cd.solution([1, 1, 1, 3, 3, 4, 3, 2, 4, 2]))
        
    def test_edge_cases(self):
        """Test edge cases."""
        self.assertFalse(self.cd.solution([1]))
        self.assertTrue(self.cd.solution([0, 0]))
        self.assertFalse(self.cd.solution([-(10**9), 10**9]))
        self.assertTrue(self.cd.solution([-(10**9), -(10**9)]))
        
    def test_error_cases(self):
        """Test error cases."""
        with self.assertRaises(ValueError):
            self.cd.solution([])
        
        with self.assertRaises(TypeError):
            self.cd.solution("not a list")
            
        with self.assertRaises(ValueError):
            self.cd.solution([1, 2, 10**9 + 1])
            
        with self.assertRaises(ValueError):
            self.cd.solution([1, 2, -(10**9) - 1])
            
        with self.assertRaises(TypeError):
            self.cd.solution([1, 2.5, 3])
            
    def test_alternative_implementation(self):
        """Test alternative implementation."""
        test_cases = [
            ([1, 2, 3, 1], True),
            ([1, 2, 3, 4], False),
            ([1, 1, 1, 3, 3, 4, 3, 2, 4, 2], True),
            ([1], False),
            ([0, 0], True)
        ]
        
        for nums, expected in test_cases:
            with self.subTest(nums=nums):
                self.assertEqual(self.cd.solution_alternative(nums), expected)


if __name__ == "__main__":
    print("Running manual tests:")
    run_tests()
    
    print("\nRunning unittest framework tests:")
    unittest.main(argv=['first-arg-is-ignored'], exit=False)