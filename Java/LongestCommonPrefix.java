/**
 * Longest Common Prefix
    * 
    * Problem: Write a function to find the longest common prefix string
    * amongst an array of strings. If there is no common prefix, return "".
    * 
    * Approach: Horizontal scanning - compare prefix with each string
    * Time Complexity: O(S) where S = sum of all characters in all strings
    * Space Complexity: O(1)
    */
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
              if (strs == null || strs.length == 0) {
                            return "";
              }

          // Start with the first string as the initial prefix
          String prefix = strs[0];

          for (int i = 1; i < strs.length; i++) {
                        // Reduce the prefix until it matches the start of strs[i]
                  while (!strs[i].startsWith(prefix)) {
                                    prefix = prefix.substring(0, prefix.length() - 1);
                                    if (prefix.isEmpty()) {
                                                          return "";
                                    }
                  }
          }

          return prefix;
    }

    public static void main(String[] args) {
              // Test Case 1: Common prefix "fl"
          String[] strs1 = {"flower", "flow", "flight"};
              System.out.println("Test 1: " + longestCommonPrefix(strs1)); // Expected: "fl"

          // Test Case 2: No common prefix
          String[] strs2 = {"dog", "racecar", "car"};
              System.out.println("Test 2: " + longestCommonPrefix(strs2)); // Expected: ""

          // Test Case 3: All strings are the same
          String[] strs3 = {"abc", "abc", "abc"};
              System.out.println("Test 3: " + longestCommonPrefix(strs3)); // Expected: "abc"

          // Test Case 4: Single string
          String[] strs4 = {"alone"};
              System.out.println("Test 4: " + longestCommonPrefix(strs4)); // Expected: "alone"

          // Test Case 5: Empty string in array
          String[] strs5 = {"", "b"};
              System.out.println("Test 5: " + longestCommonPrefix(strs5)); // Expected: ""
    }
}
