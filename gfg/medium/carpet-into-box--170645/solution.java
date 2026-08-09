class Solution {

    int carpetBox(int A, int B, int C, int D) {

        int option1 = count(A, C) + count(B, D);
        int option2 = count(A, D) + count(B, C);

        return Math.min(option1, option2);
    }

    int count(int carpet, int box) {

        int moves = 0;

        while (carpet > box) {
            carpet /= 2;
            moves++;
        }

        return moves;
    }
}