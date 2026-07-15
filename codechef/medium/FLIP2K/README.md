# FLIP2K

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Fair Flipping (Easy)

 *This is the easy version of the problem. You only need to find the lexicographically minimum string reachable.* 

You're given a  **binary**  string $A$ of length $N$ and an integer $K$ ($1 \le 2K \le N$).

You can modify $A$ using the following operation:

- Choose a subsequence of $A$ with length $2K$ that contains exactly $K$ zeros and $K$ ones.
- Then, flip every character of the chosen subsequence: each $0$ becomes $1$ and each $1$ becomes $0$.

Your task is to find the lexicographically smallest$^\dagger$ string that $A$ can be converted into as a result of using this operation several (possibly, zero) times.

$^\dagger$A binary string $P$ of length $N$ is said to be lexicographically smaller than another binary string $Q$ of length $N$ if and only if there exists an index $i$ ($1 \le i \le N$) such that:

- $P_j = Q_j$ for each $1 \le j \lt i$; and
- $P_i = 0$ but $Q_i = 1$.
### Input Format
- The first line of input will contain a single integer $T$, denoting the number of test cases.
- Each test case consists of two lines of input. The first line of each test case contains two space-separated integers $N$ and $K$. The second line contains a binary string $A$ of length $N$.
### Output Format

For each test case, output on a new line the lexicographically smallest string that $A$ can be converted into.

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
0101
11011
000011

```

### Explanation:

 **Test case $1$:**  $K = 1$, so each operation involves one $0$ and one $1$.
Perform one operation with indices $2$ and $3$. This turns the string into $\texttt{001}$ which is optimal.

 **Test case $2$:**  $K = 2$, so each operation involves two $0$'s and two $1$'s.
Perform one operation choosing all four indices. Every character flips, resulting in $\texttt{0101}$. This is optimal.

 **Test case $3$:**  $K = 2$, so each operation involves two $0$'s and two $1$'s.
It's impossible to even modify the given string since it only contains one $0$. Thus, the answer is the string itself, $\texttt{11011}$.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-07-15T15:20:04.721Z  

```java
import java.util.*;
import java.io.*;
import java.util.*;

class Codechef {
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

        String next() throws IOException {
            StringBuilder sb = new StringBuilder();
            int c;
            do {
                c = read();
            } while (c <= ' ');

            while (c > ' ') {
                sb.append((char) c);
                c = read();
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();
        int t = fs.nextInt();

        while (t-- > 0) {
            int n = fs.nextInt();
            int k = fs.nextInt();
            String s = fs.next();

            int zeros = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '0') zeros++;
            }
            int ones = n - zeros;

            if (zeros < k || ones < k) {
                out.append(s).append('\n');
            } else {
                for (int i = 0; i < zeros; i++) out.append('0');
                for (int i = 0; i < ones; i++) out.append('1');
                out.append('\n');
            }
        }

        System.out.print(out.toString());
    }
}
```

---

[View on CodeChef](https://www.codechef.com/problems/FLIP2K)