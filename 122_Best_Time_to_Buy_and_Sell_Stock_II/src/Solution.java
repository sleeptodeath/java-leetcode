public class Solution {

    // 找递增子序列
//    public int maxProfit(int[] prices) {
//
//        int ret = 0;
//        if (prices == null || prices.length == 0)
//            return ret;
//        int buy = prices[0];
//        for (int i = 1; i < prices.length; i++) {
//            if (prices[i] >= prices[i-1]) continue; // 递增
//            else { // 不递增了
//                ret += prices[i-1] - buy;
//                buy = prices[i];
//            }
//        }
//        ret += prices[prices.length-1] - buy;
//        return ret;
//    }

    // 简化版，只要比前一个贵就买
    public int maxProfit(int[] prices) {
        int ret = 0;
        if (prices == null || prices.length == 0)
            return 0;
        int pre = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > pre)
                ret += prices[i] - pre;
            pre = prices[i];
        }
        return ret;
    }
}
