# Majority Element

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array  **arr[]**. Find the  **majority element**  in the array. If no majority element exists, return  **-1**.

 **Note:**  A majority element in an array is an element that appears  **strictly** more than **arr.size()/2** times in the array.

 **Examples:** 

```
Input: arr[] = [1, 1, 2, 1, 3, 5, 1]
Output: 1
Explanation: Since, 1 is present more than 7/2 times, so it is the majority element.

```

```
Input: arr[] = [7]
Output: 7
Explanation: Since, 7 is single element and present more than 1/2 times, so it is the majority element.
```

```
Input: arr[] = [2, 13]
Output: -1
Explanation: Since, no element is present more than 2/2 times, so there is no majority element.
```

 **Constraints:** 
1 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 105

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-07-26T08:25:08.160Z  

```java
class Solution {
    int majorityElement(int arr[]) {
        // code here
        int count = 0 ;
        int el = arr[0];
        for(int i = 0 ; i < arr.length ; i++){
            if(count == 0 ){
                el = arr[i];
            }
            if(arr[i] == el){
                count++;
            }
            else {
                count--;
            }
        }
        
        count = 0;
        
        for(int i : arr) {
            if(i == el)
                count++;
        }
        if(count > arr.length / 2){
            return el;
        }
        return -1;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/majority-element-1587115620/1)