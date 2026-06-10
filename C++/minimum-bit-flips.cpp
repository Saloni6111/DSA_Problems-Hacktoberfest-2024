/*
 * Problem: Minimum Bit Flips to Convert a Number
 *
 * Given two integers start and goal, return the minimum number of bit flips
 * to convert start to goal.
 *
 * A bit flip means selecting a bit in the number and flipping it (0 -> 1 or 1 -> 0).
 *
 * Approach: XOR of start and goal gives a number where each set bit (1)
 *           represents a position where start and goal differ.
 *           Counting the set bits in the XOR result gives the answer.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 *
 * Test Cases:
 *   Input: start = 10, goal = 7  -> Output: 3
 *   Explanation: 10 = 1010, 7 = 0111, XOR = 1101 (3 set bits -> 3 flips)
 *
 *   Input: start = 3, goal = 4   -> Output: 3
 *   Explanation: 3 = 011, 4 = 100, XOR = 111 (3 set bits -> 3 flips)
 *
 *   Input: start = 0, goal = 0   -> Output: 0
 *   Explanation: No bits differ, no flips needed.
 */

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int minBitFlips(int start, int goal) {
        // XOR gives 1 for every bit position where start and goal differ
        int xorResult = start ^ goal;

        // Count number of set bits (1s) in xorResult
        // Each set bit represents one required flip
        return __builtin_popcount(xorResult);
    }
};

int main() {
    Solution sol;

    // Test case 1: Expected output: 3
    cout << "Test 1 (start=10, goal=7): " << sol.minBitFlips(10, 7) << endl;

    // Test case 2: Expected output: 3
    cout << "Test 2 (start=3, goal=4): "  << sol.minBitFlips(3, 4)  << endl;

    // Test case 3: Expected output: 0
    cout << "Test 3 (start=0, goal=0): "  << sol.minBitFlips(0, 0)  << endl;

    // Test case 4: Expected output: 0
    cout << "Test 4 (start=7, goal=7): "  << sol.minBitFlips(7, 7)  << endl;

    // Test case 5: Expected output: 1
    cout << "Test 5 (start=1, goal=0): "  << sol.minBitFlips(1, 0)  << endl;

    return 0;
}
