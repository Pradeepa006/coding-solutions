# FLIP2KHD

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Fair Flipping (Hard)

 *This is the hard version of the problem. You need to also find the minimum number of moves needed to obtain the lexicographically minimum string.* 

You're given a  **binary**  string $A$ of length $N$ and an integer $K$ ($1 \le 2K \le N$).

You can modify $A$ using the following operation:

- Choose a subsequence of $A$ with length $2K$ that contains exactly $K$ zeros and $K$ ones.
- Then, flip every character of the chosen subsequence: each $0$ becomes $1$ and each $1$ becomes $0$.

Your task is to find the lexicographically smallest$^\dagger$ string that $A$ can be converted into as a result of using this operation several (possibly, zero) times.

Additionally, find the minimum number of operations needed to obtain this lexicographically minimum string.

$^\dagger$A binary string $P$ of length $N$ is said to be lexicographically smaller than another binary string $Q$ of length $N$ if and only if there exists an index $i$ ($1 \le i \le N$) such that:

- $P_j = Q_j$ for each $1 \le j \lt i$; and
- $P_i = 0$ but $Q_i = 1$.
### Input Format
- The first line of input will contain a single integer $T$, denoting the number of test cases.
- Each test case consists of two lines of input. The first line of each test case contains two space-separated integers $N$ and $K$. The second line contains a binary string $A$ of length $N$.
### Output Format

For each test case, output two lines:

- The first line should contain the lexicographically smallest string that $A$ can be converted into.
- The second line should contain the minimum number of operations needed to reach this string.
### Constraints
- $1 \leq T \leq 10^5$
- $1 \leq N \leq 2\cdot 10^5$
- $1 \leq 2\cdot K \leq N$
- $A_i \in \{0, 1\}$
- The sum of $N$ over all test cases won't exceed $2\cdot 10^5$.
### Sample 1:
Input
Output

```
4
3 1
010
4 2
1010
5 2
11011
6 2
000101

```

```
001
1
0101
1
11011
0
000011
2

```

### Explanation:

 **Test case $1$:**  $K = 1$, so each operation involves one $0$ and one $1$.
Perform one operation with indices $2$ and $3$. This turns the string into $\texttt{001}$ which is optimal.
One operation is used.

 **Test case $2$:**  $K = 2$, so each operation involves two $0$'s and two $1$'s.
Perform one operation choosing all four indices. Every character flips, resulting in $\texttt{0101}$. This is optimal.
One operation is used.

 **Test case $3$:**  $K = 2$, so each operation involves two $0$'s and two $1$'s.
It's impossible to even modify the given string since it only contains one $0$. Thus, the answer is the string itself, $\texttt{11011}$.
No operations are used.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-07-15T15:31:15.332Z  

```java
import java.util.*;
import java.lang.*;
import java.io.*;

class CodeChef {
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

        String next() throws IOException {
            int c;
            do c = read(); while (c <= ' ' && c != -1);
            StringBuilder sb = new StringBuilder();
            while (c > ' ') {
                sb.append((char) c);
                c = read();
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();
        int T = fs.nextInt();

        while (T-- > 0) {
            int n = fs.nextInt();
            int k = fs.nextInt();
            String s = fs.next();

            int zeros = 0;
            for (int i = 0; i < n; i++) if (s.charAt(i) == '0') zeros++;

            char[] ans = s.toCharArray();
            int ops = 0;

            if (zeros >= k && n - zeros >= k) {
                int needZerosLeft = zeros;
                for (int i = 0; i < n; i++) {
                    if (needZerosLeft > 0 && ans[i] == '1') {
                        ans[i] = '0';
                        ops++;
                        needZerosLeft--;
                    } else if (ans[i] == '0') {
                        needZerosLeft--;
                    }
                }
            }

            out.append(new String(ans)).append('\n');
            out.append(ops).append('\n');
        }

        System.out.print(out.toString());
    }
}
```

---

[View on CodeChef](https://www.codechef.com/problems/FLIP2KHD)