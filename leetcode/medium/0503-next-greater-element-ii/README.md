# Next Greater Element II

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a circular integer array `nums` (i.e., the next element of `nums[nums.length - 1]` is `nums[0]`), return  *the  **next greater number**  for every element in*  `nums`.

The  **next greater number**  of a number `x` is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return `-1` for this number.

 

 **Example 1:** 

```
Input: nums = [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number. 
The second 1's next greater number needs to search circularly, which is also 2.

```

 **Example 2:** 

```
Input: nums = [1,2,3,4,3]
Output: [2,3,4,-1,4]

```

 

 **Constraints:** 

- 1 <= nums.length <= 104
- -109 <= nums[i] <= 109

## Solution

**Language:** Java  
**Runtime:** 10 ms (beats 80.91%)  
**Memory:** 48.3 MB (beats 69.06%)  
**Submitted:** 2026-07-22T09:04:20.319Z  

```java
class Solution {
    public int[] nextGreaterElements(int[] arr) {
        int n = arr.length ;
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];
        Arrays.fill(res , -1);
        //int index = 0 ;

        for(int i = 0 ; i < 2*n ; i++) {
            int idx = i % n;

            while (!st.isEmpty() && arr[idx] > arr[st.peek()]) {
                int top = st.pop();
                res[top] = arr[idx];
            }

            if (i < n) {
                st.push(idx);
            }

        }
        return res;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/next-greater-element-ii/)