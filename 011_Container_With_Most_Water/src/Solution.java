public class Solution {
    // 暴力
//    public int maxArea(int[] height) {
//        int ret = 0;
//        int i, j;
//
//        for (i = 0; i < height.length-1; i++) {
//            for (j = i+1; j < height.length; j++) {
//
//                ret = Math.max(ret, (j-i) * Math.min(height[i], height[j]));
//            }
//        }
//        return ret;
//    }

    public int maxArea(int[] height) {
       int i = 0, j = height.length-1;
       int ret = 0;
       while (i < j) {
           ret = Math.max(ret, (j-i)*(Math.min(height[i], height[j])));
           if (height[i] < height[j]) {
               i++;
           } else {
               j--;
           }
       }
       return ret;
    }
}
