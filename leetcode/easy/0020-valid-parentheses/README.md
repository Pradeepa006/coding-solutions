# Valid Parentheses

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given a string `s` containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`, determine if the input string is valid.

An input string is valid if:

- Open brackets must be closed by the same type of brackets.
- Open brackets must be closed in the correct order.
- Every close bracket has a corresponding open bracket of the same type.

 

 **Example 1:** 

 **Input:**  s = "()"

 **Output:**  true

 **Example 2:** 

 **Input:**  s = "()[]{}"

 **Output:**  true

 **Example 3:** 

 **Input:**  s = "(]"

 **Output:**  false

 **Example 4:** 

 **Input:**  s = "([])"

 **Output:**  true

 **Example 5:** 

 **Input:**  s = "([)]"

 **Output:**  false

 

 **Constraints:** 

- 1 <= s.length <= 104
- s consists of parentheses only '()[]{}'.

## Solution

**Language:** Java  
**Runtime:** 4 ms (beats 36.81%)  
**Memory:** 43.4 MB (beats 25.53%)  
**Submitted:** 2026-10-01T10:12:40.984Z  

```java
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        if(s.length() % 2 != 0) {
            return false;
        }
        for(int i = 0 ; i < s.length() ; i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
                continue;
            }
            else {
            if(st.isEmpty()) {
                return false;
            }
            if ((ch == ')' && st.pop() != '(') || (ch == '}' && st.pop() != '{') || (ch == ']' && st.pop() != '[') ) {
                return false;
            }
            }
            

        
        }
        return st.isEmpty();
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/valid-parentheses/)