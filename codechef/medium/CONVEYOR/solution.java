import java.util.*;
class Codechef {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        int T = scan.nextInt();

        while (T-- > 0) {
            int N = scan.nextInt();
            int P = scan.nextInt();

            String S = scan.next();

            int left = 0;
            for (int i = P - 1; i >= 0; i--) {
                if (S.charAt(i) == 'R')
                    left++;
            }

            int right = 0;
            for (int i = P - 1; i < N; i++) {
                if (S.charAt(i) == 'L')
                    right++;
            }

            System.out.println(Math.min(left, right));
        }
    }
}