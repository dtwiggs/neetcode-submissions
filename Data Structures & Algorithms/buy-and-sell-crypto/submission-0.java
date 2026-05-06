class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1){
            return 0;
        }

        int l = 0, r = 1, profit = 0;
        while(r < prices.length){
            if(profit < prices[r] - prices[l]){
                profit = prices[r] - prices[l];
            }

            if(prices[l] > prices[r]){
                l = r;
                r++;
            } else{
                r++;
            }
            
        }
        return profit;
    }
}
