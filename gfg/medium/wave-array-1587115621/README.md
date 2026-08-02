# Wave Array

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an  **s**  **orted**  array arr[] of integers. Sort the array into a wave-like array (In Place). In other words, arrange the elements into a sequence such that : arr[0] ≥ arr[1] ≤ arr[2] ≥ arr[3] ≤ arr[4] ≥... and so on. If there are multiple solutions, find the lexicographically smallest one.

 **Note:** The given array is sorted in ascending order, and modify the given array in-place without returning a new array.

 **Examples:** 

```
Input: arr[] = [1, 2, 3, 4, 5]
Output: [2, 1, 4, 3, 5]
Explanation: Array elements after sorting it in the waveform are 2, 1, 4, 3, 5.
```

```
Input: arr[] = [2, 4, 7, 8, 9, 10]
Output: [4, 2, 8, 7, 10, 9]
Explanation: Array elements after sorting it in the waveform are 4, 2, 8, 7, 10, 9.

```

```
Input: arr[] = [1]
Output: [1]
```

 **Constraints:** 
1 ≤ arr.size ≤ 106
0 ≤ arr[i] ≤109

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-02T06:41:58.241Z  

```java
class Solution {
    
    private static void  swap (int[] arr , int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void sortInWave(int arr[]) {
        // code here
        Arrays.sort(arr);
        
        for(int i = 0 ; i < arr.length - 1 ; i+=2) {
            swap(arr , i , i + 1);
        }
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/wave-array-1587115621/1)