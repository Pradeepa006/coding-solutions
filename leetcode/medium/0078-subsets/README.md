# Subsets

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an integer array `nums` of  **unique**  elements, return  *all possible*   *subsets*   *(the power set)*.

The solution set  **must not**  contain duplicate subsets. Return the solution in  **any order**.

 

 **Example 1:** 

```
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

```

 **Example 2:** 

```
Input: nums = [0]
Output: [[],[0]]

```

 

 **Constraints:** 

- 1 <= nums.length <= 10
- -10 <= nums[i] <= 10
- All the numbers of nums are unique.

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 86.54%)  
**Memory:** 44.3 MB (beats 39.20%)  
**Submitted:** 2026-08-11T12:40:40.892Z  

```java
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        backtrack(res , new ArrayList<>() , nums , 0);
        return res;
    }
    private static void backtrack(List<List<Integer>> res , List<Integer> li , int[] nums , int start ) {
        res.add(new ArrayList<>(li));
        int n = nums.length;
        for(int i = start ; i < n ; i++) {
            li.add(nums[i]);
            backtrack(res , li , nums , i + 1);
            li.remove(li.size() - 1);
        }
        
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/subsets/)