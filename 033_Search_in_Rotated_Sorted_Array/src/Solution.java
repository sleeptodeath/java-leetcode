public class Solution {

    /*
    题意:
        是让你从一个递增序列按轴旋转过后寻找给定值，找到返回索引，找不到返回-1，
        要求时间复杂度位 O(logn)

        // 列举可得一半是排序的
        考虑二分排序
     */
//    public int search(int[] nums, int target) {
//        if (nums == null || nums.length == 0)
//            return -1;
//        int l = 0;
//        int r = nums.length - 1;
//
//        while (l <= r) {
//            int m = l + (r - l) / 2;
//            if (nums[m] == target)
//                return m;
//            if (nums[m] < nums[r]) { // 右半是排序的
//                if (target > nums[m] && target <= nums[r])
//                    l = m+1;
//                else
//                    r = m-1;
//            } else { // 左边是排好序的
//                if (target < nums[m] && target >= nums[l])
//                    r = m-1;
//                else
//                    l = m+1;
//            }
//        }
//        return -1;
//    }


    public int helper(int[] nums, int l, int r, int target) {
        if (l > r)
            return -1;
        int m = l + (r-l)/2;
        if (nums[m] == target) return m;

        if (nums[m] < nums[r]) {
            if (target > nums[m] && target <= nums[r])
                return helper(nums, m+1, r, target);
            else
                return helper(nums, l, m-1, target);
        } else {
            if (target < nums[m] && target >= nums[l])
                return helper(nums, l, m-1, target);
            else
                return helper(nums, m+1, r, target);
        }
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        return helper(nums, 0, nums.length-1, target);
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(solution.search(nums, 0));
    }
}
