# Trapping Rain Water

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given an array  **arr[]** with non-negative integers representing the height of blocks. If the width of each block is 1, compute how much water can be trapped between the blocks during the rainy season. 

 **Examples:** 

```
Input: arr[] = [3, 0, 1, 0, 4, 0, 2]
Output: 10
Explanation: Total water trapped = 0 + 3 + 2 + 3 + 0 + 2 + 0 = 10 units.

```

```
Input: arr[] = [3, 0, 2, 0, 4]
Output: 7
Explanation: Total water trapped = 0 + 3 + 1 + 3 + 0 = 7 units.

```

```
Input: arr[] = [1, 2, 3, 4]
Output: 0
Explanation: We cannot trap water as there is no height bound on both sides.
```

```
Input: arr[] = [2, 1, 5, 3, 1, 0, 4]
Output: 9
Explanation: Total water trapped = 0 + 1 + 0 + 1 + 3 + 4 + 0 = 9 units.
```

 **Constraints:** 
1 < arr.size() < 105
0 < arr[i] < 103

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-07-17T12:11:36.635Z  

```java
class Solution {
    public int maxWater(int arr[]) {
        // code here
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        left[0] = arr[0];
        for(int i = 1 ; i < n ; i++){
            int curr = left[i - 1];
            left[i] = Math.max(curr , arr[i]);
        }
        
        right[n - 1] = arr[n - 1];
        for(int i = n - 2 ; i >= 0 ; i--) {
            int curr = right[i + 1];
            right[i] = Math.max(curr, arr[i]);
        }
        
        int tot = 0 ;
        
        for(int i = 0 ; i < n ; i++) {
            tot += Math.min(left[i] , right[i]) - arr[i];
        }
        return tot;
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/trapping-rain-water-1587115621/1)