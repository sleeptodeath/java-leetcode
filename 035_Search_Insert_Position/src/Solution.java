
public class Solution {

//    public int searchInsert(int[] nums, int target) {
//
//        int i;
//        for (i = nums.length-1; i >= 0; i--) {
//            if (target <= nums[i])
//                continue;
//            else
//                return i+1;
//        }
//        return 0;
//    }

    public int searchInsert(int[] nums, int target) {
        // 二分插入
        int low = 0, high = nums.length-1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (target > nums[mid])
                low = mid+1;
            else
                high = mid - 1;
        }
        return low;
    }

}
