import java.util.*;
import java.lang.*;

class Codechef {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            int K = sc.nextInt();

            String s = sc.next();

            int zeros = 0;
            for (int i = 0; i < N; i++) {
                if (s.charAt(i) == '0')
                    zeros++;
            }

            int ones = N - zeros;

            if (zeros < K || ones < K) {
                System.out.println(s);
            } else {
                StringBuilder ans = new StringBuilder();

                for (int i = 0; i < zeros; i++)
                    ans.append('0');

                for (int i = 0; i < ones; i++)
                    ans.append('1');

                System.out.println(ans);
            }
        }
    }
}