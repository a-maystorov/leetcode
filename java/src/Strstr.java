/**
 * 28. Find the Index of the First Occurrence in a String
 *
 * Implement strStr() function that returns the index of the first occurrence of
 * needle in haystack, or -1 if needle is not part of haystack.
 *
 * For clarity, return 0 when needle is an empty string, as per the problem's
 * convention
 * that an empty needle occurs at the start of any string.
 *
 * Examples:
 * 
 * 1. Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Explanation: The first occurrence of "ll" starts at index 2 in "hello".
 * 
 * 2. Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Explanation: "bba" does not occur in "aaaaa".
 *
 * 3. Input: haystack = "leetcode", needle = "leeto"
 * Output: -1
 * Explanation: "leeto" does not occur in "leetcode".
 *
 * Constraints:
 * - 1 <= haystack.length, needle.length <= 10^4
 * - haystack and needle consist of only lowercase English characters.
 *
 * This implementation uses a character-by-character comparison approach with a
 * sliding window
 * to efficiently find the needle string within the haystack without using
 * built-in string
 * matching functions.
 */
class Strstr {
    /**
     * Main function to find the index of the first occurrence of needle in haystack
     * 
     * This implementation follows a sliding window approach with an explicit
     * character-by-character
     * comparison rather than using built-in string methods like indexOf() or
     * substring().
     * 
     * @param haystack the string to search within
     * @param needle   the string to search for
     * @return the index of the first occurrence of needle in haystack, or -1 if not
     *         found
     */
    public static int solution(String haystack, String needle) {
        // Edge case 1: By convention, an empty needle is found at position 0
        if (needle.isEmpty())
            return 0;

        // Edge case 2: If needle is longer than haystack, it can't possibly be
        // contained within
        if (needle.length() > haystack.length())
            return -1;

        // The main search loop - we only need to check positions up to the point where
        // the remaining characters in haystack are at least as many as in needle
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            boolean found = true;

            // For each potential starting position, compare all characters in the needle
            // with the corresponding characters in the haystack
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    // As soon as we find a mismatch, mark this position as not matching
                    // and break out of the inner loop to try the next position
                    found = false;
                    break;
                }
            }

            // If we completed the inner loop without finding any mismatches,
            // we've found the needle at the current position
            if (found)
                return i;
        }

        // If we've checked all possible positions and found no match, return -1
        return -1;
    }

    /**
     * Main method to test the solution with example cases
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println(solution("leetcode", "leeto")); // Should print -1
        System.out.println(solution("hello", "ll")); // Should print 2
        System.out.println(solution("aaaaa", "bba")); // Should print -1
    }
}