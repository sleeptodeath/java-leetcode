import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Set<List<Integer>> set_ret = new HashSet<>();
        List<Integer> tmp1 = new LinkedList<>();
        List<Integer> tmp2 = new LinkedList<>();
        tmp1.add(1); tmp1.add(2);
        tmp2.add(2); tmp2.add(1);
        Collections.sort(tmp2);
        set_ret.add(tmp1);
        set_ret.add(tmp2);
        System.out.println(set_ret.size());
    }

    // set去重
//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> res = new ArrayList<List<Integer>>();
//
//        int len = nums.length;
//        if (len <= 2) return res;
//        Arrays.sort(nums);
//
//        HashSet<Integer> hashSet = new HashSet<Integer>();
//        hashSet.add(nums[0]);
//        // i j k
//        for (int j = 1; j <= len - 2; j++) {
//            int k = j + 1;
//            while (k < len) {
//                int target = 0 - nums[j] - nums[k];
//                // find i in [0, j)
//                if (hashSet.contains(target)) {
//                    List<Integer> newAdded = Arrays.asList(target, nums[j], nums[k]);
//                    if (!res.contains(newAdded)) {
//                        res.add(Arrays.asList(target, nums[j], nums[k]));
//
//                    }
//                }
//                while (k < len - 1 && nums[k] == nums[k + 1]) k++;
//                k++;
//            }
//            hashSet.add(nums[j]);
//        }
//        return res;
//    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new LinkedList<>();

        for (int i = 0; i < nums.length-2; i++) {

            if (i == 0 || nums[i] != nums[i-1]) {
                int l = i+1;
                int h = nums.length - 1;
                int two_sum = 0-nums[i];
                while (l < h) {
                    if (nums[l] + nums[h] == two_sum) {
                        ret.add(Arrays.asList(nums[i], nums[l], nums[h]));
                        // 可能还有
                        while (l < h && nums[l+1] == nums[l]) l++;
                        while (l < h && nums[h-1] == nums[h]) h--;
                        l++;
                        h--;
                    } else if (nums[l] + nums[h] < two_sum) l++;
                    else h--;
                }
            }
        }
        return ret;
    }

}
