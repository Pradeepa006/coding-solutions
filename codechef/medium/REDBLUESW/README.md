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
**Submitted:** 2026-07-15T15:22:31.566Z  

```java
import java.util.*;
import java.lang.*;
import java.io.*;
class Codechef {
    static final long MOD = 998244353L;

    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            do {
                c = read();
            } while (c <= ' ');

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];

            for (int i = 0; i < n; i++) a[i] = fs.nextInt();
            for (int i = 0; i < n; i++) b[i] = fs.nextInt();

            int cnt0 = 0, cnt1 = 0;
            for (int x : b) {
                if (x == 0) cnt0++;
                else cnt1++;
            }

            int inv = 0;
            for (int i = 0; i < n; i++) {
                if (b[i] == 0) {
                    inv += cnt1;
                } else {
                    cnt1--;
                }
            }

            long ans = 1L << inv;
            ans %= MOD;
            out.append(ans).append('\n');
        }

        System.out.print(out.toString());
    }
}

```

---

[View on CodeChef](https://www.codechef.com/problems/REDBLUESW)