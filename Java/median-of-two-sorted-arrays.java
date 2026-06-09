/**
 * Problem: Median of Two Sorted Arrays (Issue #359)
    * 
    * Given two sorted arrays nums1 and nums2 of size m and n respectively,
    * return the median of the two sorted arrays.
    * The overall run time complexity should be O(log(min(n, m))).
    *
    * Approach: Binary search on the smaller array to find the correct partition
    * such that the left half of both arrays combined has exactly (m+n)/2 elements,
    * and all elements on the left are <= all elements on the right.
    *
    * Time Complexity:  O(log(min(m, n)))
    * Space Complexity: O(1)
    *
    * Test Cases:
  * nums1 = [1, 3], nums2 = [2]                -> 2.0
    * nums1 = [1, 2], nums2 = [3, 4]             -> 2.5
    * nums1 = [],     nums2 = [1]                -> 1.0
    * nums1 = [0, 0], nums2 = [0, 0]             -> 0.0
    * nums1 = [1, 3], nums2 = [2, 4]             -> 2.5
    */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
              // Ensure nums1 is the smaller array for binary search efficiency
          if (nums1.length > nums2.length) {
                        return findMedianSortedArrays(nums2, nums1);
          }

          int m = nums1.length;
              int n = nums2.length;
              int low = 0, high = m;

          while (low <= high) {
                        // Partition nums1 at mid1, and nums2 at mid2
                  int mid1 = (low + high) / 2;
                        int mid2 = (m + n + 1) / 2 - mid1;

                  // Edge values: use INT_MIN/INT_MAX for out-of-bound partitions
                  int maxLeft1  = (mid1 == 0) ? Integer.MIN_VALUE : nums1[mid1 - 1];
                        int minRight1 = (mid1 == m) ? Integer.MAX_VALUE : nums1[mid1];
                        int maxLeft2  = (mid2 == 0) ? Integer.MIN_VALUE : nums2[mid2 - 1];
                        int minRight2 = (mid2 == n) ? Integer.MAX_VALUE : nums2[mid2];

                  if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                                    // Correct partition found
                            if ((m + n) % 2 == 1) {
                                                  // Odd total length: median is the max of left halves
                                        return Math.max(maxLeft1, maxLeft2);
                            } else {
                                                  // Even total length: median is average of max-left and min-right
                                        return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                            }
                  } else if (maxLeft1 > minRight2) {
                                    // Move partition in nums1 to the left
                            high = mid1 - 1;
                  } else {
                                    // Move partition in nums1 to the right
                            low = mid1 + 1;
                  }
          }

          throw new IllegalArgumentException("Input arrays are not sorted.");
    }

    // Driver code for manual testing
    public static void main(String[] args) {
              MedianOfTwoSortedArrays solution = new MedianOfTwoSortedArrays();

          // Test case 1: Expected 2.0
          System.out.println(solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));

          // Test case 2: Expected 2.5
          System.out.println(solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));

          // Test case 3: Single element, Expected 1.0
          System.out.println(solution.findMedianSortedArrays(new int[]{}, new int[]{1}));

          // Test case 4: All zeros, Expected 0.0
          System.out.println(solution.findMedianSortedArrays(new int[]{0, 0}, new int[]{0, 0}));
    }
}
