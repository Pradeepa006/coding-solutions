# Carpet into Box

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

There is a carpet of a size a *b [length*  breadth]. You are given a box of size c*d. The task is, one has to fit the carpet in the box in a minimum number of moves. 

 **In one move, you can either decrease the length or the breadth of the carpet by half (floor value of its half).** 

Note: One can even turn the carpet by 90 degrees any number of times, wont be counted as a move.

 

 **Example 1:** 

```
Input:
A = 8, B = 13
C = 6, D = 10
Output:
Minimum number of moves: 1
Explanation:
Fold the carpet by breadth, 13/2 i.e. 6, 
so now carpet is 6*8 and can fit fine.

```

 

 **Example 2:** 

```
Input:
A = 4, B = 8
C = 3, D = 10
Output:
Minimum number of moves: 1
Explanation: Fold the carpet by length, 4/2 i.e. 2,
so now carpet is 2*8 and can fit fine.

```

 

 **Your Task:** 
You don't need to read input or print anything. You only need to complete the function **carpetBox()** that takes an integer A, B, C and D as input and returns an integer denoting the minimum numbers of moves required to fit the carpet into the box.

 

 **Expected Time Complexity:** O(max(log(a), log(b))).
 **Expected Auxiliary Space:** O(1).

 

 **Constrains:** 
1<= A,B,C,D <= 109

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-09T13:50:29.478Z  

```java
class Solution {

    int carpetBox(int A, int B, int C, int D) {

        int option1 = count(A, C) + count(B, D);
        int option2 = count(A, D) + count(B, C);

        return Math.min(option1, option2);
    }

    int count(int carpet, int box) {

        int moves = 0;

        while (carpet > box) {
            carpet /= 2;
            moves++;
        }

        return moves;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/carpet-into-box--170645/1)