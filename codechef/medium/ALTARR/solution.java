import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner scan = new Scanner(System.in);

        int T = scan.nextInt();

        while (T-- > 0) {
            int n = scan.nextInt();

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scan.nextInt();
            }

            int p1 = 0; // even index -> even, odd index -> odd
            int p2 = 0; // even index -> odd, odd index -> even

            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    if (arr[i] % 2 == 0)
                        p1++;
                    else
                        p2++;
                } else {
                    if (arr[i] % 2 != 0)
                        p1++;
                    else
                        p2++;
                }
            }

            System.out.println(Math.min(p1, p2));
        }

        scan.close();
    }
}