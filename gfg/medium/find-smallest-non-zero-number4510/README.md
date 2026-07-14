# Smallest Non-Zero Number

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array  **arr[],**  find the smallest number x such that when x is processed sequentially with each element of the array (from index 0 to n-1), it  **never becomes negative**, under the following conditions:

- If x is greater than the current array element, x is increased by the difference between x and the array element.
- If x is less than or equal to the current array element, x is decreased by the difference between the array element and x.

 **Examples:** 

```
Input: arr[] = [3, 4, 3, 2, 4]
Output: 4
Explanation: Start with x = 4:
- For arr[0] = 3, x becomes 5.
- For arr[1] = 4, x becomes 6.
- For arr[2] = 3, x becomes 9.
- For arr[3] = 2, x becomes 16.
- For arr[4] = 4, x becomes 28.
x remains positive throughout the process.
If x < 4, it would become negative at some point.
```

```
Input: arr[] = [4, 4]
Output: 3
Explanation: Start with x = 3:
- For arr[0] = 4, x becomes 2.
- For arr[1] = 4, x becomes 0.
x remains non-negative. If x < 3, it would become negative.
```

 **Constraints:** 
1 ≤ arr.size() ≤ 106
1<= arr[i] <= 104

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-07-14T11:17:59.851Z  

```java
class Solution {
    public int find(int[] arr) {

        int start = 0;

        for(int i = arr.length - 1 ; i >= 0 ; i--){
            start = (start + arr[i] + 1) / 2;
        }
        return start;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/find-smallest-non-zero-number4510/1)