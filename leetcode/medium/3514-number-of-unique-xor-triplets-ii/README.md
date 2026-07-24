# Number of Unique XOR Triplets II

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given an integer array `nums`.

A  **XOR triplet**  is defined as the XOR of three elements `nums[i] XOR nums[j] XOR nums[k]` where `i <= j <= k`.

Return the number of  **unique**  XOR triplet values from all possible triplets `(i, j, k)`.

 

 **Example 1:** 

 **Input:**  nums = [1,3]

 **Output:**  2

 **Explanation:** 

The possible XOR triplet values are:

- (0, 0, 0) → 1 XOR 1 XOR 1 = 1
- (0, 0, 1) → 1 XOR 1 XOR 3 = 3
- (0, 1, 1) → 1 XOR 3 XOR 3 = 1
- (1, 1, 1) → 3 XOR 3 XOR 3 = 3

The unique XOR values are `{1, 3}`. Thus, the output is 2.

 **Example 2:** 

 **Input:**  nums = [6,7,8,9]

 **Output:**  4

 **Explanation:** 

The possible XOR triplet values are `{6, 7, 8, 9}`. Thus, the output is 4.

 

 **Constraints:** 

- 1 <= nums.length <= 1500
- 1 <= nums[i] <= 1500

## Solution

**Language:** Java  
**Runtime:** 204 ms (beats 89.09%)  
**Memory:** 47.1 MB (beats 49.09%)  
**Submitted:** 2026-07-24T19:03:15.052Z  

```java
class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;

        int[] pairXor = new int[2048];
        int[] tripleXor = new int[2048];

        // Compute all possible pair XORs
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                pairXor[nums[i] ^ nums[j]] = 1;
            }
        }

        // Generate triplet XORs
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2048; j++) {
                if (pairXor[j] == 1) {
                    tripleXor[j ^ nums[i]] = 1;
                }
            }
        }

        // Count distinct XOR values
        int cnt = 0;
        for (int value : tripleXor) {
            if (value == 1) {
                cnt++;
            }
        }

        return cnt;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/number-of-unique-xor-triplets-ii/)