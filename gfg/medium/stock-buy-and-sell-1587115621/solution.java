class Solution {
    public int  stockBuySell(int[] prices) {
        int max = 0;
        int profit = 0;
        int l = prices.length;
        for ( int i = 1 ; i < l ; i++ ){
            if ( prices[i] > prices[i - 1]){
                profit = profit + (prices[i] - prices[i - 1]);
            }
        }
        return profit;
        
    }
}