public class KadanesAlgorithm {

    /**
     * Kadane's Algorithm to find the maximum sum of a contiguous subarray.
     * Problem (saloni-jaiswal-dev#358)
     *
     * Time Complexity:  O(n)
     * Space Complexity: O(1)
     *
     * Test Cases:
     * Input: [-2, 1, -3, 4, -1, 2, 1, -5, 4]  Expected: 6
     * Input: [1]                                Expected: 1
     * Input: [5, 4, -1, 7, 8]                  Expected: 23
     * Input: [-1, -2, -3, -4]                  Expected: -1
     */
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Input array must not be null or empty.");
        }
        int maxSoFar = nums[0];
        int currentMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            maxSoFar = Math.max(maxSoFar, currentMax);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Test 1: " + maxSubArray(nums1)); // 6
        int[] nums2 = {1};
        System.out.println("Test 2: " + maxSubArray(nums2)); // 1
        int[] nums3 = {5, 4, -1, 7, 8};
        System.out.println("Test 3: " + maxSubArray(nums3)); // 23
        int[] nums4 = {-1, -2, -3, -4};
        System.out.println("Test 4: " + maxSubArray(nums4)); // -1
    }
}
