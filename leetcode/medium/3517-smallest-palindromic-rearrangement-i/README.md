# Smallest Palindromic Rearrangement I

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given a  **palindromic**  string `s`.

Return the  **lexicographically smallest**  palindromic permutation of `s`.

 

 **Example 1:** 

 **Input:**  s = "z"

 **Output:**  "z"

 **Explanation:** 

A string of only one character is already the lexicographically smallest palindrome.

 **Example 2:** 

 **Input:**  s = "babab"

 **Output:**  "abbba"

 **Explanation:** 

Rearranging `"babab"` → `"abbba"` gives the smallest lexicographic palindrome.

 **Example 3:** 

 **Input:**  s = "daccad"

 **Output:**  "acddca"

 **Explanation:** 

Rearranging `"daccad"` → `"acddca"` gives the smallest lexicographic palindrome.

 

 **Constraints:** 

- 1 <= s.length <= 105
- s consists of lowercase English letters.
- s is guaranteed to be palindromic.

## Solution

**Language:** Java  
**Runtime:** 32 ms (beats 53.82%)  
**Memory:** 48.2 MB (beats 38.15%)  
**Submitted:** 2026-07-28T16:01:42.469Z  

```java
class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int halfLen = n / 2;
        char[] half = s.substring(0, halfLen).toCharArray();
        java.util.Arrays.sort(half);
        String left = new String(half);
        String right = new StringBuilder(left).reverse().toString();      
        if (n % 2 != 0) {
            return left + s.charAt(halfLen) + right;
        }

        return left + right;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/smallest-palindromic-rearrangement-i/)