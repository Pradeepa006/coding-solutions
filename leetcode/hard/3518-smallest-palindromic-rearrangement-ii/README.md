# Smallest Palindromic Rearrangement II

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given a  **palindromic**  string `s` and an integer `k`.

Return the  **k-th**   **lexicographically smallest**  palindromic permutation of `s`. If there are fewer than `k` distinct palindromic permutations, return an empty string.

 **Note:**  Different rearrangements that yield the same palindromic string are considered identical and are counted once.

 

 **Example 1:** 

 **Input:**  s = "abba", k = 2

 **Output:**  "baab"

 **Explanation:** 

- The two distinct palindromic rearrangements of "abba" are "abba" and "baab".
- Lexicographically, "abba" comes before "baab". Since k = 2, the output is "baab".

 **Example 2:** 

 **Input:**  s = "aa", k = 2

 **Output:**  ""

 **Explanation:** 

- There is only one palindromic rearrangement: "aa".
- The output is an empty string since k = 2 exceeds the number of possible rearrangements.

 **Example 3:** 

 **Input:**  s = "bacab", k = 1

 **Output:**  "abcba"

 **Explanation:** 

- The two distinct palindromic rearrangements of "bacab" are "abcba" and "bacab".
- Lexicographically, "abcba" comes before "bacab". Since k = 1, the output is "abcba".

 

 **Constraints:** 

- 1 <= s.length <= 104
- s consists of lowercase English letters.
- s is guaranteed to be palindromic.
- 1 <= k <= 106

## Solution

**Language:** Java  
**Runtime:** 23 ms (beats 74.19%)  
**Memory:** 47 MB (beats 90.32%)  
**Submitted:** 2026-07-29T12:09:05.198Z  

```java
class Solution {
    long nCr(int n, int r, int k) {
        long res = 1; 
        r = Math.min(r, n - r); // min of r * n - r

        for(int i = 1; i <= r; i++) {
            res = res * (n - i + 1) / i; 
            if(res > k) return k + 1; 
        }
        return res; 
    }
    long ways(int n, int f[], int k) {
        long total = 1; 
        for( int i = 0; i < 26; i++) {
            total *= nCr(n, f[i], k); 
            if(total > k) return k + 1; // bigger exact doesn't mater 
            n -= f[i]; 
        }
        return total; 
    }
    public String smallestPalindrome(String s, int k) {
        int n = s.length(); 
        int len = n/2; 
        int f[] = new int[26]; 
        for(int i = 0; i < n; i++) f[s.charAt(i) - 'a']++; 

        // half it 
        char str[] = new char[n]; 
        for(int i = 0; i < 26; i++) {
            if(f[i] % 2 == 1) str[n/2] = (char)('a' + i); 
            f[i] /= 2; 
        }

        // only half matters 
        long cnt = ways(len, f, k); 

        if(cnt < k) return ""; // else possible 

        /// first half 
        for(int idx = 0; idx < len; idx++) {
            for(int i = 0; i < 26; i++) {
                if(f[i] == 0) continue; 
                // pick cur 
                f[i]--; // reduc freq 
                long possible = ways(len - idx - 1, f, k); 
                if(possible >= k) {
                    // fix cur
                    str[idx] = (char) ('a' + i); 
                    break; 
                } else {
                    k -= possible; 
                    f[i]++; // undo it. 
                } 
            }
        }

        // mirror 
        for(int i = 0; i < len; i++) {
            str[n - i - 1] = str[i]; 
        }
        return String.valueOf(str); 
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/smallest-palindromic-rearrangement-ii/)