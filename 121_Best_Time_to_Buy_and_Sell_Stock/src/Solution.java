
public class Solution {
    public int maxProfit(int[] prices) {
        int ret = 0;
        if (prices == null || prices.length == 0)
            return 0;
        int min = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= min) {
                ret = Math.max(ret, prices[i] - min);
            } else {
                min = prices[i];
            }
        }
        return ret;
    }
}
