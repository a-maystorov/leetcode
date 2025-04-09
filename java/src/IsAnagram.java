import java.util.Arrays;

/**
 * 242. Valid Anagram
 * 
 * Determines if string t is an anagram of string s.
 * 
 * Given two strings s and t, this method returns true if t is an anagram of s,
 * and false otherwise. An anagram is a word or phrase formed by rearranging the
 * letters of another, typically using all the original letters exactly once.
 *
 * Examples:
 * 1. Input: s = "anagram", t = "nagaram"
 * Output: true
 * Explanation: "nagaram" can be rearranged to form "anagram" using all letters
 * exactly once.
 * 
 * 2. Input: s = "rat", t = "car"
 * Output: false
 * Explanation: "car" cannot be rearranged to form "rat" as they contain
 * different letters.
 *
 * Constraints:
 * - String lengths: 1 <= s.length, t.length <= 5 * 10^4
 * - Characters: s and t consist of lowercase English letters
 *
 * Follow up: For Unicode characters, the solution could be adapted by using a
 * HashMap<Character, Integer> instead of sorting, tracking character
 * frequencies
 * across the full Unicode range.
 *
 * @param s first string to compare
 * @param t second string to compare
 * @return true if t is an anagram of s, false otherwise
 */
public class IsAnagram {
    public static boolean solution(String s, String t) {
        char[] sChars = s.toLowerCase().toCharArray();
        char[] tChars = t.toLowerCase().toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return Arrays.equals(sChars, tChars);
    }

    public static void main(String[] args) {
        System.out.println(solution("anagram", "nagaram")); // true
        System.out.println(solution("rat", "car")); // false
    }
}