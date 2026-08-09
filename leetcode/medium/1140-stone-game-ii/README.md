# Stone Game II

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Alice and Bob continue their games with piles of stones. There are a number of piles  **arranged in a row**, and each pile has a positive integer number of stones `piles[i]`. The objective of the game is to end with the most stones.

Alice and Bob take turns, with Alice starting first.

On each player's turn, that player can take  **all the stones**  in the  **first**  `X` remaining piles, where `1 <= X <= 2M`. Then, we set `M = max(M, X)`. Initially, M = 1.

The game continues until all the stones have been taken.

Assuming Alice and Bob play optimally, return the maximum number of stones Alice can get.

 

 **Example 1:** 

 **Input:**  piles = [2,7,9,4,4]

 **Output:**  10

 **Explanation:** 

- If Alice takes one pile at the beginning, Bob takes two piles, then Alice takes 2 piles again. Alice can get 2 + 4 + 4 = 10 stones in total.
- If Alice takes two piles at the beginning, then Bob can take all three piles left. In this case, Alice get 2 + 7 = 9 stones in total.

So we return 10 since it's larger.

 **Example 2:** 

 **Input:**  piles = [1,2,3,4,5,100]

 **Output:**  104

 

 **Constraints:** 

- 1 <= piles.length <= 100
- 1 <= piles[i] <= 104

## Solution

**Language:** Java  
**Runtime:** 18 ms (beats 19.58%)  
**Memory:** 46.8 MB (beats 22.33%)  
**Submitted:** 2026-08-09T13:15:02.462Z  

```java
class Solution {
    private int dfs(int i, int m, int[] piles, Map<Integer, Integer> memo) {
        int n = piles.length;

        if (i + m * 2 >= n)
            return piles[i];

        int key = (i << 8) | m;

        if (memo.containsKey(key))
            return memo.get(key);

        int res = Integer.MAX_VALUE;

        for (int k = 1; k <= m * 2; k++)
            res = Math.min(res, dfs(i + k, Math.max(m, k), piles, memo));

        int val = piles[i] - res;
        
        memo.put(key, val);

        return val;
    }

    public int stoneGameII(int[] piles) {
        int n = piles.length;

        for (int i = n - 2; i >= 0; i--)
            piles[i] += piles[i + 1];

        Map<Integer, Integer> memo = new HashMap<>();

        return dfs(0, 1, piles, memo);
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/stone-game-ii/)