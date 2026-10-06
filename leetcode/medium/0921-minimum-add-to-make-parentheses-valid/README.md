# Minimum Add to Make Parentheses Valid

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

A parentheses string is valid if and only if:

- It is the empty string,
- It can be written as AB (A concatenated with B), where A and B are valid strings, or
- It can be written as (A), where A is a valid string.

You are given a parentheses string `s`. In one move, you can insert a parenthesis at any position of the string.

- For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".

Return  *the minimum number of moves required to make* `s` *valid*.

 

 **Example 1:** 

```
Input: s = "())"
Output: 1

```

 **Example 2:** 

```
Input: s = "((("
Output: 3

```

 

 **Constraints:** 

- 1 <= s.length <= 1000
- s[i] is either '(' or ')'.

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 42.17%)  
**Memory:** 42.8 MB (beats 74.52%)  
**Submitted:** 2026-10-06T05:02:03.782Z  

```java
class Solution {
    public int minAddToMakeValid(String s) {
        int c = 0;
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length() ; i++ ) {
            char ch = s.charAt(i) ;
            if(ch == '(') {
                st.push(ch);
            }
            else {
                if(!(st.isEmpty()) && st.peek() == '(') {
                    st.pop();
                    continue;
                }
                c++;
            }
        }
        return c + st.size();
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/)