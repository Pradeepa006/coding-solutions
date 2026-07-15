# MEDIANCHANGE

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Median Change Subarrays

You are given an array $A$ of length $N$.

The  **median**  of an array of length $N$ is defined as its $\left\lceil \frac{N}{2} \right\rceil$-th smallest element. For example, the median of $[4,1,5,3,2]$ is $3$ and the median of $[8,2,4,6]$ is $4$.

For a subarray $[L,R]$, consider modifying its elements in an alternating manner:

- Increase $A_L$ by $1$.
- Decrease $A_{L+1}$ by $1$.
- Increase $A_{L+2}$ by $1$.
- Continue alternating between increasing and decreasing by $1$ all the way till $A_R$.

All elements outside the subarray remain  **unchanged**.

A subarray $[L,R]$ is called  **good**  if the median of the  **entire array**  after this modification is different from its original median.

Find the number of good subarrays of $A$.

### Input Format
- The first line of input will contain a single integer $T$, denoting the number of test cases.
- Each test case consists of two lines of input. The first line of each test case contains a single integer $N$, denoting the length of the array. The second line contains $N$ space-separated integers $A_1, A_2, \ldots, A_N$, denoting the elements of the array.
### Output Format

For each test case, output on a new line the number of good subarrays of $A$.

### Constraints
- $1 \leq T \leq 10^4$
- $1 \leq N \leq 2\cdot10^5$
- $1 \leq A_i \leq N$
- The sum of $N$ over all test cases won't exceed $2\cdot10^5$.
### Sample 1:
Input
Output

```
4
3
3 1 2
4
2 2 2 2
5
5 2 1 3 1
9
9 3 1 5 2 4 2 2 4

```

```
2
1
5
10

```

### Explanation:
- Test case 1: The original median is $2$. Modifying either $[1,3]$ or $[3,3]$ changes the median, so the answer is $2$.
- Test case 2: Only modifying $[1,4]$ changes the median from $2$ to $1$, so the answer is $1$.
- Test case 3: The five valid subarrays are $[1,2]$, $[2,2]$, $[2,3]$, $[2,4]$, and $[2,5]$.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-07-15T15:24:02.845Z  

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

[View on CodeChef](https://www.codechef.com/problems/MEDIANCHANGE)