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
