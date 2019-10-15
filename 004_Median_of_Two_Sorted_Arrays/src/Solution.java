import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (m > n) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
            int tmp1 = m;
            m = n;
            n = tmp1;
        }

        int iMin = 0;
        int iMax = m;
        int halfLen = (m+n+1)/2;

        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;

            if (i < iMax && nums2[j-1] > nums1[i]) {
                iMin = i+1;
            } else if (i > iMin && nums1[i-1] > nums2[j]) {
                iMax = i-1;
            } else {
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = nums2[j-1];
                } else if (j == 0) {
                    maxLeft = nums1[i-1];
                } else {
                    maxLeft = Math.max(nums1[i-1], nums2[j-1]);
                }
                if ((m+n) % 2 == 1)
                    return maxLeft;
                int minRight = 0;
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums2[j], nums1[i]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
