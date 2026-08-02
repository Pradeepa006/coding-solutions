# Merge Without Extra Space

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given two sorted arrays  **a[]**  and  **b[]** of size  **n** and  **m** respectively, the task is to merge them in sorted order without using any  **extra space**. Modify  **a[]**  so that it contains the first  **n**  elements and modify  **b[]**  so that it contains the last  **m**  elements.

 **Examples:** 

```
Input: a[] = [2, 4, 7, 10], b[] = [2, 3]
Output: a[] = [2, 2, 3, 4], b[] = [7, 10]
Explanation: After merging the two non-decreasing arrays, we get, [2, 2, 3, 4, 7, 10]
```

```
Input: a[] = [1, 5, 9, 10, 15, 20], b[] = [2, 3, 8, 13]
Output: a[] = [1, 2, 3, 5, 8, 9], b[] = [10, 13, 15, 20]
Explanation: After merging two sorted arrays we get [1, 2, 3, 5, 8, 9, 10, 13, 15, 20].

```

```
Input: a[] = [0, 1], b[] = [2, 3]
Output: a[] = [0, 1], b[] = [2, 3]
Explanation: After merging two sorted arrays we get [0, 1, 2, 3].
```

 **Constraints:** 
1 ≤ n, m ≤ 105
0 ≤ a[i], b[i] ≤ 107

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-02T06:21:17.401Z  

```java
class Solution {
    public void mergeArrays(int a[], int b[]) {
        // code here
        int n = a.length;
        int m = b.length;
        int i = n - 1;
        int j = 0;
        while( i >= 0 && j < m) {
            if(a[i] > b[j]){
                int temp = a[i];
                a[i] = b[j];
                b[j] =  temp;
                i--;
                j++;
                //Arrays.sort(b);
            }
            else{
                break;
            }
            //i--;
        }
        Arrays.sort(b);
        Arrays.sort(a);
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/merge-two-sorted-arrays-1587115620/1)