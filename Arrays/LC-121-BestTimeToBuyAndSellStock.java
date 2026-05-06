
class Solution {
    public int maxProfit(int[] prices) {
        int profit=0;
        int buy=prices[0];
        for(int i=1;i<prices.length;i++){
            buy=Math.min(prices[i],buy);
            profit=Math.max(prices[i]-buy,profit);
        }
        return profit;
    }
}

// I used if() and else if() for finding min price and max profit
// But code works fine

class Solution {
    public int maxProfit(int[] prices) {
        int profit=0;
        int buy=prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i]-buy>profit){
                profit=prices[i]-buy;
            }
            else if(prices[i]<buy){
                buy=prices[i];
            }
        }
        return profit;
    }
}
