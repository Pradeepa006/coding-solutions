import java.util.*;
import java.io.*;
import java.util.*;

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
            do {
                c = read();
            } while (c <= ' ' && c != -1);

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

    static long countAtLeast(int[] a, int x) {
        int n = a.length;
        int[] pref = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pref[i] = pref[i - 1] + (a[i - 1] >= x ? 1 : -1);
        }

        int[] vals = pref.clone();
        Arrays.sort(vals);
        int m = 1;
        for (int i = 1; i < vals.length; i++) {
            if (vals[i] != vals[m - 1]) vals[m++] = vals[i];
        }

        Fenwick fw = new Fenwick(m + 2);
        long ans = 0;

        for (int p : pref) {
            int idx = lowerBound(vals, m, p) + 1;
            ans += fw.sum(idx - 1);
            fw.add(idx, 1);
        }

        return ans;
    }

    static int lowerBound(int[] arr, int len, int target) {
        int l = 0, r = len;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();
        int T = fs.nextInt();

        while (T-- > 0) {
            int n = fs.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = fs.nextInt();

            long ans = countAtLeast(a, 1) - countAtLeast(a, 2);
            out.append(ans).append('\n');
        }

        System.out.print(out.toString());
    }
}