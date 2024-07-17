// 122. Best Time to Buy and Sell Stock II


class Solution {
    public int maxProfit(int[] prices) {
        int low = prices[0];
        boolean lowIndex=false;
        boolean highIndex= false;
        int high =-1;
        int profit = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]<=low && !lowIndex){
                low = prices[i];
            }else if(prices[i]>=high) {
                high =prices[i];
                lowIndex = true;//low fixed
                highIndex= true;//high fixed
            }else if(lowIndex && prices[i]<high){
                profit+=high-low; // add profit
                low= prices[i];//reset low price
                high =-1;// reset high  price
                lowIndex= false; // reset low pointer
                highIndex=false;//reset high pointer
            }
        }
        if(highIndex){// for last sellingon day last
            profit+=high-low;
        }
        if(profit == 0 && lowIndex){ // if price only increased from start to end
            profit = high-low;
        }
        // System.out.println(high-low);
        return profit;
    }
}
