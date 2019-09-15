
public class Solution {

    public int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;
        int i = 0, j = 1;
        for (; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }

}
