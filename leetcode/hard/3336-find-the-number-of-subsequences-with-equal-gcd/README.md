# Find the Number of Subsequences With Equal GCD

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given an integer array `nums`.

Your task is to find the number of pairs of  **non-empty**  subsequences `(seq1, seq2)` of `nums` that satisfy the following conditions:

- The subsequences seq1 and seq2 are disjoint, meaning no index of nums is common between them.
- The GCD of the elements of seq1 is equal to the GCD of the elements of seq2.

Return the total number of such pairs.

Since the answer may be very large, return it  **modulo**  `109 + 7`.

 

 **Example 1:** 

 **Input:**  nums = [1,2,3,4]

 **Output:**  10

 **Explanation:** 

The subsequence pairs which have the GCD of their elements equal to 1 are:

- ([1, 2, 3, 4], [1, 2, 3, 4])
- ([1, 2, 3, 4], [1, 2, 3, 4])
- ([1, 2, 3, 4], [1, 2, 3, 4])
- ([1, 2, 3, 4], [1, 2, 3, 4])
- ([1, 2, 3, 4], [1, 2, 3, 4])
- ([1, 2, 3, 4], [1, 2, 3, 4])
- ([1, 2, 3, 4], [1, 2, 3, 4])
- ([1, 2, 3, 4], [1, 2, 3, 4])
- ([1, 2, 3, 4], [1, 2, 3, 4])
- ([1, 2, 3, 4], [1, 2, 3, 4])

 **Example 2:** 

 **Input:**  nums = [10,20,30]

 **Output:**  2

 **Explanation:** 

The subsequence pairs which have the GCD of their elements equal to 10 are:

- ([10, 20, 30], [10, 20, 30])
- ([10, 20, 30], [10, 20, 30])

 **Example 3:** 

 **Input:**  nums = [1,1,1,1]

 **Output:**  50

 

 **Constraints:** 

- 1 <= nums.length <= 200
- 1 <= nums[i] <= 200

## Solution

**Language:** Java  
**Runtime:** 61 ms (beats 94.44%)  
**Memory:** 47.6 MB (beats 58.33%)  
**Submitted:** 2026-07-14T18:56:25.090Z  

```java
class Solution {
    private static final int kMod = 1_000_000_007;
    private static final int kMaxNum = 200;
    private static final int[][] kGcdTable = new int[kMaxNum + 1][kMaxNum + 1];

    static {
        // Precompute GCDs to avoid recalculation in DP loop.
        for (int j1 = 0; j1 <= kMaxNum; j1++) {
            for (int j2 = 0; j2 <= kMaxNum; j2++) {
                if (j1 == 0) {
                    kGcdTable[j1][j2] = j2;
                } else if (j2 == 0) {
                    kGcdTable[j1][j2] = j1;
                } else {
                    kGcdTable[j1][j2] = gcd(j1, j2);
                }
            }
        }
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Modulo addition helper.
    private int addMod(int lhs, int rhs) {
        lhs += rhs;
        return lhs >= kMod ? lhs - kMod : lhs;
    }

    public int subsequencePairCount(int[] nums) {
        int maxVal = 0;
        for (int num : nums) {
            if (num > maxVal) maxVal = num;
        }
        
        int stride = maxVal + 1;
        // Flattened 2D state size.
        int totStates = stride * stride;

        int[] dp = new int[totStates];
        int[] nextDp = new int[totStates];

        // Base case: both subsequences are empty (gcd 0).
        dp[0] = 1;

        for (int num : nums) {
            // Carry over states where num is skipped.
            System.arraycopy(dp, 0, nextDp, 0, totStates);

            for (int idx = 0; idx < totStates; idx++) {
                int cnt = dp[idx];
                if (cnt == 0) continue;

                int gcd1 = idx / stride;
                int gcd2 = idx % stride;

                // Transition 1: append to first subsequence.
                int nextGcd1 = kGcdTable[gcd1][num];
                int idx1 = nextGcd1 * stride + gcd2;
                nextDp[idx1] = addMod(nextDp[idx1], cnt);

                // Transition 2: append to second subsequence.
                int nextGcd2 = kGcdTable[gcd2][num];
                int idx2 = gcd1 * stride + nextGcd2;
                nextDp[idx2] = addMod(nextDp[idx2], cnt);
            }

            int[] temp = dp;
            dp = nextDp;
            nextDp = temp;
        }

        int result = 0;
        // Sum states where both have the same non-zero GCD.
        for (int gcd_ = 1; gcd_ < stride; gcd_++) {
            result = addMod(result, dp[gcd_ * stride + gcd_]);
        }

        return result;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/find-the-number-of-subsequences-with-equal-gcd/)