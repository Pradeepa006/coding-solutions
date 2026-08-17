# Stone Game V

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

There are several stones  **arranged in a row**, and each stone has an associated value which is an integer given in the array `stoneValue`.

In each round of the game, Alice divides the row into  **two non-empty rows**  (i.e. left row and right row), then Bob calculates the value of each row which is the sum of the values of all the stones in this row. Bob throws away the row which has the maximum value, and Alice's score increases by the value of the remaining row. If the value of the two rows are equal, Bob lets Alice decide which row will be thrown away. The next round starts with the remaining row.

The game ends when there is only  **one stone remaining**. Alice's score is initially  **zero**.

Return  *the maximum score that Alice can obtain*.

 

 **Example 1:** 

```
Input: stoneValue = [6,2,3,4,5,5]
Output: 18
Explanation: In the first round, Alice divides the row to [6,2,3], [4,5,5]. The left row has the value 11 and the right row has value 14. Bob throws away the right row and Alice's score is now 11.
In the second round Alice divides the row to [6], [2,3]. This time Bob throws away the left row and Alice's score becomes 16 (11 + 5).
The last round Alice has only one choice to divide the row which is [2], [3]. Bob throws away the right row and Alice's score is now 18 (16 + 2). The game ends because only one stone is remaining in the row.

```

 **Example 2:** 

```
Input: stoneValue = [7,7,7,7,7,7,7]
Output: 28

```

 **Example 3:** 

```
Input: stoneValue = [4]
Output: 0

```

 

 **Constraints:** 

- 1 <= stoneValue.length <= 500
- 1 <= stoneValue[i] <= 106

## Solution

**Language:** Java  
**Runtime:** 294 ms (beats 26.68%)  
**Memory:** 47.5 MB (beats 76.68%)  
**Submitted:** 2026-08-17T06:39:09.546Z  

```java
class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;

        int[][] dp = new int[n][n];
        int[] prefix = new int[n+1];

        for(int i=0;i<n;i++){
            prefix[i+1] = prefix[i] + stoneValue[i];
            dp[i][i] = 0;
        }

        for(int left=n-1;left>=0;left--){
            for(int right=0;right<n;right++){
                int totalSum = prefix[right+1]-prefix[left];

                int maxScore = 0;

                for(int i=left;i<=right-1;i++){
                    int leftSum = prefix[i+1]-prefix[left];
                    int rightSum = totalSum-leftSum;
                    
                    if(leftSum == rightSum){
                        int l = leftSum + dp[i+1][right];
                        int r = rightSum + dp[left][i];
                        maxScore = Math.max(maxScore, Math.max(l, r));
                    }
                    else if(leftSum < rightSum){
                        maxScore = Math.max(maxScore ,leftSum+dp[left][i]);
                    }
                    else{
                        maxScore = Math.max(maxScore, rightSum + dp[i+1][right]);
                    }
                }
                
                dp[left][right] = maxScore;
            }
        }

        return dp[0][n-1];
    }

}
```

---

[View on LeetCode](https://leetcode.com/problems/stone-game-v/)