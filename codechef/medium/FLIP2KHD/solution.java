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