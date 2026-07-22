# Indexes of Subarray Sum

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array  **arr[]**  containing only non-negative integers, your task is to find a continuous subarray (a contiguous sequence of elements) whose sum equals a specified value  **`target`**. You need to return the  **1-based indices**  of the leftmost and rightmost elements of this subarray. You need to find the first subarray whose sum is equal to the target.

Note: If no such array is possible then, return [-1].

 **Examples:** 

```
Input: arr[] = [1, 2, 3, 7, 5], target = 12
Output: [2, 4]
Explanation: The sum of elements from 2nd to 4th position is 12.
```

```
Input: arr[] = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], target = 15
Output: [1, 5]
Explanation: The sum of elements from 1st to 5th position is 15.

```

```
Input: arr[] = [5, 3, 4], target = 2
Output: [-1]
Explanation: There is no subarray with sum 2.
```

**Constraints:
**1 ≤ arr.size() ≤ 106
0 ≤ arr[i] ≤ 103
0 ≤ target ≤ 109

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-07-22T08:06:56.095Z  

```java

class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        // code here
        int n = arr.length;
        ArrayList<Integer> idx = new ArrayList<>();
        
        int start = 0 ;
        int sum = 0;
        
        for(int end = 0 ; end < n ; end++) {
            sum += arr[end];
            
            while(sum > target) {
                sum -= arr[start];
                start++;
            }
            
            if(sum == target) {
                idx.add(start + 1);
                idx.add(end + 1);
                return idx;
            }
        }
        
        idx.add(-1);
        return idx;
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1)