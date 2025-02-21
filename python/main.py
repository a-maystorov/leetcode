from two_sum import TwoSum

def test_two_sum():
    # Create instance of Solution class
    two_sum = TwoSum()
    
    # Test cases
    test_cases = [
        ([2, 7, 11, 15], 9),    # Expected: [0, 1]
        ([3, 2, 4], 6),        # Expected: [1, 2]
        ([3, 3], 6),          # Expected: [0, 1]
    ]
    
    # Run tests
    for nums, target in test_cases:
        result = two_sum.solution(nums, target)
        print(f"Input: nums = {nums}, target = {target}")
        print(f"Output: {result}\n")

if __name__ == "__main__":
    test_two_sum()