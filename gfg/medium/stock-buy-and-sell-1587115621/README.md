# Stock buy and sell

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array  **arr[]** denoting the cost of stock on each day, the task is to find the maximum total profit if we can buy and sell the stocks any number of times.

 **Note:** We can only sell a stock which we have bought earlier and we cannot hold multiple stocks on any day.

 **Examples:** 

```
Input: arr[] = [100, 180, 260, 310, 40, 535, 695]
Output: 865
Explanation: Buy the stock on day 0 and sell it on day 3 => 310 – 100 = 210 Buy the stock on day 4 and sell it on day 6 => 695 – 40 = 655 Maximum Profit  = 210 + 655 = 865
```

```
Input: arr[] = [4, 2, 2, 2, 4]
Output: 2
Explanation: Buy the stock on day 3 and sell it on day 4 => 4 – 2 = 2

```

```
Input: arr[] = [4, 2]
Output: 0
Explanation: Don't Buy the stock.
```

 **Constraints:** 
2 ≤ arr.size() ≤ 106
0 ≤ arr[i] ≤ 106

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-02T06:03:01.485Z  

```java
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
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/stock-buy-and-sell-1587115621/1)