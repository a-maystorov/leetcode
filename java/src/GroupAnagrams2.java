import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 49. Group Anagrams
 *
 * Groups a list of strings into anagram groups.
 *
 * Given an array of strings, this method returns a list of groups,
 * where each group contains words that are anagrams of each other.
 * An anagram is a word formed by rearranging the letters of another,
 * using all original letters exactly once.
 *
 * Examples:
 * 1. Input: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * Output: [["eat", "tea", "ate"], ["tan", "nat"], ["bat"]]
 *
 * 2. Input: strs = [""]
 * Output: [[""]]
 *
 * 3. Input: strs = ["a"]
 * Output: [["a"]]
 *
 * Constraints:
 * - 1 <= strs.length <= 10^4
 * - 0 <= strs[i].length <= 100
 * - strs[i] consists of lowercase English letters
 *
 * Approach:
 * - For each word, sort its characters to generate a canonical key
 * - Use a HashMap to group all words with the same sorted key
 * - Return the grouped values as a list of lists
 *
 * Time complexity: O(n * k log k) — n is number of words, k is max word length
 * Space complexity: O(n * k) — for storing the grouped anagrams
 *
 * @param strs array of input strings
 * @return list of grouped anagram lists
 */
class GroupAnagrams2 {
    public static List<List<String>> solution(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] input = { "eat", "tea", "tan", "ate", "nat", "bat" };
        List<List<String>> output = solution(input);
        System.out.println(output);
    }
}
