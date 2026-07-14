# Length of the longest substring

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a string  **s**, find the length of the longest substring without repeating characters.

 **Examples:** 

```
Input: s = "geeksforgeeks"
Output: 7
Explanation: Longest substring is "eksforg".
```

```
Input: s = "abdefgabef"
Output: 6
Explanation: Longest substring are "abdefg", "bdefga" and "defgab".
```

```
Input: s = "aaaaa"
Output: 1
Explanation: Longest substring is "a".
```

 **Constraints:** 
1 ≤ s.size() ≤ 105
It is guaranteed that all characters of the String s will be lowercase letters from  **'a'**  to  **'z'**

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-07-14T06:50:38.261Z  

```java
class Solution {
    int longestUniqueSubstring(String s) {
        // code here
        int n = s.length();
        int left = 0;
        int len = 0 ;
        HashSet<Character> set = new HashSet<>();
        for(int right = 0 ; right < n ; right++){
            while(set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            len = Math.max(len , right - left + 1);
        }
        return len;
        
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/length-of-the-longest-substring3036/1)