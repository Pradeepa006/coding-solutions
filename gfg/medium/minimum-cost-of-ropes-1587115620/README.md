# Min Cost to Connect Ropes

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array,  **arr[]**  of rope lengths, connect all ropes into a single rope with the minimum total cost. The cost to connect two ropes is the sum of their lengths. Return the minimum possible cost.

 **Examples:** 

```
Input: arr[] = [4, 3, 2, 6]
Output: 29
Explanation: First connect 2 and 3 to get [4, 5, 6] with a cost of 5, then connect 4 and 5 to get [9, 6] with a cost of 9, and finally connect 9 and 6 to get one rope with a cost of 15, giving a total minimum cost of 29. Any other order, such as connecting 4 and 6 first, results in a higher total cost of 38.
```

```
Input: arr[] = [4, 2, 7, 6, 9]
Output: 62 
Explanation: First, connect ropes 4 and 2, which makes the array [6, 7, 6, 9]. Cost of this operation 4 + 2 = 6. Next, add ropes 6 and 6, which results in [12, 7, 9]. Cost of this operation 6 + 6 = 12. Then, add 7 and 9, which makes the array [12,16]. Cost of this operation 7 + 9 = 16. And finally, add these two which gives [28]. Hence, the total cost is 6 + 12 + 16 + 28 = 62.

```

```
Input: arr[] = [10]
Output: 0
Explanation: Since there is only one rope, no connections are needed, so the cost is 0.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-03T06:05:30.942Z  

```java
class Solution {
    public int minCost(int[] arr) {
        // code here
        // Arrays.sort(arr);
        // int cost = 0 ;
        // int rel = arr[0];
        // for(int i = 1 ; i < arr.length ; i++) {
        //     cost += (rel + arr[i]);
        //     rel = cost;
        // }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0 ; i < arr.length ; i++){
            pq.add(arr[i]);
        }
        
        int cost = 0 ;
        
        while(pq.size() > 1) {
            int f = pq.poll();
            int s = pq.poll();
            cost += (f + s);
            pq.add((f + s));
        }
        return cost;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1)