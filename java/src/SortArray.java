/**
 * 912. Sort an Array
 *
 * Given an array of integers nums, sort the array in ascending order and return
 * it.
 * You must solve the problem without using any built-in functions in O(n log n)
 * time complexity
 * and with the smallest space complexity possible.
 *
 * Examples:
 * 
 * 1. Input: nums = [5,2,3,1]
 * Output: [1,2,3,5]
 * Explanation: After sorting the array, the positions of some numbers are not
 * changed (for example, 2 and 3),
 * while the positions of other numbers are changed (for example, 1 and 5).
 * 
 * 2. Input: nums = [5,1,1,2,0,0]
 * Output: [0,0,1,1,2,5]
 * Explanation: Note that the values of nums are not necessarily unique.
 *
 * Constraints:
 * - 1 <= nums.length <= 5 * 10^4
 * - -5 * 10^4 <= nums[i] <= 5 * 10^4
 *
 * This implementation uses the QuickSort algorithm with the middle element as
 * pivot
 * to efficiently sort the array in-place.
 */
class Solution {
    /**
     * Main entry point for sorting an array using QuickSort algorithm
     * 
     * @param nums the array to be sorted
     * @return the same array, now sorted in ascending order
     */
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    /**
     * Recursive QuickSort implementation that sorts a specified portion of the
     * array
     * 
     * The function works by:
     * 1. Selecting a pivot element from the array (in this case, the middle
     * element)
     * 2. Partitioning the array around the pivot (smaller elements before, larger
     * after)
     * 3. Recursively sorting the two resulting subarrays
     * 
     * @param nums the array being sorted
     * @param low  the starting index of the subarray to sort
     * @param high the ending index of the subarray to sort
     */
    private void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(nums, low, high);
            quickSort(nums, low, pivotIndex - 1);
            quickSort(nums, pivotIndex + 1, high);
        }
    }

    /**
     * Partitions the array around a pivot element (the middle element)
     * 
     * This implementation:
     * 1. Selects the middle element as pivot for better average performance
     * 2. Moves the pivot to the end temporarily to simplify the algorithm
     * 3. Reorganizes the array so elements smaller than the pivot come before it
     * 4. Places the pivot at its final correct position
     * 
     * @param nums the array to partition
     * @param low  the lower bound of the segment to partition
     * @param high the upper bound of the segment to partition
     * @return the final position of the pivot element
     */
    private int partition(int[] nums, int low, int high) {
        int mid = low + (high - low) / 2;
        swap(nums, mid, high);

        int pivot = nums[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (nums[j] <= pivot) {
                i++;
                swap(nums, i, j);
            }
        }

        swap(nums, i + 1, high);

        return i + 1;
    }

    /**
     * Swaps two elements in an array
     * 
     * @param nums the array containing the elements
     * @param i    the index of the first element
     * @param j    the index of the second element
     */
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}