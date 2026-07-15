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
**Submitted:** 2026-07-15T15:28:01.602Z  

```java
import java.util.*;
import java.io.*;
class Codechef {
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream is) {
            in = is;
        }

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
            do c = read(); while (c <= ' ' && c != -1);
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

    static class Fenwick {
        long[] bit;
        int n;

        Fenwick(int n) {
            this.n = n;
            bit = new long[n + 2];
        }

        void add(int idx, long val) {
            for (; idx <= n; idx += idx & -idx) bit[idx] += val;
        }

        long sum(int idx) {
            long res = 0;
            for (; idx > 0; idx -= idx & -idx) res += bit[idx];
            return res;
        }
    }

    static int lowerBound(long[] arr, int len, long target) {
    int l = 0, r = len;
    while (l < r) {
        int mid = (l + r) >>> 1;
        if (arr[mid] < target) l = mid + 1;
        else r = mid;
    }
    return l;
    }

    static long countPositive(long[] pref) {
        int n = pref.length;
        long[] vals = pref.clone();
        Arrays.sort(vals);

        int m = 1;
        for (int i = 1; i < vals.length; i++) {
            if (vals[i] != vals[m - 1]) vals[m++] = vals[i];
        }

        Fenwick fw = new Fenwick(m + 2);
        long ans = 0;

        for (long p : pref) {
            int idx = lowerBound(vals, m, p) + 1;
            ans += fw.sum(idx - 1);
            fw.add(idx, 1);
        }
        return ans;
    }

    static long solve(int[] a, int x) {
        int n = a.length;
        long[] pref = new long[n + 1];
        pref[0] = 0;
        for (int i = 1; i <= n; i++) {
            pref[i] = pref[i - 1] + (a[i - 1] >= x ? 1 : -1);
        }
        return countPositive(pref);
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();
        int T = fs.nextInt();

        while (T-- > 0) {
            int n = fs.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = fs.nextInt();

            long ans = solve(a, 1) - solve(a, 2);
            out.append(ans).append('\n');
        }

        System.out.print(out.toString());
    }
}
```

---

[View on CodeChef](https://www.codechef.com/problems/MEDIANCHANGE)