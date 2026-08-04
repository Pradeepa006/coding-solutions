# Generate Parentheses

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given `n` pairs of parentheses, write a function to  *generate all combinations of well-formed parentheses*.

 

 **Example 1:** 

```
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

```

 **Example 2:** 

```
Input: n = 1
Output: ["()"]

```

 

 **Constraints:** 

- 1 <= n <= 8

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 70.40%)  
**Memory:** 45.1 MB (beats 12.59%)  
**Submitted:** 2026-08-04T04:38:38.076Z  

```java
class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> li = new ArrayList<>();
        String s = "";
        backtrack(li , s , 0 , 0 , n);
        return li;
    }
    private static void backtrack(List<String> li , String s , int open , int close , int max){
        if(max * 2 == s.length()) {
            li.add(s);
            return;
        }
        if(open < max ) 
            backtrack(li , s+"(" , open + 1 , close , max);
        if(close < open)
            backtrack(li , s+")" , open , close + 1 , max);
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/generate-parentheses/)