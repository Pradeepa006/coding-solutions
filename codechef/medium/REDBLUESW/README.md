# REDBLUESW

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Red Blue Swaps

You are given a permutation $A$ of the integers $[1, N]$ and a binary array $B$. $B_i = 0$ represents the $i$-th element is coloured red, and $B_i = 1$ represents blue.

You can do the following operation as many times as you want (possibly $0$):

- Choose an index $i$ such that: $1 \le i < N$ $B_i \ne B_{i + 1}$, the colours should be different The red coloured element should be larger than the blue coloured element. For example, if $B_i = 0$ and $B_{i + 1} = 1$, $A_i > A_{i + 1}$ should hold.
- Swap $A_i$ and $A_{i + 1}$, and also swap $B_i$ and $B_{i + 1}$.

Using the above operation, find the number of arrays $A$ possible. Since the answer may be large, find it modulo $998244353$.

### Input Format
- The first line of input will contain a single integer $T$, denoting the number of test cases.
- Each test case consists of multiple lines of input. The first line contains a single integer $N$. The second line contains $N$ integers - $A_1, A_2, \ldots, A_N$. The third line contains $N$ integers - $B_1, B_2, \ldots, B_N$.
### Output Format

For each test case, output on a new line the number of possible arrays $A$ modulo $998244353$.

### Constraints
- $1 \le T \le 10^4$
- $2 \le N \le 5000$
- $1 \le A_i \le N$
- $A_i \ne A_j$ for all $1 \le i \lt j \le N$
- $0 \le B_i \le 1$
- The sum of $N^2$ over all test cases does not exceed $5000^2$.
### Sample 1:
Input
Output

```
4
3
1 2 3
1 0 1
3
3 2 1
1 0 0
3
3 2 1
0 0 1
5
2 3 1 4 5
1 0 1 0 1

```

```
2
1
3
6

```

### Explanation:

 **Test Case 1:**  You can choose index $i = 1$, and swap to get $A = [2, 1, 3]$. Thus, $A = [1, 2, 3]$, the original array and $A = [2, 1, 3]$ are the $2$ possible arrays.

 **Test Case 2:**  You cannot perform any swaps.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-07-15T15:21:15.856Z  

```java
import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here

	}
}

```

---

[View on CodeChef](https://www.codechef.com/problems/REDBLUESW)