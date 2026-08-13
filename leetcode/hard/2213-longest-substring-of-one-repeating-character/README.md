# Longest Substring of One Repeating Character

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given a  **0-indexed**  string `s`. You are also given a  **0-indexed**  string `queryCharacters` of length `k` and a  **0-indexed**  array of integer  **indices**  `queryIndices` of length `k`, both of which are used to describe `k` queries.

The `ith` query updates the character in `s` at index `queryIndices[i]` to the character `queryCharacters[i]`.

Return  *an array*  `lengths`  *of length* `k` *where*  `lengths[i]`  *is the  **length**  of the  **longest substring**  of* `s` *consisting of  **only one repeating**  character  **after**  the*  `ith`  *query** is performed.* 

 

 **Example 1:** 

```
Input: s = "babacc", queryCharacters = "bcb", queryIndices = [1,3,3]
Output: [3,3,4]
Explanation: 
- 1st query updates s = "bbbacc". The longest substring consisting of one repeating character is "bbb" with length 3.
- 2nd query updates s = "bbbccc". 
  The longest substring consisting of one repeating character can be "bbb" or "ccc" with length 3.
- 3rd query updates s = "bbbbcc". The longest substring consisting of one repeating character is "bbbb" with length 4.
Thus, we return [3,3,4].

```

 **Example 2:** 

```
Input: s = "abyzz", queryCharacters = "aa", queryIndices = [2,1]
Output: [2,3]
Explanation:
- 1st query updates s = "abazz". The longest substring consisting of one repeating character is "zz" with length 2.
- 2nd query updates s = "aaazz". The longest substring consisting of one repeating character is "aaa" with length 3.
Thus, we return [2,3].

```

 

 **Constraints:** 

- 1 <= s.length <= 105
- s consists of lowercase English letters.
- k == queryCharacters.length == queryIndices.length
- 1 <= k <= 105
- queryCharacters consists of lowercase English letters.
- 0 <= queryIndices[i] < s.length

## Solution

**Language:** Java  
**Runtime:** 266 ms (beats 15.63%)  
**Memory:** 110.3 MB (beats 65.63%)  
**Submitted:** 2026-08-13T05:37:52.084Z  

```java
import java.util.*;

class Solution {
    private TreeMap<Integer, Integer> counts = new TreeMap<>();

    private void addLen(int len) {
        if (len > 0) {
            counts.put(len, counts.getOrDefault(len, 0) + 1);
        }
    }

    private void removeLen(int len) {
        if (len > 0) {
            int count = counts.get(len);
            if (count == 1) {
                counts.remove(len);
            } else {
                counts.put(len, count - 1);
            }
        }
    }

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        int k = queryIndices.length;
        int[] result = new int[k];
        char[] arr = s.toCharArray();

        TreeMap<Integer, Integer> segments = new TreeMap<>();

        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && arr[j] == arr[i]) {
                j++;
            }
            int len = j - i;
            segments.put(i, len);
            addLen(len);
            i = j;
        }

        for (int q = 0; q < k; q++) {
            int idx = queryIndices[q];
            char c = queryCharacters.charAt(q);

            if (arr[idx] == c) {
                result[q] = counts.lastKey();
                continue;
            }

            Map.Entry<Integer, Integer> it = segments.floorEntry(idx);
            int start = it.getKey();
            int len = it.getValue();
            int end = start + len - 1;

            segments.remove(start);
            removeLen(len);

            int leftLen = idx - start;
            int rightLen = end - idx;

            if (leftLen > 0) {
                segments.put(start, leftLen);
                addLen(leftLen);
            }
            if (rightLen > 0) {
                segments.put(idx + 1, rightLen);
                addLen(rightLen);
            }

            arr[idx] = c;

            int newStart = idx;
            int newLen = 1;

            if (idx > 0) {
                Map.Entry<Integer, Integer> leftIt = segments.floorEntry(idx - 1);
                if (leftIt != null) {
                    int lStart = leftIt.getKey();
                    int lLen = leftIt.getValue();
                    if (lStart + lLen - 1 == idx - 1 && arr[lStart] == c) {
                        newStart = lStart;
                        newLen += lLen;
                        removeLen(lLen);
                        segments.remove(lStart);
                    }
                }
            }

            Integer rightKey = idx + 1;
            if (segments.containsKey(rightKey) && arr[rightKey] == c) {
                int rLen = segments.get(rightKey);
                newLen += rLen;
                removeLen(rLen);
                segments.remove(rightKey);
            }

            segments.put(newStart, newLen);
            addLen(newLen);

            result[q] = counts.lastKey();
        }

        return result;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/longest-substring-of-one-repeating-character/)