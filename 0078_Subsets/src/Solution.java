import java.util.LinkedList;
import java.util.List;

/*
    题意：求所有子集，数组元素没有重复，
    解法：类似排列，用递归，每次修改当前元素选或不选，再深入递归
 */
public class Solution {
    // bit
//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> ret = new LinkedList<>();
//        int ans_num = 1<<nums.length;
//        for (int i = 0; i < ans_num; i++) {
//            List<Integer> sub = new LinkedList<>();
//            int tmp = i;
//            int j = 0;
//            while (tmp != 0) {
//                if ((tmp & 1) == 1) {
//                    sub.add(nums[j]);
//                }
//                tmp >>= 1;
//                j++;
//            }
//            ret.add(sub);
//        }
//        return ret;
//    }
    // BFS
//     public List<List<Integer>> subsets(int[] nums) {

//         List<List<Integer>> ret = new LinkedList<>();
//         ret.add(new LinkedList<Integer>());
//         for (int num : nums) {
//             int size = ret.size();
//             for (int i = 0; i < size; i++) {
//                 List<Integer> sub = new LinkedList<>(ret.get(i));
//                 sub.add(num);
//                 ret.add(sub);
//             }
//         }
//         return ret;
//     }

    // DFS
     public List<List<Integer>> subsets(int[] nums) {

         List<List<Integer>> ret = new LinkedList<>();
         boolean[] used = new boolean[nums.length];
         helper(ret, nums, used, 0);
         return ret;
     }

     public void helper(List<List<Integer>> ret, int[] nums, boolean[] used, int n) {
         if (n == nums.length) {
             List<Integer> arr = new LinkedList<>();
             for (int i = 0; i < used.length; i++) {
                 if (used[i])
                     arr.add(nums[i]);
             }
             ret.add(arr);
         } else {
             used[n] = true;
             helper(ret, nums, used, n+1);
             used[n] = false;
             helper(ret, nums, used, n+1);

         }
     }

}