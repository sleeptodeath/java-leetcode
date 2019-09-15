import java.util.HashMap;
import java.util.Map;

public class Solution {

    // 暴力遍历
    /*
        两重遍历
        复杂度: O(n^2)
     */
    public int[] twoSum1(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }
    // HashMap
    /*
        for-each i
            if nums[i] in map
                return {i, map[nums[i]]}
            else
                map[target - nums[i]] = index(x);

     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[] {map.get(nums[i]), i};
            } else {
                map.put(target-nums[i], i);
            }
        }
        return null;
    }
}
