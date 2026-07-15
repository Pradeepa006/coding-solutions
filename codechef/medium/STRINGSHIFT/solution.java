import java.util.*;


class Codechef {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            char[] s = sc.next().toCharArray();

            int i = 0;

            // Find first 'z'
            while (i < N && s[i] != 'z')
                i++;

            // Convert consecutive z's to a's
            while (i < N && s[i] == 'z') {
                s[i] = 'a';
                i++;
            }

            System.out.println(new String(s));
        }
    }
}